package model;

import java.io.Serializable;

public class TableModel implements Serializable
{
	
  private String time ; 
  private  String place;
  private String stuff;
  private String courseName;
public String getCourseName() {
	return courseName;
}
public TableModel(String time,String place,String stuff,String courseName) 
{
	this.time=time;
	this.place=place;
	this.stuff=stuff;
	this.courseName=courseName;
	
	
}
public void setCourseName(String courseName) {
	this.courseName = courseName;
}
public String getTime() {
	return time;
}
public void setTime(String time) {
	this.time = time;
}
public String getPlace() {
	return place;
}
public void setPlace(String place) {
	this.place = place;
}
public String getStuff() {
	return stuff;
}
public void setStuff(String stuff) {
	this.stuff = stuff;
}
  
}
