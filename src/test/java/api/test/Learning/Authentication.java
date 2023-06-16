package api.test.Learning;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class Authentication {

    //@Test

    void testBasicAuthentication(){
        given()
                .auth().basic("postman","password")
       .when()
                .get("https://postman-echo.com/basic-auth")
       .then()
                .statusCode(200)
                .body("authenticated",equalTo(true))
                .log().all();

    }

   // @Test

    void testDigestAuthentication(){
        given()
                .auth().digest("postman","password")
                .when()
                .get("https://postman-echo.com/basic-auth")
                .then()
                .statusCode(200)
                .body("authenticated",equalTo(true))
                .log().all();

    }

   // @Test

    void testPreemptiveAuthentication(){
        given()
                .auth().preemptive().basic("postman","password")
                .when()
                .get("https://postman-echo.com/basic-auth")
                .then()
                .statusCode(200)
                .body("authenticated",equalTo(true))
                .log().all();

    }

    //@Test
    void testBearerTokenAuthentication(){
        String BearerToken = "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";
        given()
                .header("Authorization","Bearer "+BearerToken)
       .when()
                .get("https://api.github.com/user/repos")
       .then()
                .statusCode(200)
                .log().all();

    }

    //@Test
    void test0Auth1Authetication(){
            given()
                    .auth().oauth("<consumerkey>","<consumerSecret>","<token>","<tokensecret>")
            .when()
                    .get("<URL>")
            .then()
                    .statusCode(200);
    }

    //@Test
    void test0Auth2Authetication(){
        given()
                .auth().oauth2("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")
                .when()
                .get("https://api.github.com/user/repos")
                .then()
                .statusCode(200).log().all();
    }

    @Test
    void testAPIKeyAuthentication(){
        given()
                .queryParam("appid","d2eb6b149d9947be8fa5a93fded17a7a")
        .when()
                .get("https://api.openweathermap.org/data/2.5/forecast/daily?q=Delhi&cnt=7")
        .then()
                .log().all();
    }


}
