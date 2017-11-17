package com.RestApi.www;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.response.Response;

import java.io.File;

import static io.restassured.RestAssured.given;

public class requestPre {
    public static Header jsonHead() {
        return new Header("Content-Type", "application/json");
    }
    public static String getSessionID(){
        File file = new File("C:\\Users\\imdadul\\IdeaProjects\\RestTest\\src\\test\\Resource\\LoginCredential.json");
        RestAssured.baseURI = ApiResource.baseURL();
        Response session = given().header(requestPre.jsonHead()).body(file).when().post(ApiResource.getLogin()).then().extract().response();
        session.then().assertThat().statusCode(200);
        return session.sessionId();
    }


}
