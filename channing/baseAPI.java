package channing;

import org.testng.annotations.BeforeMethod;

import io.restassured.RestAssured;

public class baseAPI {

	public static String sysID;
	
	@BeforeMethod
	public void init() {
//		step1: Get URI /Endpoint
		RestAssured.baseURI = "https://dev79032.service-now.com/api/now/table/incident";
//		step2: Authentication (basic auth)
		RestAssured.authentication = RestAssured.basic("admin", "Tuna@123");
	}
	
	
	
}
