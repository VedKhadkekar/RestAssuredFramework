package api.test.Learning;

import io.restassured.matcher.RestAssuredMatchers;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class JSONSchemaValidation {

   /* @Test
    void testJSONSchemaValidation(){

        given()
        .when()
                .get("http://restapi.adequateshop.com/api/Customer")
        .then()
                .assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("jsonScheama.json"));
    }*/

    @Test
    void testXMLSchemaValidation(){
        given()
        .when()
                .get("http://restapi.adequateshop.com/api/Traveler")
        .then()
                .assertThat().body(RestAssuredMatchers.matchesXsdInClasspath("xmlSchema.xml"));
    }
}
