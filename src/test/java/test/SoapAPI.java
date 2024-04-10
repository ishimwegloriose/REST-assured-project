package test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.internal.util.IOUtils;

public class SoapAPI {
    @Test
    public void soapXml() throws FileNotFoundException{
        File file = new File("./soapXml/soapxml.xml");
        if(file.exists()){
            System.out.println("File exists");
            
        }
     FileInputStream fileInputStream = new FileInputStream(file);
    //  String requestBody = IOUtils.toString(fileInputStream, "UTF-8");
    String requestBody = IOUtils.toString(fileInputStream, "UTF-8");
    baseURI = "https://www.dataaccess.com/webservicesserver";

    given().
      contentType("text/xml").
      accept(ContentType.XML).
      body(requestBody).

    when().
      post("/NumberConversion.wso").
    then().statusCode(200).log().all();

    }
}
