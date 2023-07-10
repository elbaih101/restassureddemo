package com.elbaih.stepDefs;
import com.elbaih.jsonOpjects.Location;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.*;
import static org.hamcrest.Matchers.*;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.asserts.SoftAssert;
import static io.restassured.RestAssured.*;
public class Api_Test {
    Response response;
    Location location;
   static RequestSpecification requestspec;
   SoftAssert assrt =new SoftAssert();
    private static final String BASE_URL = "http://zippopotam.us";
    ResponseSpecification responsespec;

    @When("requestin the get request with {string} {string}")
    public void requestinTheGetRequestWith(String arg0, String arg1) {
       requestspec= new RequestSpecBuilder().setBaseUri(BASE_URL).build();
        response= given().spec(requestspec)./*pathParam("countrycode",arg0).pathParam("zipcode",arg1).*/log().all().when().
                get("/"+arg0+"/"+arg1);
        location=  response.getBody().as(Location.class);

    }




    @Then("the response must return code {int} andcontent type of {string}")
    public void theResponseMustReturnCodeAndcontentTypeOf(int code, String arg1) {
//        response.then().assertThat().statusCode(code).assertThat().contentType(ContentType.JSON);
//        response.then().log().body();



       responsespec = new ResponseSpecBuilder().expectStatusCode(code).expectContentType(ContentType.JSON).build();
       response.then().spec(responsespec).and().log().body();


    }

    @Then("the check the response body for the place to be {string}")
    public void theCheckTheResponseBodyForThePlaceToBe(String arg0) {
//        response.then().assertThat().body("places[0].'place name'",equalTo(arg0));

        assrt.assertEquals(arg0,location.getPlaces().get(0));
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
