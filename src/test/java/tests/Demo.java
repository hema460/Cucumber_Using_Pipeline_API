package tests;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;
public class Demo {
	

	 TestContext context = new TestContext();
	@Test
public void post() {
	baseURI="https://rahulshettyacademy.com";
	Response res=given().queryParam("key","qaclick123").header("Content-Type","application/json").body("{\n" +
	        "  \"location\": {\n" +
	        "    \"lat\": -38.383494,\n" +
	        "    \"lng\": 33.427362\n" +
	        "  },\n" +
	        "  \"accuracy\": 50,\n" +
	        "  \"name\": \"Rahul Shetty Academy\",\n" +
	        "  \"phone_number\": \"(+91) 983 893 3937\",\n" +
	        "  \"address\": \"29, side layout, cohen 09\",\n" +
	        "  \"types\": [\n" +
	        "    \"shoe park\",\n" +
	        "    \"shop\"\n" +
	        "  ],\n" +
	        "  \"website\": \"http://google.com\",\n" +
	        "  \"language\": \"French-IN\"\n" +
	        "}")
            .when().post("/maps/api/place/add/json").then().extract().response();
            
	context.place_id=res.path("place_id");
	
	System.out.println("resposne is"+res.asString());
	
	System.out.println("place id is"+context.place_id);
            

}

}
