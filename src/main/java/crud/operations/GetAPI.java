package crud.operations;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertEquals;

import io.restassured.path.json.JsonPath;
import org.junit.Test;

public class GetAPI {

    @Test
    public void getUser(){
        //https://reqres.in/api/users?page=2
        //https://fake-json-api.mock.beeceptor.com/companies
        //https://jsonplaceholder.typicode.com/posts
        RestAssured.baseURI= "https://jsonplaceholder.typicode.com";

//        given().log().all().headers("contentType","application/json")
//                .header("Accept","application/json")
//
//                .when().get("companies")
//                .then().log().all().assertThat().statusCode(200).header("content-Type","application/json");

        String response = given().log().all().headers("Content-Type","application/json")
                .header("Accept","application/json")
                .when().get("posts/1")
                .then().log().all().assertThat().statusCode(200).extract().response().asString();
        System.out.println("Response is ::::::" +response);

        JsonPath jp = new JsonPath(response);
        String val = jp.getString("userId");
        assertEquals("Id is not matching",val,"1");
    }


//    @Test
//    public void createUser(){
//        RestAssured.baseURI="https://reqres.in/";
//        given().headers("contentType","application/json").body("{\r\n"
//        + "\"name\": \"morpheus\",\r\n"
//        + "\"job\":\"leader\"\n"
//        +"}").when().post("api/users").then().assertThat().statusCode(201);
//
//    }

}
