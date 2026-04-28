package utility;

import java.util.ResourceBundle;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.ResponseSpecification;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class Specifications {
	
	public static String getConfigEndPoints(String key) {
		ResourceBundle bundle=ResourceBundle.getBundle("config");
	
		
		return bundle.getString(key);
	}
	
	public static RequestSpecification createUser() {
		RequestSpecification spec=new RequestSpecBuilder().setBaseUri(getConfigEndPoints("base_URI")).addQueryParam("key","qaclick123").addHeader("Content-Type", "application/json").build();
	/*public RequestSpecification createUser(String token) {
	    return new RequestSpecBuilder()
	            .setBaseUri("https://example.com")
	            .addHeader("Authorization", "Bearer " + token)
	            .setContentType(ContentType.JSON)
	            .build();
	}*/
		return spec;
	}
	
	public static ResponseSpecification postResponse(int statuscode  ) {
		ResponseSpecification resspec=new ResponseSpecBuilder().expectContentType(ContentType.JSON).expectStatusCode(statuscode).build();
		
	return resspec;
	}
	
}
