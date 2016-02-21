package model;
import java.io.Serializable;

public class AttendanceModel implements Serializable{
	private String lab;
	private String sec;
	public AttendanceModel() {
		lab="0";
		sec="0";
	}
	public AttendanceModel(String lab, String sec) {
		this.lab=lab;
		this.sec=sec;
	}
	public String getLab() {
		return lab;
	}
	public void setLab(String lab) {
		this.lab = lab;
	}
	public void setSec(String sec) {
		this.sec = sec;
	}
	public String getSec() {
		return sec;
	}

}
