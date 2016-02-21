package model;

import java.io.Serializable;

public class GradeModel implements Serializable {
private String term_work;
private String exam_work;
private String grade;
private String result;
private String courseName;
public String getCourseName() {
	return courseName;
}public void setCourseName(String courseName) {
	this.courseName = courseName;
}
public GradeModel() {
	// TODO Auto-generated constructor stub
}public String getExam_work() {
	return exam_work;
}public String getGrade() {
	return grade;
}
public String getTerm_work() {
	return term_work;
}public void setExam_work(String exam_work) {
	this.exam_work = exam_work;
}public String getResult() {
	return result;
}public void setGrade(String grade) {
	this.grade = grade;
}public void setResult(String result) {
	this.result = result;
}public void setTerm_work(String term_work) {
	this.term_work = term_work;
}
}
