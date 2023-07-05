package com.elbaih.stepDefs;

import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.http.*;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import static io.restassured.RestAssured.*;
public class Api_Test {
    Response response;
   SoftAssert assrt =new SoftAssert();
    @When("requestin the get request {string}")
    public void requestinTheGetRequest(String arg0) {
      response= given().log().all().when().
              get(arg0);
    }



    @Then("the response must return code {int} andcontent type of {string}")
    public void theResponseMustReturnCodeAndcontentTypeOf(int code, String arg1) {
        response.then().assertThat().statusCode(code).assertThat().contentType(ContentType.JSON);

    }
}
