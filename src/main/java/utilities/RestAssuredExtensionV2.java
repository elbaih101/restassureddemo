package utilities;


import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import io.restassured.specification.RequestSpecification;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

public class RestAssuredExtensionV2 {

    public static class APIMethods {
        public static String Post = "Post";
        public static String Get = "Get";
        public static String Delete = "Delete";
        public static String Patch = "Patch";
        public static String Put = "Put";
    }

    private RequestSpecBuilder builder = new RequestSpecBuilder();
    private String method;
    private String url;

    /**\
     * rest assured v2 constructor to pass initial setting for the following methods
     * @param uri
     * @param method
     * @param token
     */
    public RestAssuredExtensionV2(String uri, String method, String token) {
        this.url = "http://localhost:3001" + uri;
        this.method = method;
        if (token != null)
            builder.addCookie("token", token);

    }

    /**
     * Execute api for executing the Get/Post/Delete/Put/Patch
     * @return of type ResponseOptions<Response>
     */
    private ResponseOptions<Response> ExecuteApi(){
        RequestSpecification requestSpecification=builder.build();
        RequestSpecification request = RestAssured.given();
        request.contentType(ContentType.JSON);
        request.spec(requestSpecification);
        if (this.method.equalsIgnoreCase(APIMethods.Post))
            return request.post(this.url);
        if (this.method.equalsIgnoreCase(APIMethods.Delete))
            return request.delete(this.url);
        if (this.method.equalsIgnoreCase(APIMethods.Get))
            return request.get(this.url);
        if (this.method.equalsIgnoreCase(APIMethods.Patch))
            return request.patch(this.url);
        if (this.method.equalsIgnoreCase(APIMethods.Put))
            return request.put(this.url);
        return null;
    }

    /**
     * authentication to retreave a token
     * @param body of type Map<String,String>
     * @return of Type String containing token
     */
    public String authenticat(Map<String,String> body) {
//
      builder.setBody(body);
      return ExecuteApi().getBody().jsonPath().get("token");

    }

    /**
     * Execute the apiGet/Post/Delete/Put/Patch with body
     * @param body of type Map<String,String>
     * @return of type ResponseOptions<Response>
     */
    public ResponseOptions<Response> ExcuteWithbody(Map<String,String> body){
        builder.setBody(body);
        return ExecuteApi();
    }

    /**
     *  Execute the apiGet/Post/Delete/Put/Patch with path parameters
     * @param pathparams of type Map<String,String>
     * @return of type ResponseOptions<Response>
     */
    public ResponseOptions<Response> ExcuteWithPathparam(Map<String,String> pathparams){

        return ExecuteApi();
    }

    /**
     * Execute the apiGet/Post/Delete/Put/Patch with query parameters
     * @param querryparams of type Map<String,String>
     * @return of type ResponseOptions<Response>
     */
    public ResponseOptions<Response> ExcuteWithQueryParam(Map<String,String> querryparams){
        builder.addQueryParams(querryparams);
        return ExecuteApi();
    }

    /**
     * Execute the apiGet/Post/Delete/Put/Patch with body and path parameters
     * @param pathparams of type Map<String,String>
     * @param body  f type Map<String,String>
     * @return of type ResponseOptions<Response>
     */
    public ResponseOptions<Response> ExcuteWithBodyandPathParams(Map<String,String> pathparams,Map<String,String> body){
        builder.addPathParams(pathparams);
        builder.setBody(body);
        return ExecuteApi();
    }
}