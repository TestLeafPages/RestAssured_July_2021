package basic;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CreateIncidentWithBodyAsString {

	public static void main(String[] args) {
//		step1: Get URI /Endpoint
		RestAssured.baseURI = "https://dev79032.service-now.com/api/now/table/incident";
//		step2: Authentication (basic auth)
		RestAssured.authentication = RestAssured.basic("admin", "Tuna@123");
//		step3: Request Type 
		Response response = RestAssured
				.given()
				.contentType(ContentType.JSON)
				.body("{ \"short_description\": \"Display Issue\", \"category\": \"hardware\" }")
				.post();
//		step6: print (Response)
		response.prettyPrint();
//		step4: print (Response Content type -> xml/json)
		System.out.println(response.contentType());
//		step5: print (Response statu code -> 200)
		System.out.println(response.statusCode());

	}

}
