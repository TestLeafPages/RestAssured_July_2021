package basic;

import java.io.File;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CreateIncidentWithDP {
	
	@DataProvider(name = "fetchData")
	public String[] getData() {
		String[] fileName = new String[2];
		//1st filename
		fileName[0] = "createIncident1";
		//2nd filename
		fileName[1] = "createIncident2";
		return fileName;
	}

	@Test(dataProvider = "fetchData")
	public void createIncidentWithDP(String fileName) {
//		step1: Get URI /Endpoint
		RestAssured.baseURI = "https://dev79032.service-now.com/api/now/table/incident";
//		step2: Authentication (basic auth)
		RestAssured.authentication = RestAssured.basic("admin", "Tuna@123");
		//set file path
		File file = new File("./data/"+fileName+".json");
		
//		step3: Request Type 
		Response response = RestAssured
				.given()
				.contentType(ContentType.JSON)
				.body(file)
				.post();
//		step6: print (Response)
		response.prettyPrint();
//		step4: print (Response Content type -> xml/json)
		System.out.println(response.contentType());
//		step5: print (Response statu code -> 200)
		System.out.println(response.statusCode());

	}

}
