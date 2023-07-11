package utilities;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import io.restassured.specification.RequestSpecification;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

public class RestAssuredExtension
{
    public static RequestSpecification request;
    public RestAssuredExtension()
    {
        RequestSpecBuilder builder= new RequestSpecBuilder();
        builder.setBaseUri("http://zippopotam.us");
        builder.setContentType(ContentType.JSON);
        var requestspec =builder.build();
        request= RestAssured.given().spec(requestspec);
    }
public static void getLocationWithPathParams(String url, Map<String,String> pathparams){
        request.pathParams(pathparams);
    try {
        request.get(new URI(url));
    } catch (URISyntaxException e) {
        e.printStackTrace();
    }


}
    public static ResponseOptions<Response> getLocation(String url){
        try {
           return request.get(new URI(url));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return null ;
}

}
