package api.test.PetStore;

import api.endPoints.EndPoints;
import api.payloads.User;
import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class UserModuleTests {
    Faker faker;
    User user;
    public Logger logger;
    @BeforeClass
    public void setup(){
    faker = new Faker();
    user = new User();

    user.setId(faker.idNumber().hashCode());
    user.setUsername(faker.name().username());
    user.setFirstName(faker.name().firstName());
    user.setLastName(faker.name().lastName());
    user.setEmail(faker.internet().emailAddress());
    user.setPassword(faker.internet().password());
    user.setPhone(faker.phoneNumber().cellPhone());

    logger = LoggerFactory.getLogger(this.getClass());


    }

    @Test(priority = 1)
    public void testCreateUser(){

        Response response = EndPoints.createUser(user);
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(),200);
        logger.info("Testing logger : User cretaed");
    }


    @Test(priority = 2)
    public void testGetUser(){

        Response response = EndPoints.getUser(this.user.getUsername());
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(),200);
        //logger.info("Testing logger : User get");
    }

    @Test(priority = 3)
    public void testUpdateUser(){

        user.setFirstName(faker.name().firstName());
        user.setLastName(faker.name().lastName());
        user.setEmail(faker.internet().emailAddress());

        Response response = EndPoints.updateUser(user,this.user.getUsername());
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(),200);

        Response responseAfterUpdate = EndPoints.getUser(this.user.getUsername());
        responseAfterUpdate.then().log().all();
        Assert.assertEquals(responseAfterUpdate.getStatusCode(),200);
        //logger.info("Testing logger : User updated");

    }

    @Test(priority = 4)
    public void testDeleteUser(){

        Response response = EndPoints.deleteUser(this.user.getUsername());
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(),200);
        //logger.info("Testing logger : User deleted");

    }


}
