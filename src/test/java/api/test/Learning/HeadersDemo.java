package api.test.Learning;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class HeadersDemo {

   @Test
    public void testHeaders(){

        given()
        .when()
                .get("https://www.google.com/")

        .then()
                .header("Content-Type","text/html; charset=ISO-8859-1")
                .header("Server","gws")
                .header("Content-Encoding","gzip");

    }

    @Test
    public void testHeadersInVariable(){

        Response response =
                 given()
                .when()
                .get("https://www.google.com/");

        String content_type = response.getHeader("Content-Type");
        System.out.println("content_type>>>>>>>>" + content_type);
        Assert.assertEquals(content_type,"text/html; charset=ISO-8859-1");
        //capture all headers info
        for(Header k :response.getHeaders()){
            String value_header = response.getHeader(k.toString());
            System.out.println(k + ">>>>>>>>" + value_header);
        }

                /*.header("Content-Type","text/html; charset=ISO-8859-1")
                .header("Server","gws")
                .header("Content-Encoding","gzip");*/

    }

}
