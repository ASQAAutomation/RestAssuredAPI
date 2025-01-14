package POJOforECom;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.given;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;

import POJOforCourses.GetCourse;

public class ECommerceAPI {

	public static void main(String[] args) {

		
		//Authorization Token generation script
   RequestSpecification req = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").setContentType(ContentType.JSON).build();
   LoginRequestBody login = new LoginRequestBody();
   login.setUserEmail("meetakhil12@gmail.com");
   login.setUserPassword("Rahulshetty@1234");
   RequestSpecification loginreq = given().spec(req).body(login);
   LoginResponseBodyDeserialize loginres = loginreq.when().post("/api/ecom/auth/login").then().extract().response().as(LoginResponseBodyDeserialize.class);
    String token = loginres.getToken();
    String userID = loginres.getUserId();
    //System.out.println(token);
    //System.out.println(userID);
    
    //Add product script
    
    RequestSpecification addProductbasereq = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").addHeader("Authorization", token).build();
    RequestSpecification addProductreq = given().spec(addProductbasereq).param("productName", "AkhilProduct").param("productAddedBy", userID).param("productCategory", "fashion")
    .param("productSubCategory", "shirts").param("productPrice", 1478).param("productDescription", "PUMA").param("productFor", "Men")
    .multiPart("productImage",new File("C:\\Users\\AkhilAnu\\OneDrive\\Desktop\\shoes.png"));
    
    String addproductresponse = addProductreq.when().post("/api/ecom/product/add-product").then().extract().response().asString();
    JsonPath js = new JsonPath(addproductresponse);
    String productID = js.get("productId");
    System.out.println(productID);
    
    //Create Order
    
    OrderDetail orderDetails = new OrderDetail();
    orderDetails.setCountry("India");
    orderDetails.setProductOrderedId(productID);
    List<OrderDetail> orderDetailsList = new ArrayList<OrderDetail>();
    orderDetailsList.add(orderDetails);
    Orders orders = new Orders();
    orders.setOrders(orderDetailsList);
    
    
    RequestSpecification createOrderBaseReq =  new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").addHeader("Authorization", token).setContentType(ContentType.JSON).build();
    RequestSpecification createOrderReq = given().spec(createOrderBaseReq).body(orders);
    String createOrderRes = createOrderReq.when().post("/api/ecom/order/create-order").then().extract().response().asString();
    
    System.out.println(createOrderRes);
    
    JsonPath js2 = new JsonPath(createOrderRes);
    List<String> orderID = js2.get("orders");
    System.out.println(orderID);
    
    
    
    
    //View Order
    //RequestSpecification viewOrderbasereq = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").addHeader("Authorization", token).addQueryParam("id", orderID).build();
    
               getOrderDetails viewOrderDetails = given().header("Authorization", token).queryParam("id", orderID).when()
                .get("https://rahulshettyacademy.com/api/ecom/order/get-orders-details").as(getOrderDetails.class);
               
               //System.out.println(viewOrderDetails.getData().getOrderBy());
               
               
    // Delete Product and also pass Path Parameter
               
               RequestSpecification deleteProdBaseReq =  new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").addHeader("Authorization", token).setContentType(ContentType.JSON).build(); 
               
               RequestSpecification deleteProdreq = given().spec(deleteProdBaseReq).pathParam("productId", productID);
               String deleteProdRes = deleteProdreq.when().delete("https://rahulshettyacademy.com/api/ecom/product/delete-product/{productId}")
               .then().log().all().extract().response().asString();
               JsonPath js4 = new JsonPath(deleteProdRes);
               Assert.assertEquals("Product Deleted Successfully", js4.get("message"));               



	}

}
