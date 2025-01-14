import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

import files.payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class LibraryAPI {

	@Test (dataProvider = "Booksdata")
	
	//since dataprovider is returning 2 elements, so we have to declare that much of element as args in method... 
 
	public static void addBooks(String isbn, String aisle) {

		RestAssured.baseURI = "http://216.10.245.166";
		String res = given().header("Content-Type", "application/json").body(payload.AddBooks(isbn,aisle)).when()
				.post("/Library/Addbook.php").then().assertThat().statusCode(200).extract().response().asString();

		JsonPath js = new JsonPath(res);
		String bookID = js.get("ID");
		System.out.println(bookID);
		}
	
	@DataProvider (name = "Booksdata")
	public Object[][] getbodydata() {
		//array=collection of elements
	   //multidimensional array = collection of arrays
	  //return new Object[][] {{array1},{array2},{array3}};
		
		return new Object[][] {{"bcde","2278"},{"bvcfr","5682"},{"gsfdew","65984"}};
	}
	

}
