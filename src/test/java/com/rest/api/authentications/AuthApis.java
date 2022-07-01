package com.rest.api.authentications;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class AuthApis {

	//basic auth
	// username/password
	
	@Test
	public void basic_auth_API_Test() {
		given()
		.auth()
		.preemptive()
		.basic("admin", "admin")
		.when()
		.get("http://the-internet.herokuapp.com/basic_auth")
		.then()
		.assertThat()
		.statusCode(200);
	}
	
	//Oauth 2.0
	
	@Test
	public void oAuth2_API_Test(){
		
		given()
		.auth()
		.oauth2("7db84b9c5932254b55c00192a66ae08a403e1e68b1d1fd6c67aaed1456721d6c")
		.when()
		.get("https://gorest.co.in/public-api/users?name=Miss Bhaanumati Joshi")
		.then().log().all()
		.assertThat()
		.statusCode(200);
		
	}

	
	// Instead of oauth 2.0 we can use below way as well
	// Note: If you are using
	// 1. with headers : append your token with Bearer keyword
	// 2. with oauth2() method: No need to add Bearer, just pass the token value 
	@Test
	public void AuthApis_With_headers() {
		
		RestAssured.baseURI = "https://gorest.co.in";
		
		given()
		.contentType("application/json")
		.header("Authorization", "Bearer 7db84b9c5932254b55c00192a66ae08a403e1e68b1d1fd6c67aaed1456721d6c")
		.queryParam("name", "Miss Bhaanumati Joshi")
		.when()
		.get("/public-api/users")
		.then().log().all()
		.assertThat()
		.statusCode(200);
	}
	
	// 1. Generate a token at the run time by using token api
	// 2. String tokenID from the response
	// 3. hit the next api with this token
	
	@Test
	public void getAuth2TokenAPITest() {
		
		RequestSpecification req = RestAssured.given()
		.formParam("client_id", "GenerateToken-JUNE2022")
		.formParam("client_secret", "0100f2a51df53c9e68640ede63cf3e7b")
		.formParam("grant_type", "client_credentials ");
		
		Response res = req.post("http://coop.apps.symfonycasts.com/token");
		
		System.out.println(res.getStatusCode());
		System.out.println(res.prettyPrint());
		
	}
	
	
}

