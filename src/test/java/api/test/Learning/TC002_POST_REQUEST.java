package api.test.Learning;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class TC002_POST_REQUEST {


    @Test
    void getWeatherDetails(){

        RestAssured.baseURI = "https://reqres.in/api" ;
        RequestSpecification httpRequest = RestAssured.given();

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name","morpheus");
        jsonObject.put("job","leader");

        httpRequest.header("content-Type","application/json");
        httpRequest.body(jsonObject.toJSONString());

        Response response = httpRequest.request(Method.POST,"/users");

        int status_code = response.getStatusCode();

        String status_line = response.statusLine().toString();
    }

}
