package api.test.Learning;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class TC003 {

@Test

    public void getUserID(){

    RestAssured.given()
            .baseUri("https://api.spotify.com/").basePath("v1")
            .header("Authorization","Bearer ")
            .when().get("/me")
            .then()
            .statusCode(200)
            .statusLine("HTTP/1.1 200 OK");

        }
}
