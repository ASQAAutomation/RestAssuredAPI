package POJOforMAPS;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.List;


public class serializeTest {
	
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
		
		
		
		
			String res = given().queryParam("key", "qaclick123").body(addplace).when().post("/maps/api/place/add/json")
					.then().assertThat().statusCode(200).extract().response().asString();
			
			System.out.println(res);
			
			
			
			
		
	}
	
	
	
	
	
	
	

}
