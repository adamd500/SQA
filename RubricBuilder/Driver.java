package RubricBuilder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import JUnit.TestRunner;

public class Driver {

	/**
	 * Class where the functionality methods are stored.
	 * Tests are called from the main method of this class.
	 * @param criteria - the list of strings passed from the test class representing the criteria of the rubric
	 * @param title - the title of the rubric that is used to identify it among a list
	 * @param studentScores - a hashmap of student criteria and its corresponding score
	 * @param studentName - the name of the student associated with the scores
	 * @param grades- the list of student grade objects containing student scores and student name
	 * @param selectedRubric- the rubric of choice of which the student grades will have calculations performed on
	 * @param criterion - the specific criterion to have calculations performed on
	 * @param minOrMax - the position of the array being asked for  
	 */

	List<Rubric> rubrics = new ArrayList<Rubric>();
	List<StudentGrade> studentGrades = new ArrayList<StudentGrade>();

	public Driver() {
	}

	public Rubric createRubric(List<String> criteria, List<StudentGrade>grades,String title) {
		Rubric rubric = new Rubric(title);
		rubric.setCriteria(criteria);
		rubric.setStudentGrades(grades);
		rubrics.add(rubric);
		return rubric;
	}

	
	public List<Rubric> getAllRubrics() {
		return rubrics;
	}

	
	public Rubric getSpecificRubric(String title) {
		for (Rubric rubric : rubrics) {
			if (rubric.getTitle().equalsIgnoreCase(title)) {
				return rubric;
			}
		}
		return null;
	}

	
	public StudentGrade createGrade(String studentName,HashMap<String,Integer>studentScores) {
		StudentGrade studentGrade = new StudentGrade(studentName,studentScores);
		studentGrades.add(studentGrade);
		return studentGrade;
	}
	
	public List<StudentGrade>getAllStudentGrades(){
		return studentGrades;
	}
	
	public List<StudentGrade>getAllStudentGradesByRubric(String title){
		
		List<StudentGrade>gradeMatches= new ArrayList<StudentGrade>();
		
		for(Rubric thisRubric : rubrics) {
			if(thisRubric.getTitle().equalsIgnoreCase(title)) {
				for(StudentGrade thisGrade: thisRubric.getStudentGrades()) {
					gradeMatches.add(thisGrade);
				}
			}
		}
		return gradeMatches;
	}
	
	
	
	public int getAverage(Rubric selectedRubric, String criterion) {
		
		 int total =0;
		for(StudentGrade thisGrade :selectedRubric.getStudentGrades()) {
			total = total+thisGrade.getStudentScore().get(criterion);
		}
		int average = Math.round(total/selectedRubric.getStudentGrades().size());

		return average;
	}
	
	
	
	public int getRange(Rubric selectedRubric,String criterion,String minOrMax) {
		 List<Integer>scores = new ArrayList<Integer>();
			int result;

			for(StudentGrade thisGrade :selectedRubric.getStudentGrades()) {
				scores.add(thisGrade.getStudentScore().get(criterion));
			}
			
			Collections.sort(scores);
			if(minOrMax.equalsIgnoreCase("Min")) {
				result = scores.get(0);
			}else {
				result = scores.get(scores.size()-1);
			}
			return result;
	}
	
	public double getStandardDeviation(Rubric selectedRubric,String criterion) {
	
		int average = getAverage( selectedRubric, criterion);
		
		int result=0;
		for(int i=0; i<selectedRubric.getStudentGrades().size();i++) {
			result+=Math.pow(selectedRubric.getStudentGrades().get(i).getStudentScore().get(criterion) - average, 2);
		}
		
		double sum = result/(selectedRubric.getStudentGrades().size()-1);
		double deviation = Math.sqrt(sum);
		
		return deviation;
	}
	
	
	public static void main(String[] args) {

		Result result = JUnitCore.runClasses(UnitTest.class);

		for (Failure failure : result.getFailures()) {
			System.out.println(failure.toString());
		}
		System.out.println(result.wasSuccessful());
	}
	
}
