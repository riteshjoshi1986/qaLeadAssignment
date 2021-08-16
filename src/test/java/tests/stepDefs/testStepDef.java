package tests.stepDefs;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

import java.util.List;
import java.util.Map;



public class testStepDef {

Response response = null;

    @Given("^I want to validate API$")
    public void i_want_to_validate_API() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
       // throw new PendingException();
        System.out.println("Pass");
    }

    @When("^I make a get call$")
    public void i_make_a_get_call() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        response= RestAssured.given().get("https://swapi.dev/api/people/1/");
    }

    @Then("^response should contain \"([^\"]*)\"$")
    public void response_should_contain(String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        ResponseBody body = response.getBody();
        String bodyAsString = body.asString();
        Assert.assertEquals("Passed",true, bodyAsString.contains(arg1));

    }

    @When("^I make a POST call with data$")
    public void i_make_a_POST_call_with_data(List<Map<String, String>> arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        RestAssured.baseURI ="https://reqres.in/api";
        RequestSpecification request = RestAssured.given();

        request.body(arg1);
        response = request.post("/users");

    }

    @Then("^response data should get added$")
    public void response_data_should_get_added() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertEquals(response.getStatusCode(), 201);
    }


}
