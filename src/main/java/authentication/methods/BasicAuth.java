package authentication.methods;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertEquals;

import io.restassured.path.json.JsonPath;
import org.junit.Test;

public class BasicAuth {

    @Test
    public void basicAuth(){

        RestAssured.baseURI="https://httpbin.org/";
        //https://httpbin.org/basic-auth/user/pass
        String response = given().log().all().auth().basic("user","pass").headers("Connection","keep-alive").
                when().get("basic-auth/user/pass").
                then().assertThat().statusCode(200).headers("content-type","application/json").extract().response().asString();
        JsonPath jp = new JsonPath(response);
        String res = jp.getString("user");
        assertEquals("User Mismatch","user",res);


    }

}
