package files;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class DynamicJson {
	
	@Test
	public void addBook() {
		RestAssured.baseURI="http://216.10.245.166";
			String response = given().log().all().header("Content-Type","application/json")
			.body(Oldpayload.Addbook("Akhwert","98765")).when().post("/Library/Addbook.php")
			.then().assertThat().statusCode(200).extract().response().asString();
		
	    JsonPath js = ReUsableMethods.rawToJson(response);
	     String ID = js.get("ID");
	     System.out.println(ID);
	
	}
	
	
	

}
 