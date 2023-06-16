package api.test.Learning;

import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class FileUploadAndDownload {

    @Test
    void singleFileUpload(){
        File file = new File("<mention the file path>");

        given()
            .multiPart(file)
            .contentType("multipart/form-data")
        .when()
            .post("<mention the request URL>")
        .then()
            .statusCode(200)
            .body("fileName",equalTo(""))
            .log().all();
    }

    @Test
    void multipleFilesUpload(){
        File file1 = new File("<mention the file path>");
        File file2 = new File("<mention the file path>");

        given()
                .multiPart(file1)
                .multiPart(file2)
                .contentType("multipart/form-data")
       .when()
                .post("<mention the request URL>")
       .then()
                .statusCode(200)
                .body("fileName",equalTo(""))
                .log().all();
    }

    @Test
    void downloadFile(){

        given()
       .when()
                .get("<mention the URL>")
       .then()
                .statusCode(200);
    }


}
