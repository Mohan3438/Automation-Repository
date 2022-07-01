package com.rest.api.get;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class GETBDDAPIs_03_PathParametersUsingDataProvider {

	@DataProvider(name = "getCircuityearData")
	public Object[][] getCircuitYearInfo(){
		
		return new Object[][] {
			
			{"2017", 20},
			{"2016", 21},
			{"1966", 9}
			
		};
		
	}
	
	
	@Test(dataProvider = "getCircuityearData")
	public void getCallUsingPathParams(String seasonYear, int circuitNumber) {
		
		given()
		.pathParam("raceSeason", seasonYear)
		.when()
		.get("http://ergast.com/api/f1/{raceSeason}/circuits.json")
		.then().log().all()
		.assertThat()
		.body("MRData.CircuitTable.Circuits", hasSize(circuitNumber));
		
	}

}
