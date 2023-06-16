package api.test.Learning;

import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class ParsingJSONResponse {

    @Test
    void testParsingJSON(){

        //Approach 1 : Using JSON path finder
        given()
                .contentType("ContentType.json")
        .when()
                .get("<mentionn the URL>")
        .then()
                .statusCode(200)
                .header("content-type","")
                .body("body[3].title",equalTo("<msg>"));

        //Approach 2 : Using Response as a variable
        Response response =
        given()
                .contentType("ContentType.json")
        .when()
                .get("<mention the URL>");

        Assert.assertEquals(response.getStatusCode(),200,"");
        Assert.assertEquals(response.getHeader("Content-Type"),"application/json","");
        Assert.assertEquals(response.jsonPath().get("book[3].title").toString(),"","");

        //Approach 3 : Using JSONObject class
        Response res =
                given()
                        .contentType("ContentType.json")
                        .when()
                        .get("<mention the URL>");

        JSONObject jsonObject = new JSONObject(res.toString());
        for(int i=0;i<jsonObject.getJSONArray("BOOK").length();i++){
            String title = jsonObject.getJSONArray("BOOK").getJSONObject(i).get("title").toString();

        }


    }
}
