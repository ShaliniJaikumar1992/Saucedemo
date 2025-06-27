package tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.http.ContentType;
import static org.junit.Assert.*;

import org.testng.annotations.Test;


public class RAapiautomation {

	@Test(priority=1)
	public void testPostApiResponsePositive() {
		String apiURL = "https://reqres.in/api/login";
		System.out.println("Login in valid credentials");
		String requestBody = "{ \"email\": \"eve.holt@reqres.in\", \"password\": \"cityslicka\"}";
		System.out.println("Request payload");
		System.out.println(requestBody);

		Response response = RestAssured
				.given()
				.header("x-api-key","reqres-free-v1")               
				.contentType(ContentType.JSON)
				.body(requestBody)
				.when()
				.post(apiURL);

		int statusCode = response.getStatusCode();
		String responseBody = response.getBody().asString();

		assertEquals(200, statusCode);
		System.out.println("Verify the status code is coming as 200:"+statusCode);
		System.out.println("Response payload");
		System.out.println(responseBody);
	}


	@Test(priority=2)

	public void testPostApiResponseNegative() {
		String apiURL = "https://reqres.in/api/login";
		System.out.println("Login in Invalid credentials");
		String requestBody = "{ \"email\": \"test@gmail.com\", \"password\": \"test\"}";
		System.out.println("Request payload");
		System.out.println(requestBody);

		Response response = RestAssured
				.given()
				.header("x-api-key","reqres-free-v1")               
				.contentType(ContentType.JSON)
				.body(requestBody)
				.when()
				.post(apiURL);

		int statusCode = response.getStatusCode();
		String responseBody = response.getBody().asString();

		assertEquals(400, statusCode);

		System.out.println("Verify the status code is coming as 400:"+statusCode);
		System.out.println("Response payload");

		System.out.println(responseBody);
	}
}


