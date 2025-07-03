package tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.json.JSONObject;

import static io.restassured.RestAssured.given;

public class LoginAPITest {

    Logger log = LogManager.getLogger(LoginAPITest.class);
    String baseURI = "https://reqres.in";

    @Test(priority = 2)
    public void loginWithInvalidCredentials() {
        RestAssured.baseURI = baseURI;

        JSONObject requestBody = new JSONObject();
        requestBody.put("email", "test@gmail.com");
        requestBody.put("password", "test");

        System.out.println("Sending Invalid login request...");

        Response response = given()
                .header("Content-Type", "application/json").header("x-api-key","reqres-free-v1")
                .body(requestBody.toString())
                .when()
                .post("/api/login");

        System.out.println("Response: " + response.getBody().asString());

        Assert.assertEquals(response.getStatusCode(), 400);
        Assert.assertFalse(response.getBody().asString().contains("token"));
    }
    @Test(priority = 1)
    public void loginWithValidCredentials() {
        RestAssured.baseURI = baseURI;

        JSONObject requestBody = new JSONObject();
        requestBody.put("email", "eve.holt@reqres.in");
        requestBody.put("password", "cityslicka");

        System.out.println("Sending valid login request...");

        Response response = given()
                .header("Content-Type", "application/json").header("x-api-key","reqres-free-v1")
                .body(requestBody.toString())
                .when()
                .post("/api/login");

        System.out.println("Response: " + response.getBody().asString());

        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertTrue(response.getBody().asString().contains("token"));
    }

    @Test(priority = 3)
    public void loginWithMissingPassword() {
        RestAssured.baseURI = baseURI;

        JSONObject requestBody = new JSONObject();
        requestBody.put("email", "test@gmail.com");

        System.out.println("Sending login request with missing password...");

        Response response = given()
                .header("Content-Type", "application/json").header("x-api-key","reqres-free-v1")
                .body(requestBody.toString())
                .when()
                .post("/api/login");

        System.out.println("Response: " + response.getBody().asString());

        Assert.assertEquals(response.getStatusCode(), 400);
        Assert.assertTrue(response.getBody().asString().contains("Missing password"));
    }
}