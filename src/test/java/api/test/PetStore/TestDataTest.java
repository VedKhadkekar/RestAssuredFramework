package api.test.PetStore;

import api.Utilities.DataProvider;
import api.endPoints.EndPoints;
import api.payloads.User;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestDataTest {

    @Test(priority = 1, dataProvider = "Data", dataProviderClass = DataProvider.class)
    void testDatafromExcel(String id, String uName, String fName, String lName, String email, String pass, String phone ){

        User user = new User();
        user.setId(Integer.parseInt(id));
        user.setUsername(uName);
        user.setFirstName(fName);
        user.setLastName(lName);
        user.setEmail(email);
        user.setPassword(pass);
        user.setPhone(phone);

        Response response = EndPoints.createUser(user);
        Assert.assertEquals(response.getStatusCode(),200);

    }
}
