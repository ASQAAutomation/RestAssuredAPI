package POJOforMAPS;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import static io.restassured.RestAssured.*;
import java.util.ArrayList;
import java.util.List;


public class SpecBuilder {
	
	public static void main(String[] args) {
		
		List <String> typeslist = new ArrayList<String>(); //since types item is expecting list of items, so passing all values in the variable
		locationdata l = new locationdata(); //for nested JSON like location, create object of that class and access the data
		RestAssured.baseURI="https://rahulshettyacademy.com";
		
		AddPlace addplace = new AddPlace();
		addplace.setAccuracy(50);
		addplace.setAddress("Greater Noida West");
		addplace.setLanguage("Hindi - Hi");
		addplace.setName("Ace City");
		addplace.setPhone_number("(+91) 983 893 3937");
		addplace.setWebsite("http://google.com");
		l.setLat(-38.383494);
		l.setLng(33.427362);
		addplace.setLocation(l);
		typeslist.add("shoe park");
		typeslist.add("shop");
		addplace.setTypes(typeslist);
		
		
		
		
		
		//Creating Request Spec Build
		RequestSpecification req = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").addQueryParam("key", "qaclick123")
		.setContentType(ContentType.JSON).build();
		
		
			RequestSpecification res = given().spec(req).body(addplace);//Since here we segregated the request, so our response is no more a String return type. It is now request specification type
				
		ResponseSpecification resspec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();	
			
			
				//Pass the above RequestSpecification res to get the response	
			Response res1 = res.when().post("/maps/api/place/add/json")
			.then().spec(resspec).extract().response();
			
			System.out.println(res1);
			
			
			
			
		
	}
	

}
