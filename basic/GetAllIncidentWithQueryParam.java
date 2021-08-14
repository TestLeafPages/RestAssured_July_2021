package basic;

import java.util.HashMap;
import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetAllIncidentWithQueryParam {

	public static void main(String[] args) {
		
		HashMap<String, String> queryParams = new HashMap<String, String>();
		queryParams.put("sysparm_fields", "sys_id,number, category,short_description");
		queryParams.put("sysparm_limit", "10");
		
		
		
		RestAssured.baseURI = "https://dev79032.service-now.com/api/now/table/incident";
		RestAssured.authentication = RestAssured.basic("admin", "Tuna@123");
		Response response = RestAssured
				.given()
//				.queryParam("sysparm_fields", "sys_id,number, category,short_description")
				.queryParams(queryParams)				
				.get();
		response.prettyPrint();
		System.out.println(response.contentType());
		System.out.println(response.statusCode());

	}

}
