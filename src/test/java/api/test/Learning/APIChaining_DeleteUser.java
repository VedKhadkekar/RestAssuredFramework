package api.test.Learning;

import io.restassured.response.Response;
import junit.framework.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class APIChaining_DeleteUser {



    @Test(priority = 0)
    void testDeleteUser(ITestContext context){
        //int id = (int) context.getAttribute("user_id");
        int id = (int) context.getSuite().getAttribute("user_id");
        String bearer_token = "5effdc0be24e6479cd0b5e8d7590be0321f330b471a56d2b9127de57d4c6c33c";

        Response response=
        given()
                .header("Authorization","Bearer "+bearer_token)
                .pathParam("id",id)
                .contentType("application/json")
       .when()
                .delete("https://gorest.co.in/public/v2/users/{id}");

        System.out.println("Delete User>>>" + response.getBody().toString());
        Assert.assertEquals(response.getStatusCode(),204);
        System.out.println("Delete User>>>" + response.getStatusCode());


    }
}
