package com.rest.api.get;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;





public class GETBDDAPIs_02_QueryParameter {

	@Test
	public void getCall() {

		given()
		.param("text", "test")
		.when()
		.get("http://md5.jsontest.com")
		.then().log().all()
		.assertThat()
		.statusCode(200)
		.body("md5", equalTo("098f6bcd4621d373cade4e832627b4f6"))
		.and()
		.contentType("application/json")
		.and()
		.header("Content-Length", equalTo("72"));
	}

}
