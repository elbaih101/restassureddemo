
package com.elbaih.stepDefs;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import io.restassured.specification.RequestSpecification;
import utilities.RestAssuredExtension;

import static com.elbaih.stepDefs.Hooks.assrt;
import static com.elbaih.stepDefs.Hooks.restAssuredExtension;

public class Restful_Booker_API_Test {
 static Response response;
 String token;
 Hooks hooks=new Hooks();

    @Given("authenticating with path param {string} using user name {string} and password {string}")
    public void authenticatingWithPathParamUsingUserNameAndPassword(String auth, String username, String pass) {
        response= (Response) restAssuredExtension.authenticat(auth,username,pass);
       response.then().log().body();
        token=response.getBody().jsonPath().get("token");
        System.out.println(token);








    }

}