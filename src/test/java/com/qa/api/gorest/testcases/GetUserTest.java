package com.qa.api.gorest.testcases;

import org.testng.annotations.Test;

import com.qa.api.gorest.restclient.RestClient;

import io.restassured.response.Response;

public class GetUserTest {

//	String baseURI = "https://gorest.co.in";
//	String basePath = "/public-api-users";
//	String token = "54f0e4ba189c512d73f1f481d5141bad0e02f4a680484f60b5eddf1428ae2b14";
	
	String baseURI = "https://reqres.in";
	String basePath = "/api/users";
	
	
	
	@Test
	public void getAllUserListAPITest() {
		Response response = RestClient.doGet("JSON", baseURI, basePath, null, null, true);
//		System.out.println(response.body().prettyPrint());
		System.out.println(response.getStatusCode());
		System.out.println(response.prettyPrint());
	}
	
	
}
