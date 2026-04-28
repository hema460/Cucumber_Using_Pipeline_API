package utility;
import static io.restassured.RestAssured.*;
public class AuthUtil {
	
	 public static String generateToken() {

	        return given()
	                .baseUri("https://example.com")
	                .body("")
	        .when()
	                .post("/auth")
	        .then()
	                .extract()
	                .path("token");
	    }

}
