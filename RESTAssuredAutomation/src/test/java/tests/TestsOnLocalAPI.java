package tests;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class TestsOnLocalAPI {
	@Test
	public void testGet() {
		baseURI = "http://localhost:3000";
		given().get("/users").then().statusCode(200).log().all();
	}
	
	@Test
	public void testPost() {
		
		JSONObject request = new JSONObject();
		request.put("firstName", "Sanatan Priya");
		request.put("lastName", "Das");
		request.put("subjectId", 2);
		
		System.out.println(request);
		
		baseURI = "http://localhost:3000";
		
		given().contentType(ContentType.JSON).accept(ContentType.JSON).
		body(request.toJSONString()).when().
		post("/users").then().statusCode(201).log().all();
	}
	
	@Test
	public void testPut() {
		
		JSONObject request = new JSONObject();
		request.put("firstName", "Vanamali Pandit");
		request.put("lastName", "Das");
		request.put("subjectId", 2);
		
		System.out.println(request);
		
		baseURI = "http://localhost:3000";
		
		given().contentType(ContentType.JSON).accept(ContentType.JSON).
		body(request.toJSONString()).when().
		put("/users/4").then().statusCode(200).log().all();
	}
	
	@Test
	public void testPatch() {
		
		JSONObject request = new JSONObject();
		request.put("firstName", "Damodar");
		
		System.out.println(request);
		
		baseURI = "http://localhost:3000";
		
		given().contentType(ContentType.JSON).accept(ContentType.JSON).
		body(request.toJSONString()).when().
		patch("/users/4").then().statusCode(200).log().all();
	}
	
	@Test
	public void testDelete() {
		
		baseURI = "http://localhost:3000";
		
		when().
		delete("/users/4").then().statusCode(200).log().all();
	}

}
