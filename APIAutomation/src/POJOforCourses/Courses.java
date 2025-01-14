package POJOforCourses;

import java.util.List;

public class Courses {
	
// WebAutomationCourseList,APICourseList & MobileCourseList class is used as datatype for vars and datatype of the courses var is now be defined by WebAutomationCourseList class whether it is String or any other
//Since WebAutomationCourseList,APICourseList & MobileCourseList are itself having list of items in the form of array, we have to let our system know it via passing the class name as LIST 
	
	
	private List<WebAutomationCourseList> webAutomation;
	private List<APICourseList> api;
	private List<MobileCourseList> mobile;

	
	
	public List<WebAutomationCourseList> getWebAutomation() { //// here return type for var is not String, it will defined by WebAutomationCourseList class's method
		return webAutomation;
	}

	public void setWebAutoamtion(List<WebAutomationCourseList> webAutomation) {// here return type for var is not String, it will defined by WebAutomationCourseList class's method
		this.webAutomation = webAutomation;
	}

	public List<APICourseList> getAPI() {
		return api;
	}

	public void setAPI(List<APICourseList> api) {
		this.api = api;
	}

	public List<MobileCourseList> getMobile() {
		return mobile;
	}

	public void setMobile(List<MobileCourseList> mobile) {
		this.mobile = mobile;
	}

}
