package com.rest.api.ResponseBuilderConcept;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.io.File;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;


public class POST_BDDAPIs {
	
	@Test
	public void post_api_Test() {
		
		RestAssured.baseURI = "https://restful-booker.herokuapp.com";
		given()
		.contentType(ContentType.JSON)
		.body("{\"username\": \"admin\", \"password\": \"password123\"}")
		.when()
		.post("/auth")
		.then().log().all()
		.assertThat()
		.statusCode(200);
		
	}
	
	@Test
	public void postAPI_UsingFile() {
		
		RestAssured.baseURI = "https://restful-booker.herokuapp.com";
		String tokenID = given()
		.contentType(ContentType.JSON)
		.body(new File(".\\src\\main\\java\\dataFiles\\credential.json"))
		.when()
		.post("/auth")
		.then().log().all()
		.extract()
		.path("token");
		
		System.out.println(tokenID);
		Assert.assertNotNull(tokenID);
		
		
	}

}
