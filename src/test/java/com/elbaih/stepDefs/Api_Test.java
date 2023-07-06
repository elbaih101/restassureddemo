package com.elbaih.stepDefs;

import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import io.restassured.http.*;
import static org.hamcrest.Matchers.*;
import io.restassured.response.Response;
import org.testng.asserts.SoftAssert;
import static io.restassured.RestAssured.*;
public class Api_Test {
    Response response;
   SoftAssert assrt =new SoftAssert();
    private static final String BASE_URL = "http://zippopotam.us";
    @When("requestin the get request {string}")

    @When("requestin the get request with {string} {string}")
    public void requestinTheGetRequestWith(String arg0, String arg1) {

        response= given()./*pathParam("countrycode",arg0).pathParam("zipcode",arg1).*/log().all().when().
                get(BASE_URL+"/"+arg0+"/"+arg1);
    }




    @Then("the response must return code {int} andcontent type of {string}")
    public void theResponseMustReturnCodeAndcontentTypeOf(int code, String arg1) {
        response.then().assertThat().statusCode(code).assertThat().contentType(ContentType.JSON);
        response.then().log().body();

    }

    @Then("the check the response body for the place to be {string}")
    public void theCheckTheResponseBodyForThePlaceToBe(String arg0) {
        response.then().assertThat().body("places[0].'place name'",equalTo(arg0));
    }

    @Then("check reponse body fore the state to be {string}")
    public void checkReponseBodyForeTheStateToBe(String arg0) {
        response.then().assertThat().body("places[0].state",equalTo(arg0));
    }

    @Then("check whether the collection places has item {string}")
    public void checkWhetherTheCollectionPlacesHasItem(String arg0) {
        response.then().assertThat().body("places.'state abbreviation'",hasItem(arg0));
    }


}
