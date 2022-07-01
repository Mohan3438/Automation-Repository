package com.rest.api.ResponseBuilderConcept;

import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class ResponseBuilderConcept {

	
	ResponseSpecBuilder res = new ResponseSpecBuilder();
    ResponseSpecification resSpec = res.expectContentType(ContentType.JSON)
    		.expectStatusCode(200)
    		.expectHeader("Server", "nginx").build();
    
    @Test
    public void ReponseSpecTest() {
    	RestAssured.baseURI = "https://gorest.co.in";
    	given()
    	.header("Authorization", "Bearer 7db84b9c5932254b55c00192a66ae08a403e1e68b1d1fd6c67aaed1456721d6c")
    	.when()
    	.get("/public-api/users")
    	.then().log().all()
    	.assertThat()
    	.spec(resSpec);
    	
    	
    }
    
}
