package stepDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import payLoads.PayLoads;
import utility.Specifications;
import utility.TestContext;
import static io.restassured.RestAssured.*;

import org.testng.Assert;

public class AddPlaceStepDef extends Specifications {
	
	ResponseSpecification res;
	//Response response;
	TestContext context;

	public AddPlaceStepDef(TestContext context) {
		this.context = context;
	}
	//@Given("User has token")
	/*public void user_has_token() {
	    context.token = AuthUtil.generateToken();
	    context.req.header("Authorization", "Bearer " + context.token);
	}*/

	@Given("Add Place payload")
	public void add_place_payload() {
		context.req=context.req.log().all().body(PayLoads.postPayload());
	}

	@When("User calls {string} with POST request")
	public void user_calls_with_post_request(String postEndPoint) {
		context.response = context.req.when().post(getConfigEndPoints(postEndPoint));
	}

	@Then("API call is successful with status code {int}")
	public void api_call_is_successful_with_status_code(Integer statuscode) {
		context.response.then().log().all().spec(postResponse(statuscode));

	}

	@Then("{string} in response body is {string}")
	public void in_response_body_is(String key, String expectValue) {
		String status = context.response.path(key);
		System.out.println("status is " + status);
		Assert.assertEquals(status, expectValue);
	}

	@Then("extract place_id from response")
	public void extract_place_id_from_response() {
		context.place_id = context.response.path("place_id");
		System.out.println("placeid is " + context.place_id);
	}
	
	  @Given("Get Place payload using place_id")
	  public void get_place_payload_using_place_id() { 
		 
		  //place_id=0f5f61788a3fa3b10f8015ce05ccda2f&key=qaclick123
		context.req=given().log().all().spec(createUser()).queryParam("place_id", context.place_id);
		
	  }
	  
	  @When("User calls {string} with GET request") 
	  public void user_calls_with_get_request(String getRequest) { 
		  context.response=context.req.when().get(getConfigEndPoints(getRequest));
		
	  }
	 

}
