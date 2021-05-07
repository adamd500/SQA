package RubricBuilder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class StudentGrade {

    /**
     * Object class of StudentGrade
     * @param studentName, the full name of the student being stored
     * @param studentScore, the list of scores in order to fit into the rubric
     */

    String studentName;
  //  List<Integer> studentScore= new ArrayList<Integer>();
    HashMap<String,Integer>studentScore = new HashMap();
    
    
	public StudentGrade(String studentName, HashMap<String, Integer> studentScore) {
		super();
		this.studentName = studentName;
		this.studentScore = studentScore;
	}
	
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public HashMap<String, Integer> getStudentScore() {
		return studentScore;
	}
	public void setStudentScore(HashMap<String, Integer> studentScore) {
		this.studentScore = studentScore;
	}
    
//    public StudentGrade(String studentName, List<Integer> studentScore) {
//        this.studentName = studentName;
//        this.studentScore = studentScore;
//    }
//
//    public String getStudentName() {
//        return studentName;
//    }
//
//    public void setStudentName(String studentName) {
//        this.studentName = studentName;
//    }
//
//    public List<Integer> getStudentScore() {
//        return studentScore;
//    }
//
//    public void setStudentScore(List<Integer> studentScore) {
//        this.studentScore = studentScore;
//    }
    
}
