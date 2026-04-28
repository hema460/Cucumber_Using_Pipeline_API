package stepDef;

import static io.restassured.RestAssured.given;

import io.cucumber.java.Before;
import utility.AuthUtil;
import utility.Specifications;
import utility.TestContext;

public class Hooks extends Specifications{
TestContext context;

public Hooks(TestContext context) {
    this.context = context;
}
	@Before
	public void setUp() {
	//context.token=AuthUtil.generateToken();
	context.req = given().spec(createUser());
	}
}
