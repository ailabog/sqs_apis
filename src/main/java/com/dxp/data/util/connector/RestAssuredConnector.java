package com.dxp.data.util.connector;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
public class RestAssuredConnector {

    public RequestSpecification request = new RequestSpecBuilder().build();
    public static Response response;

    public static void main(String[] args) {
        RestAssuredConnector rac = new RestAssuredConnector();

        System.out.println(response.asString());
    }

    public Response postRequest(String uri, String host, Map<String, String> headers, String body) {

        request = given().baseUri(uri).proxy(host).body(body).headers(headers);
        return request.when().post();
    }

    public Response postRequest(String uri, String host, Map<String, String> headers) {

        request = given().baseUri(uri).proxy(host).headers(headers);
        return request.when().post();
    }

    public Response postRequest(String uri, Map<String, String> headers, String body) {

        request = given().baseUri(uri).headers(headers).body(body);
        return request.when().post();
    }

    public Response postRequest(String uri, String host) {
        request = given().baseUri(uri).proxy(host);
        return request.when().post();
    }

    public static Map<String, String> setHeaders() {
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        headers.put("X-AMCN-ACCOUNT-ID", "xxxxxxx");
        headers.put("X-AMCN-SERVICE-GROUP-ID", "10");
        headers.put("X-AMCN-SERVICE-ID", "amcplus");
        headers.put("Accept", "*/*");
        headers.put("Accept-Encoding", "gzip, deflate, br");

        return headers;
    }

        public static Map<String, String> setHeadersBraze(){
            Map<String, String> headersBraze = new HashMap<>();
            headersBraze.put("Content-Type", "application/json");
            headersBraze.put("Authorization", "03b7700f-3523-41bd-bcb7-25e6d3017eea");

            return headersBraze;
    }

    public void postRequest(String uri, Headers headers) {
        request = given().baseUri(uri).headers(headers);
        response = request.when().get();
    }

    public Response getRequest(String uri, String host, Map<String, String> headers) {

        request = given().baseUri(uri).proxy(host).headers(headers);
        return request.when().get();
    }

    public Response patchRequest(String uri, String host, Map<String, String> headers, String body) {

        request = given().baseUri(uri).proxy(host).headers(headers).body(body);
        return request.when().patch();
    }

    public Response deleteRequest(String uri, String host, Map<String, String> headers) {

        request = given().baseUri(uri).proxy(host).headers(headers);
        return request.when().delete();
    }
}

