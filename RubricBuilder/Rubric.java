package RubricBuilder;

import java.util.ArrayList;
import java.util.List;

public class Rubric {

    /**
     * Object class of Rubric
     * @param criteria, the list of string names of criteria that will be the top column of the table
     * List of student grades will be set to the object, forming the lower rows of the table
     */

    List<String> criteria=new ArrayList<String>();
    List<StudentGrade>studentGrades=new ArrayList<>();

    public Rubric(List<String> criteria) {
        this.criteria = criteria;
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
