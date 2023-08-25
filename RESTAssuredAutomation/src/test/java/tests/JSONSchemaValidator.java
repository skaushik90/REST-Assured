package tests;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;
import static io.restassured.module.jsv.JsonSchemaValidator.*;

public class JSONSchemaValidator {

	@Test
	public void testGet() {
		baseURI = "https://reqres.in";
		given().get("/api/users?page=2").then()
		.assertThat().body(matchesJsonSchemaInClasspath("schema.json")).statusCode(200);
	}

}
