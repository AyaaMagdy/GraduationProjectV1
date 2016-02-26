package model;

public class StaffEmails {
private String staffName;
private String staffemail;
private String department;
private String flag;
public String getDepartment() {
	return department;

}public String getStaffemail() {
	return staffemail;
}public String getStaffName() {
	return staffName;
}public void setDepartment(String department) {
	this.department = department;

}public void setStaffName(String staffName) {
	this.staffName = staffName;
}public void setStaffemail(String staffemail) {
	this.staffemail = staffemail;
}
public String getFlag() {
	return flag;
}public void setFlag(String flag) {
	this.flag = flag;
}
}
