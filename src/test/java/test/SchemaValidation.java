package test;
import static io.restassured.RestAssured.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;




public class SchemaValidation {
    @Test
	public void testGet(){
		baseURI = "https://reqres.in/api";
		given().
			 get("/users?page=2").
		then().
			assertThat().body(matchesJsonSchemaInClasspath("schema.json")).
			statusCode(200).         
			body("data.first_name", hasItems("Michael", "Lindsay")).
			log().all();//save the response
			

	}
    
}
