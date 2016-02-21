package model;

import java.io.Serializable;

public class Courses implements Serializable {
	private String courseName;
	private String courseID;
	public Courses() {
		// TODO Auto-generated constructor stub
	}
	
	public Courses(String courseName,String courseID) {
		this.courseName = courseName ;
		this.courseID = courseID ;
	}
	
	public String getCourseID() {
		return courseID;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseID(String courseID) {
		this.courseID = courseID;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

}
