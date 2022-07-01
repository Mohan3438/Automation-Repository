package com.rest.api.get;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GETBDDAPIs_01 {

	// Rest assurred BDD keywords
	/*given()
	when()
	then()
	and() */
	
	// Approach 1
	@Test
	public void getAPITest_1() {
		given().log().all().
		when().log().all().
		get("http://ergast.com/api/f1/2017/circuits.json").
		then().log().all().
		assertThat().
		body("MRData.CircuitTable.Circuits", hasSize(20));
		
	}
	
	
	//Approach 2 (Highly recommended)
	@Test
	public void getAPITest_2() {
		
		Response response = given().log().all()
		.when().log().all()
		.get("http://ergast.com/api/f1/2017/circuits.json");
		
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);
		
		System.out.println(response.prettyPrint());
	}
	
	
	//Approach 3
	@Test
	public void getAPITest_3() {
		RestAssured.baseURI = "http://ergast.com/api";
		
		given()
		.when()
		.get("/f1/2017/circuits.json")
		.then()
		.assertThat()
		.statusCode(200)
		.and()
		.header("Content-Length", equalTo("4552"))
		.and()
		.contentType("application/json; charset=utf-8");
	}
	
}
