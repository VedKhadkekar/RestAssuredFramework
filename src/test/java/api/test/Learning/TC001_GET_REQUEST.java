package api.test.Learning;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC001_GET_REQUEST {

    @Test
    void getWeatherDetails(){


        RestAssured.baseURI = "https://reqres.in/api" ;
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.request(Method.GET,"/users?page=2");

        String responseBody = response.getBody().toString();
        System.out.println("Response Body is"+ responseBody);

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode,200);
        System.out.println("Response Body is"+ statusCode);

        String statusline = response.statusLine();

        System.out.println("Response Body is"+ statusline);
    }

}
