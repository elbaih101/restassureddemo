
package com.elbaih.stepDefs;

import com.elbaih.jsonOpjects.Booking;
import com.elbaih.jsonOpjects.BookingDates;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import io.restassured.specification.RequestSpecification;
import utilities.RestAssuredExtension;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Random;


import static com.elbaih.stepDefs.Hooks.assrt;
import static com.elbaih.stepDefs.Hooks.restAssuredExtension;

public class Restful_Booker_API_Test {
    static Response response;
    Booking booking;
    List<String> ids;
    String token;
    Hooks hooks = new Hooks();

    @Given("authenticating with path param {string} using user name {string} and password {string}")
    public void authenticatingWithPathParamUsingUserNameAndPassword(String auth, String username, String pass) {
        response = (Response) restAssuredExtension.authenticat(auth, username, pass);
        response.then().log().body();
        token = response.getBody().jsonPath().get("token");
    }

    @When("sending get {string} Request")
    public void sendingGetRequest(String booking) {
        response = (Response) restAssuredExtension.GetBooking(booking);
    }

    @Then("REsponse returns with Booking Ids")
    public void responseReturnsWithBookingIds() {

       ids = response.getBody().jsonPath().getList("bookingid");
        System.out.println(ids.size());

    }

    @When("sending a get Request with path param{string} and {string}")
    public void sendingAGetRequestWithPathParamAnd(String booking, String id) {
        Random random=new Random();
      id = "1";// ids.get(random.nextInt(0,ids.size()));
        HashMap<String,String > pathparam= new HashMap<>();
        pathparam.put("id",id);

     response=(Response) restAssuredExtension.GetBookingByPathParam(booking,pathparam);
       this.booking= response.getBody().as(Booking.class);
       this.booking.setID(id);
    }

    @Then("response is returned with the booking infos")
    public void responseIsReturnedWithTheBookingInfos() {

        System.out.println(booking.toString());


    }




    @When("posting a request with data as {string} {string} {string} {string} {string} {string} {string}")
    public void postingARequestWithDataAs(String firstname, String lastname, String totalprice, String depositpaid, String checkin, String checkout, String additionalneeds) {

        BookingDates dates=new BookingDates(checkin,checkout);
        Booking bodypojo =new Booking(firstname,lastname,totalprice,depositpaid,dates,additionalneeds);
        ObjectMapper mapper = new ObjectMapper();
        try {
            String body =mapper.writerWithDefaultPrettyPrinter().writeValueAsString(bodypojo);
            restAssuredExtension.postRequest("/booking",body);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    @Then("its ok")
    public void itsOk() {
    }
}


