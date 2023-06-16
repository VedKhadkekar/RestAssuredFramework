package api.test.Learning;

import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ParsingXMLResponse {

    @Test
    void testParsingXML(){

        //Approach 1 : Using XML path finder
        given()

        .when()
                .get("http://restapi.adequateshop.com/api/Traveler?page=1")
        .then()
                .statusCode(200)
                .header("content-type","application/xml; charset=utf-8")
                .body("TravelerinformationResponse.page",equalTo("1"))
                .body("TravelerinformationResponse.travelers.Travelerinformation[0].name",equalTo("Developer"));

        //Approach 2 : Using Response as a variable
        Response response =
        given()
        .when()
                .get("http://restapi.adequateshop.com/api/Traveler?page=1");

        Assert.assertEquals(response.getStatusCode(),200);
        Assert.assertEquals(response.getHeader("Content-Type"),"application/xml; charset=utf-8");
        Assert.assertEquals(response.xmlPath().get("TravelerinformationResponse.page").toString(),"1");
        Assert.assertEquals(response.xmlPath().get("TravelerinformationResponse.travelers.Travelerinformation[0].name").toString(),"Developer");

        //Approach 3 : Using XmlPath class
        Response res =
                given()
                .when()
                        .get("http://restapi.adequateshop.com/api/Traveler?page=1");

        XmlPath path = new XmlPath(res.asString());

        boolean flag = false;
        for(int i=0;i<path.getList("TravelerinformationResponse.travelers.Travelerinformation").size();i++){
            List<String> name = path.getList("TravelerinformationResponse.travelers.Travelerinformation.name");
            if(name.get(i).equalsIgnoreCase("karen")){
                flag = true;
                break;
            }
        }
        Assert.assertTrue(flag);



    }
}
