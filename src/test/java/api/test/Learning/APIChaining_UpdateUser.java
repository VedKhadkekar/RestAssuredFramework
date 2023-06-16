package api.test.Learning;

import com.github.javafaker.Faker;
import io.restassured.response.Response;
import junit.framework.Assert;
import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class APIChaining_UpdateUser {



    @Test(priority = 0)
    void testUpdateUser(ITestContext context){
        //int id = (int) context.getAttribute("user_id");
        int id = (int) context.getSuite().getAttribute("user_id");

        String bearer_token = "5effdc0be24e6479cd0b5e8d7590be0321f330b471a56d2b9127de57d4c6c33c";
        JSONObject jsonObject = new JSONObject();
        Faker faker = new Faker();
        jsonObject.put("name",faker.name());
        jsonObject.put("gender","female");
        jsonObject.put("email",faker.internet().emailAddress());
        jsonObject.put("status","Active");


        Response response=
        given()
                .header("Authorization","Bearer "+bearer_token)
                    .pathParam("id",id)
                .contentType("application/json")
                .body(jsonObject.toString())
       .when()
                .put("https://gorest.co.in/public/v2/users/{id}");

        System.out.println("Update User>>>" + response.getBody().toString());
        Assert.assertEquals(response.getStatusCode(),200);
        System.out.println("Update User>>>" + response.getStatusCode());


    }
}
