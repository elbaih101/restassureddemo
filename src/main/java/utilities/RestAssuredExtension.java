package utilities;


import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.http.Cookie;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import io.restassured.specification.RequestSpecification;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;


public class RestAssuredExtension {
    public static RequestSpecification request;

    public RestAssuredExtension() {
        RequestSpecBuilder builder = new RequestSpecBuilder();
        builder.setBaseUri("http://localhost:3001/");
        builder.setContentType(ContentType.JSON);
        var requestspec = builder.build();
        request = RestAssured.given().spec(requestspec);
        request.log().all();
    }


    public ResponseOptions<Response> authenticat(String url, String username, String password) {
//        request.auth().basic(username,password);
        HashMap<String, String> authcontent = new HashMap<>();
        authcontent.put("username", username);
        authcontent.put("password", password);

        request.contentType(ContentType.JSON);
        request.body(authcontent);
        request.log().all();
        try {
            return request.post(new URI(url));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ResponseOptions<Response> GetBooking(String url) {
        try {
            return request.get(new URI(url));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ResponseOptions<Response> GetBookingByPathParam(String url, HashMap<String, String> pathparam) {
        request.pathParams(pathparam);

        return request.get(url);

    }


    public ResponseOptions<Response> getRequest(String url) {
        try {
            return request.get(new URI(url));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ResponseOptions<Response> postRequest(String url, Object body) {


        request.contentType(ContentType.JSON);
        request.body(body);
        request.log().all();
        try {
            return request.post(new URI(url));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return null;

    }

    public ResponseOptions<Response> deleteRequest(String url, HashMap<String, String> pathparam, String token) {
        request.pathParams(pathparam);
        request.contentType(ContentType.JSON);
        request.cookie("token", token);

        return request.delete(url);
    }

    public ResponseOptions<Response> updateRequest(String url, Object body,HashMap<String,String>pathparam,String token) {

        request.contentType(ContentType.JSON);
        request.accept("application/json");
        request.cookie("token",token);
        request.pathParams(pathparam);
        request.body(body);
        return request.put(url);

    }
}