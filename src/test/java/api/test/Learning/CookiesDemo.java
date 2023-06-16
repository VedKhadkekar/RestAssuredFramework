package api.test.Learning;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.Map;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class CookiesDemo {

   @Test
    public void testCookies(){

        given()
        .when()
                .get("https://www.google.com/")

        .then()
                .cookie("AEC","AUEFqZdoGMH2PC2AEZhlnmDWAFP1OFSl6tY8Knc2qxvqN-VlEC71xToIhA")
                .log().all();

    }


    @Test
    public void getCookiesInfo(){

        Response response =
                given()
                .when()
                .get("https://www.google.com/");

        //get single cookies info
        String cookie_value =  response.getCookie("AEC");
        System.out.println("value>>>>>>>" +cookie_value);

        // get multiple cookies info
        Map<String, String> cookies_info = response.getCookies();
        //cookies_info.keySet();
        for(String k :cookies_info.keySet()){
            String valueOfCookie = response.getCookie(k);
            System.out.println(k + ">>>>>>" + valueOfCookie);
        }

    }
}
