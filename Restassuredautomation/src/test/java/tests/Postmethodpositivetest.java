package tests;

import org.json.simple.JSONObject;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;


public class Postmethodpositivetest {


	@Test
	public void positivetest() {

		JSONObject request = new JSONObject();

		System.out.println("running positive case where user login successfully");
		request.put("email", "eve.holt@reqres.in");
		request.put("password", "cityslicka");

		System.out.println(request.toJSONString());

		baseURI = "https://reqres.in/api";

		System.out.println("Response");
		given().
		header("x-api-key","reqres-free-v1").
		contentType(ContentType.JSON).
		accept(ContentType.JSON).
		body(request.toJSONString()).
		when().
		post("/login").
		then().
		statusCode(200).
		log().
		all();

	}
	@Test	
	public void Negativetest() {


		JSONObject request = new JSONObject();


		request.put("password","test");
		request.put("email","test@gmail.com");

		System.out.println(request.toJSONString());

		baseURI = "https://reqres.in/api";


		given().
		header("x-api-key","reqres-free-v1").
		contentType(ContentType.JSON).
		accept(ContentType.JSON).
		body(request.toJSONString()).
		when().
		post("/login").
		then().
		statusCode(400).
		log().
		all();
	}

}
