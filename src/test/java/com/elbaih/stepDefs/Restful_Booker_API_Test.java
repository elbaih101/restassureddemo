
package com.elbaih.stepDefs;

import com.elbaih.jsonOpjects.Booking;
import com.elbaih.jsonOpjects.BookingDates;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import static com.elbaih.stepDefs.Hooks.restAssuredExtension;
import static org.hamcrest.Matchers.*;

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
        this.token = response.getBody().jsonPath().get("token");
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
        //                Using an object mapper method

        /*  String body;

        ObjectMapper mapper = new ObjectMapper();
        try {
             body =mapper.writerWithDefaultPrettyPrinter().writeValueAsString(bodypojo);

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }*/
        //                 using restassured built in serializer depemded on jackson
       response=(Response) restAssuredExtension.postRequest("/booking",bodypojo);

    }

    @Then("its ok")
    public void itsOk() {
        response.then().assertThat().statusCode(200);
    }

    @When("sending delete request with url {string} and {string} and body with {string}")
    public void sendingDeleteRequestWithUrlAndAndBodyWith(String url, String id,String token) {
       token= this.token;
        HashMap<String,String> pathparam =new HashMap<>();
        pathparam.put("id",id);
        response=(Response) restAssuredExtension.deleteRequest(url,pathparam,token);
    }

    @Then("a succsefull status code {int} is returned")
    public void aSuccsefullStatusCodeIsReturned(int successcode) {
        response.then().assertThat().statusCode(successcode);
    }

    @And("when sending a get request with url {string} and {string} response body is empty")
    public void whenSendingAGetRequestWithUrlAndResponseBodyIsEmpty(String url, String id) {
        HashMap<String,String> pathparam=new HashMap<>();
        pathparam.put("id",id);
 response=(Response) restAssuredExtension.GetBookingByPathParam(url,pathparam);
response.then().assertThat().body(equalTo("Not Found"));
    }


}


