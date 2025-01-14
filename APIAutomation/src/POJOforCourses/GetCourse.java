package POJOforCourses;

public class GetCourse {

 private String url;
 private String services;
 private String expertise;
 private Courses courses; // Courses class is imported and datatype of the courses var is now be defined by Courses class whether it is String or any other
 private String instructor;
 private String linkedIn;
 
 
 public String getURL() {
	return url;
}
public void setURL(String url) {
	this.url = url;
}
public String getServices() {
	return services;
}
public void setServices(String services) {
	this.services = services;
}
public String getExpertise() {
	return expertise;
}
public void setExpertise(String expertise) {
	this.expertise = expertise;
}
public POJOforCourses.Courses getCourses() {
	return courses;
}
public void setCourses(Courses courses) { // here return type for var is not String, it will defined by Courses class's method
	this.courses = courses;
}
public String getInstructor() {
	return instructor;
}
public void setInstructor(String instructor) {
	this.instructor = instructor;
}
public String getLinkedIn() {
	return linkedIn;
}
public void setLinkedIn(String linkedIn) {
	this.linkedIn = linkedIn;
}

 
 
 
 
 
 
 
 
	
	
	

}
