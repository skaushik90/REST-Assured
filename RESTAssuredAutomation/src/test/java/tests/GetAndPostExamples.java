package tests;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

public class GetAndPostExamples {
	
	@Test
	public void testGet() {
		baseURI = "https://reqres.in";
		given().get("/api/users?page=2").then().statusCode(200).
		body("data[4].first_name", equalTo("George")).
		body("data.first_name", hasItems("George", "Rachel")).log().all();
	}

	@Test
	public void testPost() {
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("name", "Kaushik");
//		map.put("job", "Searching...");
		
		JSONObject request = new JSONObject();
		request.put("name", "Kaushik");
		request.put("job", "Searching...");
		
		System.out.println(request);
		
		baseURI = "https://reqres.in";
		
		given().header("Content-Type", "application/json").
		body(request.toJSONString()).when().
		post("/api/users").then().statusCode(201).log().all();
//		given().get("/api/users?page=2").then().statusCode(200).
//		body("data[4].first_name", equalTo("George")).
//		body("data.first_name", hasItems("George", "Rachel"));
	}
	
}
