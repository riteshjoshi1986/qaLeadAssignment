package tests.apis;

import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;


import static org.hamcrest.Matchers.*;



public class ApiTests {


    //using Hamcrest Matching library - equalTo method
    @Test
    public void testTC1(){
        RestAssured.given()
                .get("https://swapi.dev/api/people/1/")
                .then()
                .body("name",equalTo("Luke SkyWalker"))
                .log().all();
    }


    @Test
    public void testTC2(){

        JSONObject requestParams = new JSONObject();
        requestParams.put("name", "James");
        requestParams.put("title", "SDET");
        RestAssured.baseURI ="https://reqres.in/api";
        RequestSpecification request = RestAssured.given();

        request.body(requestParams.toJSONString());
        Response response = request.post("/users");
        Assert.assertEquals(response.getStatusCode(), 201);

    }

}
