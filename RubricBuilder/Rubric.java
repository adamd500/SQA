package RubricBuilder;

import java.util.ArrayList;
import java.util.List;

public class Rubric {

    /**
     * Object class of Rubric
     * @param title, the title of the rubric which will be used to create a rubric object
     * List of student grades will be set to the object, forming the lower rows of the table
     */

    List<String> criteria=new ArrayList<String>();
    List<StudentGrade>studentGrades=new ArrayList<>();
    String title;
    

    public Rubric(String title) {
		super();
		this.title = title;
	}



	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<String> getCriteria() {
        return criteria;
    }

    public void setCriteria(List<String> criteria) {
        this.criteria = criteria;
    }

    public List<StudentGrade> getStudentGrades() {
        return studentGrades;
    }

    public void setStudentGrades(List<StudentGrade> studentGrades) {
        this.studentGrades = studentGrades;
    }





}
