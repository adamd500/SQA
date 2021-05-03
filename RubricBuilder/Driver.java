package RubricBuilder;

import java.util.ArrayList;
import java.util.List;

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
	 */

	List<Rubric> rubrics = new ArrayList<Rubric>();

	public Driver() {

	}

	public Rubric createRubric(List<String> criteria, String title) {

		Rubric rubric = new Rubric(title);
		rubric.setCriteria(criteria);
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

	public static void main(String[] args) {

		Result result = JUnitCore.runClasses(UnitTest.class);

		for (Failure failure : result.getFailures()) {
			System.out.println(failure.toString());
		}
		System.out.println(result.wasSuccessful());
	}
	
}
