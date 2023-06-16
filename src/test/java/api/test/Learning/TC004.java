package api.test.Learning;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class TC004 {
    @Test(priority=0)
    //https://reqres.in/
    // /api/users?page=2
    public void getUsers(){
        given().
                when().get("https://reqres.in/api/users?page=2")
                .then()
                .statusCode(200)
                .log().all();

    }

    /*@Test
    public void createuser(){

    }*/
}
