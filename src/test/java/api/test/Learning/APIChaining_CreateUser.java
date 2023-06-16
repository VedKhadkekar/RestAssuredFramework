package api.test.Learning;

import com.github.javafaker.Faker;
import io.restassured.response.Response;
import junit.framework.Assert;
import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class APIChaining_CreateUser {

    @Test
    void testCreateUser(ITestContext context){
        int id;
        JSONObject jsonObject = new JSONObject();
        Faker faker = new Faker();
        jsonObject.put("name",faker.name());
        jsonObject.put("gender","Male");
        jsonObject.put("email",faker.internet().emailAddress());
        jsonObject.put("status","inActive");

        String bearer_token = "5effdc0be24e6479cd0b5e8d7590be0321f330b471a56d2b9127de57d4c6c33c";

        Response response=
        given()
                .header("Authorization","Bearer "+bearer_token)
                .contentType("application/json")
                .body(jsonObject.toString())
       .when()
                .post("https://gorest.co.in/public/v2/users");

        System.out.println("Create User>>>" + response.getBody().toString());
        System.out.println(response.getStatusCode());
        Assert.assertEquals(response.getStatusCode(),201);
        id = response.jsonPath().getInt("id");
        System.out.println("id>>>>>" + id);
        //context.setAttribute("user_id",id);
        context.getSuite().setAttribute("user_id",id);

    }
}
