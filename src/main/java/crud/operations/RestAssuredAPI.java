package crud.operations;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertEquals;

import io.restassured.path.json.JsonPath;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RestAssuredAPI {

    public static String userId;

    @Test
    public void a_getRecord(){
        //https://reqres.in/api/users?page=2
        //https://fake-json-api.mock.beeceptor.com/companies
        //https://jsonplaceholder.typicode.com/posts
        RestAssured.baseURI= "https://jsonplaceholder.typicode.com";


        String response = given().headers("Content-Type","application/json")
                .header("Accept","application/json")
                .when().get("posts/1")
                .then().assertThat().statusCode(200).extract().response().asString();
        JsonPath jp = new JsonPath(response);
        userId = jp.getString("userId");
        assertEquals("Id is not matching",userId,"1");
        System.out.println("GET API Ran Successfully");
    }


    @Test
    public void b_createRecord(){
        RestAssured.baseURI="https://jsonplaceholder.typicode.com";
        given().headers("connection","keep-aliva").body("{\n" +
                "    \"title\" : \"API Automation\",\n" +
                "    \"body\"  : \"Learning REST API testing for Automation\",\n" +
                "    \"userId\"    : "+userId+"\n" +
                "}").when().post("posts").then().assertThat().statusCode(201);
        System.out.println("POST API Ran Successfully");

    }


    @Test
    public void c_updateRecord(){
        RestAssured.baseURI="https://jsonplaceholder.typicode.com";
        given().headers("Content-type","application/json").body("{\n" +
                "    \"title\" : \"API Automation\",\n" +
                "    \"body\"  : \"Learning REST API testing for Automation\",\n" +
                "    \"userId\"    : "+userId+"\n" +
                "}").when().put("posts/1").then().assertThat().statusCode(200);
        System.out.println("PUT API Ran Successfully");
    }


    @Test
    public void d_deleteRecord(){
        RestAssured.baseURI="https://jsonplaceholder.typicode.com";
        given().headers("Conection","keep-alive").when().delete("posts/1").then().assertThat().statusCode(200);
        System.out.println("DELETE API Ran Successfully");
    }
}
