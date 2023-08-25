package tests;

import static io.restassured.RestAssured.*;
//import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class PutPatchDeleteExamples {
	@Test
	public void testPut() {
		
		JSONObject request = new JSONObject();
		request.put("name", "Kaushik");
		request.put("job", "Searching...");
		
		System.out.println(request);
		
		baseURI = "https://reqres.in";
		
		given().header("Content-Type", "application/json").
		body(request.toJSONString()).when().
		put("/api/users/2").then().statusCode(200).log().all();
	}
	
	@Test
	public void testPatch() {
		
		JSONObject request = new JSONObject();
		request.put("name", "Kaushik");
		request.put("job", "Searching...");
		
		System.out.println(request);
		
		baseURI = "https://reqres.in";
		
		given().header("Content-Type", "application/json").
		body(request.toJSONString()).when().
		patch("/api/users/2").then().statusCode(200).log().all();
	}
	
	@Test
	public void testDelete() {
		
//		JSONObject request = new JSONObject();
//		request.put("name", "Kaushik");				
		baseURI = "https://reqres.in";
		
		when().
		delete("/api/users/2").then().statusCode(204).log().all();
	}

}
