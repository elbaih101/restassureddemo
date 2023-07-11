package com.elbaih.stepDefs;
import com.elbaih.jsonOpjects.Location;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.*;
import io.restassured.response.Response;
import io.restassured.specification.ResponseSpecification;

import static com.elbaih.stepDefs.Hooks.assrt;
import static com.elbaih.stepDefs.Hooks.restAssuredExtension;

public class Api_Test {

    /*using Rest Assured as it is

     static RequestSpecification requestspec;


     */
    Response response;

    Location location;


    private static final String BASE_URL = "http://zippopotam.us";
    ResponseSpecification responsespec;

    @When("requestin the get request with {string} {string}")
    public void requestinTheGetRequestWith(String arg0, String arg1) {
        //using Rest Assured Request
//       requestspec= new RequestSpecBuilder().setBaseUri(BASE_URL).build();
//        response= given().spec(requestspec)./*pathParam("countrycode",arg0).pathParam("zipcode",arg1).*/log().all().when().
//                get("/"+arg0+"/"+arg1);
        //using  pojos and Rest Assured Liberarry WE created
       response= (Response) restAssuredExtension.getRequest("/"+arg0+"/"+arg1);

        location=  response.getBody().as(Location.class);

    }




    @Then("the response must return code {int} andcontent type of {string}")
    public void theResponseMustReturnCodeAndcontentTypeOf(int code, String arg1) {
        //using Rest Assured Response
//        response.then().assertThat().statusCode(code).assertThat().contentType(ContentType.JSON);
//        response.then().log().body();


        //using  pojos
       responsespec = new ResponseSpecBuilder().expectStatusCode(code).expectContentType(ContentType.JSON).build();
       response.then().spec(responsespec).and().log().body();


    }

    @Then("the check the response body for the place to be {string}")
    public void theCheckTheResponseBodyForThePlaceToBe(String arg0) {
        //using Rest Assured Response
//        response.then().assertThat().body("places[0].'place name'",equalTo(arg0));

        //using  pojos
        assrt.assertEquals(arg0,location.getPlaces().get(0).getPlaceName());
        assrt.assertAll();
    }

    @Then("check reponse body fore the state to be {string}")
    public void checkReponseBodyForeTheStateToBe(String arg0) {
        //using Rest Assured Response
//        response.then().assertThat().body("places[0].state",equalTo(arg0));
        //using  pojos
        assrt.assertEquals(location.getPlaces().get(0).getState(),arg0);
        assrt.assertAll();
    }

    @Then("check whether the collection places has item {string}")
    public void checkWhetherTheCollectionPlacesHasItem(String arg0) {
           //using Rest Assured Response
//        response.then().assertThat().body("places.'state abbreviation'",hasItem(arg0));

           //using  pojos
        location.getPlaces().forEach(place -> assrt.assertTrue(place.getStateAbbreviation().contains(arg0)));

        assrt.assertAll();
    }


}
