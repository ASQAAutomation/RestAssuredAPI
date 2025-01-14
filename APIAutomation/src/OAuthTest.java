import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import POJOforCourses.GetCourse;
import POJOforCourses.MobileCourseList;
import POJOforCourses.WebAutomationCourseList;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OAuthTest {
	@JsonIgnoreProperties(ignoreUnknown = true)

	public static void main(String[] args) {

		// To get access token, execute below:
		String response = given()
				.formParam("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
				.formParam("client_secret", "erZOWM9g3UtwNRj340YYaK_W").formParam("grant_type", "client_credentials")
				.formParam("scope", "trust").when()
				.post("https://rahulshettyacademy.com/oauthapi/oauth2/resourceOwner/token").asString();

		JsonPath js = new JsonPath(response);
		String access_token = js.getString("access_token");
		System.out.println(access_token);

		// Here for getting any specific value like above for access token, we need to
		// parse and extract key and value from the response
//		 String res=  given().queryParam("access_token", access_token).when().get("https://rahulshettyacademy.com/oauthapi/getCourseDetails").asString();
//		 
//		 //System.out.println(res);
//		 JsonPath js1=  new JsonPath(res);
//		 String instructor = js1.getString("instructor");
//		 System.out.println(instructor);
//		 String linkedIn = js1.getString("linkedIn");
//		 System.out.println(linkedIn);
//		   
		
		
		String [] eTitle = {"Selenium Webdriver Java","Cypress","yttr"};

		// Here we are going to user POJO classes for extract the values from response (deserialization), where we need to convert our whole JSON response in Java Object
		// and for doing that, we need one supportive class
		GetCourse gc = given().queryParam("access_token", access_token).when()
				.get("https://rahulshettyacademy.com/oauthapi/getCourseDetails").as(GetCourse.class);

		 System.out.println(gc.getLinkedIn());
		 //Below one is hardcoded with indexing as get(0)
		System.out.println(gc.getCourses().getMobile().get(0).getCourseTitle());

		// Below one is dynamic, where we will scan the whole response and if match is found then, it will pull the value of it.

		List<MobileCourseList> allMobilecourses = gc.getCourses().getMobile();
		 for (int i=0; i<allMobilecourses.size();i++) {
			 if(allMobilecourses.get(i).getCourseTitle().equalsIgnoreCase("Appium-Mobile Automation using Java")) {
				 System.out.println(allMobilecourses.get(i).getCourseTitle());
				 System.out.println(  allMobilecourses.get(i).getPrice());
			 }
			 
			 
		 }
		 
//		 //Pint all course title for WebAutomation
		      List<WebAutomationCourseList> allwebAutomationourses = gc.getCourses().getWebAutomation();
		      
		      for (int i=0; i<allwebAutomationourses.size(); i++) {
		    	  System.out.println(allwebAutomationourses.get(i).getCourseTitle());
		    	  
		      }
		      
		      //Fetch all coursetitle for WebAutomation and compare from expected title created/store above
		
		List<WebAutomationCourseList> actualTitle = gc.getCourses().getWebAutomation();
		ArrayList<String> WebactualTitle = new ArrayList<String>();
		for (int i=0; i<actualTitle.size();i++) {
			WebactualTitle.add(actualTitle.get(i).getCourseTitle());
		}
		 
		//Convert above expected title from Array to ArrayList using asList method
		
		    List<String> Webexpectedtitle = Arrays.asList(eTitle);
		    
		    Assert.assertTrue(WebactualTitle.equals(Webexpectedtitle));
		
		
		 
		
		

	}

}
