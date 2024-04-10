package test;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;


import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

public class FirstTest {

	//@Test
	public void test_1() {
		Response response = get("https://reqres.in/api/users?page=2");
		System.out.println(response.getStatusCode());
		System.out.println(response.getTime());
		System.out.println(response.getBody().asString());
		System.out.println(response.getStatusLine());
		System.out.println(response.getHeader("content-Type"));

		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);
	}

	//@Test
	public void testGet(){
		baseURI = "https://reqres.in/api";
		given().
		 get("/users?page=2").
		then().
		 statusCode(200).
		 body("data[1].id", equalTo(8)).
		 log().all(); //save the response

	}
	
	//@Test
	public void testPost() {
		Map<String, Object>map = new HashMap<String, Object>();
		
		
		JSONObject request = new JSONObject();
		request.put("name", "Gogo");
		request.put("job", "QA");
		System.out.println(request.toJSONString());
		
		baseURI = "https://reqres.in/api";
		
		given().
		 header("Content-Type", "application/json").
		
		//   header("Content-Type", "application/json").
		//   contentType(ContentType.JSON).accept(ContentType.JSON).
		  body(request.toJSONString()).


		when().
		  post("/users").
		then().
		  statusCode(201)
		  .log().all();
		
	}

	@Test
	public void testPut() {
		Map<String, Object>map = new HashMap<String, Object>();
		
		
		JSONObject request = new JSONObject();
		request.put("name", "Gogo");
		request.put("job", "QA");
		System.out.println(request.toJSONString());
		
		baseURI = "https://reqres.in/api";
		
		given().
		 header("Content-Type", "application/json").
		
		//   header("Content-Type", "application/json").
		//   contentType(ContentType.JSON).accept(ContentType.JSON).
		  body(request.toJSONString()).


		when().
		  put("/users/2").
		then().
		  statusCode(200).
		  body("name", equalTo("Gogo"))
		  .log().all();
		  
		
	}
	@Test
	public void testPatch() {
		Map<String, Object>map = new HashMap<String, Object>();
		
		
		JSONObject request = new JSONObject();
		request.put("name", "Gogo");
		request.put("job", "QA");
		System.out.println(request.toJSONString());
		
		baseURI = "https://reqres.in/api";
		
		given().
		 header("Content-Type", "application/json").
		
		//   header("Content-Type", "application/json").
		//   contentType(ContentType.JSON).accept(ContentType.JSON).
		  body(request.toJSONString()).


		when().
		  patch("/users/2").
		then().
		  statusCode(200)
		  .log().all();
		
	}
	@Test
	public void testDelete() {
		
		baseURI = "https://reqres.in/api";
		
		when().
		  delete("/users/2").
		then().
		  statusCode(204)
		  .log().all();
		
	}

}






