package com.RestApi.www;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;


import java.io.File;
import java.util.List;

import static io.restassured.RestAssured.given;
public class ApiTest {

    private  final Logger logger = LogManager.getLogger("HelloWorld");

    @Test
   public void createBug(){
       File file = new File("C:\\Users\\imdadul\\IdeaProjects\\RestTest\\src\\test\\Resource\\BugDetails.json");

       Response createBZ = given().
                                    cookies("JSESSIONID",requestPre.getSessionID()).
                                    header(requestPre.jsonHead()).
                                    body(file).
                                        when().
                                            post(ApiResource.createIssuePost()).then().extract().response();

       createBZ.prettyPrint();
       createBZ.then().assertThat().statusCode(201);
       logger.debug("creating a new bug");
   }

   @Test
   public void getAllBugs(){
       Response allBugs = given().
               cookies("JSESSIONID",requestPre.getSessionID()).
               header(requestPre.jsonHead()).

               when().
               get(ApiResource.searchPostGet()).then().extract().response();

       JsonPath ab = DataParser.rawToJSON(allBugs);
       List<String> abc= ab.getList("issues.fields.summary");
       for (String a:abc) {
           System.out.println(a);
       }
       logger.info("Getting bug list");
   }
    @Test
    public void createProject(){

        File file = new File("C:\\Users\\imdadul\\IdeaProjects\\RestTest\\src\\test\\Resource\\ProjectNew.json");

        Response createProject = given().
                cookies("JSESSIONID",requestPre.getSessionID()).
                header(requestPre.jsonHead()).body(file).
                when().
                post(ApiResource.createProject()).then().log().all().extract().response();

        createProject.then().assertThat().statusCode(201);
        logger.info("Creating a new project");
    }
}
