package test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class TestOnLocalApi {
    
    @Test
    public void testGetMethod(){
        baseURI = "http://localhost:3000";
        given().
          get("/users").
        then().
          statusCode(200).
          //body("users[0].firstName", equalTo("Gloria")).
          log().all();  


    }

    @Test
    public void testPostMethod(){
        Map<String, Object> map = new HashMap<String, Object>();
        JSONObject request = new JSONObject();
        request.put("firstName", "Gloriose");
        request.put("lastName", "Ishimwe");
        request.put("subjectId", "API testing");
        request.put("id", 5);

        System.out.println(request);

        baseURI = "http://localhost:3000"; 

        given().
            header("Content-Type", "application/json").
            body(request.toJSONString()).
        when().
            post("/users").
        then().statusCode(201).log().all();

        
    }

    @Test
    public void testPatchMethod(){
       
        JSONObject request = new JSONObject();
        request.put("firstName", "Gloriose1");
        request.put("lastName", "Ishimwe1");
        request.put("subjectId", "API testing");
        

        System.out.println(request);

        baseURI = "http://localhost:3000"; 

        given().
            header("Content-Type", "application/json").
            body(request.toJSONString()).
        when().
            patch("/users/1").
        then().statusCode(200).log().all();

    }
    @Test
    public void testDeleteMethod(){
        baseURI = "http://localhost:3000"; 
        when().delete("/users/2").then().statusCode(204).log().all();
     }
    

    
}
