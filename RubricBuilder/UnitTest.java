package RubricBuilder;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import static org.junit.Assert.assertEquals;


import java.util.ArrayList;
import java.util.List;


public class UnitTest {

	/**
	 * Class where all tests will be created and stored Tests are ran from
	 * TestRunner
	 */

	Driver driver;
	
	//Tests that when a new rubric is created, it is created correctly
	@Test
	public void testNewRubricCreated() {

		 driver = new Driver();

		List<String> criteria = new ArrayList<>();
		criteria.add(new String("Geography"));
		criteria.add(new String("History"));
		criteria.add(new String("Maths"));

		Rubric rubric = driver.createRubric(criteria, "Subjects");
		
		Assertions.assertFalse(driver.getAllRubrics().isEmpty());
		Assertions.assertTrue(rubric.getCriteria().equals(criteria));
		Assertions.assertTrue(rubric.getTitle().equals("Subjects"));

	}

	//Tests that the rubric list returned is correct in size and content
	@Test
	public void testAllRubricsReturned() {

		List<Rubric>expectedRubrics= new ArrayList<Rubric>();
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

		driver.createRubric(criteria, "Subjects");
		driver.createRubric(criteriaWeather, "Weather");

		List<Rubric>actualRubrics = driver.getAllRubrics();
		
		Assertions.assertEquals(expectedRubrics.size(),actualRubrics.size());
		assertEquals(actualRubrics.get(0).getCriteria(),criteria);
		assertEquals(actualRubrics.get(1).getCriteria(),criteriaWeather);
		assertEquals(actualRubrics.get(0).getTitle(),"Subjects");
		assertEquals(actualRubrics.get(1).getTitle(),"Weather");	
	}
	
	//Tests that the specific rubric returned is the correct one that was asked for
		@Test
		public void testSpecificRubricReturned() {
		
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

			driver.createRubric(criteria, "Subjects");
			driver.createRubric(criteriaWeather, "Weather");

			Rubric specificRubric=driver.getSpecificRubric("Weather");
			
			assertEquals(specificRubric.getCriteria(),criteriaWeather);
			assertEquals(specificRubric.getTitle(),"Weather");

	}
}
