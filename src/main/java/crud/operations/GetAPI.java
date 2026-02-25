package crud.operations;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import org.junit.Test;

public class GetAPI {

    @Test
    public void getUser(){
        //https://reqres.in/api/users?page=2
        //https://fake-json-api.mock.beeceptor.com/companies
        RestAssured.baseURI= "https://fake-json-api.mock.beeceptor.com";

        given().headers("contentType","application/json")
                .header("Accept","application/json")

                .when().get("companies")
                .then().assertThat().statusCode(200);


    }

}
