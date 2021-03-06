package RubricBuilder;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UnitTest {

	/**
	 * Class where all tests will be created and stored Tests are ran from
	 * TestRunner
	 */

	Driver driver;

	// Tests that when a new rubric is created, it is created correctly
	@Test
	public void testNewRubricCreated() {

		driver = new Driver();

		List<String> criteria = new ArrayList<>();
		criteria.add(new String("Geography"));
		criteria.add(new String("History"));
		criteria.add(new String("Maths"));

		Rubric rubric = driver.createRubric(criteria, null, "Subjects");

		Assertions.assertFalse(driver.getAllRubrics().isEmpty());
		assertEquals(criteria, rubric.getCriteria());
		assertEquals("Subjects", rubric.getTitle());

	}

	// Tests that the rubric list returned is correct in size and content
	@Test
	public void testSpecificAndAllRubricsReturned() {

		List<Rubric> expectedRubrics = new ArrayList<Rubric>();
		driver = new Driver();

		Rubric rubric = new Rubric("Subjects");
		List<String> criteria = new ArrayList<>();
		criteria.add(new String("Geography"));
		criteria.add(new String("History"));
		criteria.add(new String("Maths"));

		Rubric rubric2 = new Rubric("Weather");
		List<String> criteriaWeather = new ArrayList<>();
		criteriaWeather.add(new String("Hot"));
		criteriaWeather.add(new String("Warm"));
		criteriaWeather.add(new String("Cold"));
		rubric2.setCriteria(criteriaWeather);

		expectedRubrics.add(rubric);
		expectedRubrics.add(rubric2);

		driver.createRubric(criteria, null, "Subjects");
		driver.createRubric(criteriaWeather, null, "Weather");

		List<Rubric> actualRubrics = driver.getAllRubrics();

		//Testing all rubrics returned
		Assertions.assertEquals(expectedRubrics.size(), actualRubrics.size());
		assertEquals(criteria, actualRubrics.get(0).getCriteria());
		assertEquals(criteriaWeather, actualRubrics.get(1).getCriteria());
		assertEquals("Subjects", actualRubrics.get(0).getTitle());
		assertEquals("Weather", actualRubrics.get(1).getTitle());
		
		//Testing specific rubric returned
		Rubric specificRubric = driver.getSpecificRubric("Weather");

		assertEquals(criteriaWeather, specificRubric.getCriteria());
		assertEquals("Weather", specificRubric.getTitle());
	}

	
	// Test Student Grade creation adding grade for criterion
	@Test
	public void testStudentGradeCreation() {

		driver = new Driver();

		HashMap<String, Integer> studentScores = new HashMap();
		studentScores.put("Geography", 75);

		StudentGrade studentGrade = driver.createGrade("Adam Devlin", studentScores);

		Assertions.assertFalse(driver.getAllStudentGrades().isEmpty());
		assertEquals("Adam Devlin", studentGrade.getStudentName());
		assertEquals(studentScores, studentGrade.getStudentScore());

	}

	// Test the correct student grades are returned when passed a specific rubric
	@Test
	public void testStudentGradeByRubric() {

		driver = new Driver();
		String history = "History";
		String geography = "Geography";

		List<String> criteria = new ArrayList<>();
		criteria.add(geography);
		criteria.add(history);

		HashMap<String, Integer> student1Scores = new HashMap();
		student1Scores.put(geography, 75);
		student1Scores.put(history, 80);
		StudentGrade student1Grade = driver.createGrade("Adam Devlin", student1Scores);

		HashMap<String, Integer> student2Scores = new HashMap();
		student2Scores.put(geography, 90);
		student2Scores.put(history, 75);
		StudentGrade student2Grade = driver.createGrade("Adam Devlin", student2Scores);

		List<StudentGrade> expectedStudentGrades = new ArrayList<StudentGrade>();
		expectedStudentGrades.add(student1Grade);
		expectedStudentGrades.add(student2Grade);

		driver.createRubric(criteria, expectedStudentGrades, "Subjects");

		List<StudentGrade> actualGrades = driver.getAllStudentGradesByRubric("Subjects");

		assertEquals(expectedStudentGrades, actualGrades);

	}

	@Test
	public void testCalculations() {

		driver = new Driver();
		String history = "History";
		String geography = "Geography";

		List<String> criteria = new ArrayList<>();
		criteria.add(geography);
		criteria.add(history);

		HashMap<String, Integer> student1Scores = new HashMap();
		student1Scores.put(geography, 75);
		student1Scores.put(history, 80);
		StudentGrade student1Grade = driver.createGrade("John Reilly", student1Scores);

		HashMap<String, Integer> student2Scores = new HashMap();
		student2Scores.put(geography, 90);
		student2Scores.put(history, 75);
		StudentGrade student2Grade = driver.createGrade("Adam Devlin", student2Scores);
		
		HashMap<String, Integer> student3Scores = new HashMap();
		student3Scores.put(geography, 90);
		student3Scores.put(history, 100);
		StudentGrade student3Grade = driver.createGrade("Mark Smith", student3Scores);

		List<StudentGrade> expectedStudentGrades = new ArrayList<StudentGrade>();
		expectedStudentGrades.add(student1Grade);
		expectedStudentGrades.add(student2Grade);
		expectedStudentGrades.add(student3Grade);

		Rubric rub = driver.createRubric(criteria, expectedStudentGrades, "Subjects");

		//Test average
		int actualResult = driver.getAverage(rub, "History");
		assertEquals(85, actualResult);
		
		//Test min
		int actualMin = driver.getRange(rub, "History", "Min");
		assertEquals(75,actualMin);
		
		//Test max
		int actualMax = driver.getRange(rub, "History", "Max");
		assertEquals(100,actualMax);
		
		//Test standard deviation
		double actualStandardDeviation = driver.getStandardDeviation(rub, "History");
		assertEquals(13.228,actualStandardDeviation,0.001);
		
	}
	

}
