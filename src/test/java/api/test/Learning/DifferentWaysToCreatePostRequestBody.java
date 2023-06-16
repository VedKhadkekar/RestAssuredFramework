package api.test.Learning;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class DifferentWaysToCreatePostRequestBody {

    @Test
    public void testPOSTUsingHashMap(){
        HashMap map = new HashMap();
        map.put("name","vedant");
        map.put("location","pune");
        map.put("phone","123456");

        String[] courses = {"c","c++"};
        map.put("courses",courses);

        given()
                .contentType("application/json")
                .body(map)

        .when()
                .post("<mention the URL>")
        .then()
                .statusCode(201)
                .body("name", equalTo("vedant"))
                .header("content-type","application/json");

    }

    @Test
    public void testPOSTUsingJSONLibrary(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name","vedant");
        jsonObject.put("location","pune");
        jsonObject.put("phone","123456");

        String courses[] = {"c","c++"};
        jsonObject.put("courses",courses);

        given()
                .contentType("application/json")
                .body(jsonObject.toString())

                .when()
                .post("<mention the URL>")
                .then()
                .statusCode(201)
                .body("name", equalTo("vedant"))
                .header("content-type","application/json");

    }

    @Test
    public void testPOSTUsingPOJOClass(){
        POJO_POSTRequest pojo_postRequest = new POJO_POSTRequest();
        pojo_postRequest.setName("vedant");
        pojo_postRequest.setLocation("pune");
        pojo_postRequest.setPhone("123456");

        String course[] = {"c","c++"};
        pojo_postRequest.setCourses(course);

        given()
                .contentType("application/json")
                .body(pojo_postRequest)

                .when()
                .post("<mention the URL>")
                .then()
                .statusCode(201)
                .body("name", equalTo("vedant"))
                .header("content-type","application/json");

    }

    @Test
    public void testPOSTUsingExternalJSONFile() throws FileNotFoundException {

        File file = new File(System.getProperty("user.dir") +"\\body.json");
        FileReader fileReader = new FileReader(file);
        JSONTokener jsonTokener = new JSONTokener(fileReader);
        JSONObject jsonObject = new JSONObject(jsonTokener);


        given()
                .contentType("application/json")
                .body(jsonObject.toString())

                .when()
                .post("<mention the URL>")
                .then()
                .statusCode(201)
                .body("name", equalTo("vedant"))
                .header("content-type","application/json");

    }

}
