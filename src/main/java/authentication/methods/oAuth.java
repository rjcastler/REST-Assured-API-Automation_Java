package authentication.methods;

import io.restassured.RestAssured;
import org.junit.Test;

import static io.restassured.RestAssured.*;

public class oAuth {
    @Test
    public void oAuthSecutiry(){
        RestAssured.baseURI="https://httpbin.org/";
        //https://httpbin.org/basic-auth/user/pass
        given().log().all().auth().oauth2("adasdasd").
                when().get("basic-auth/user/pass").
                then().assertThat().statusCode(200);

    }

}
