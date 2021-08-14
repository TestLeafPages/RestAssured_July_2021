package basic;

import java.util.List;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class GetAllIncidentWithJsonPath {

	public static void main(String[] args) {
		RestAssured.baseURI = "https://dev79032.service-now.com/api/now/table/incident";
		RestAssured.authentication = RestAssured.basic("admin", "Tuna@123");
		Response response = RestAssured.get();
		response.prettyPrint();
		System.out.println(response.contentType());
		System.out.println(response.statusCode());
		
		// need to parse json
		JsonPath jsonPath = response.jsonPath();
		//string
//		String sysId = jsonPath.get("result.number");
//		System.out.println(sysId);
		
		//for array list 
		List<String> listOfSysID = jsonPath.getList("result.number");
		System.out.println(listOfSysID);
	}

}
