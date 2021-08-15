package learnassert;

import java.util.HashMap;

import org.hamcrest.Matchers;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetIncidentWithAssert {

	public static void main(String[] args) {
		HashMap<String, String> queryParams = new HashMap<String, String>();
		queryParams.put("sysparm_fields", "sys_id,number, category,short_description");
		queryParams.put("sysparm_limit", "10");
		
		RestAssured.baseURI = "https://dev79032.service-now.com/api/now/table/incident";
		RestAssured.authentication = RestAssured.preemptive().basic("admin", "Tuna@123");
		Response response = RestAssured
				.given()
				.queryParams(queryParams)
				.get()
				.then().assertThat()
//				.body("result.short_description[1]", Matchers.equalTo("EMAIL Server Down Again"))
				.body("result.short_description", Matchers.hasItems("EMAIL Server Down Again"))
				.extract().response();
			
		response.prettyPrint();
		

	}

}
