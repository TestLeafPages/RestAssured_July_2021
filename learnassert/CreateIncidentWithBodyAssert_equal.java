package learnassert;

import static org.hamcrest.Matchers.*;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CreateIncidentWithBodyAssert_equal {

	public static void main(String[] args) {
		RestAssured.baseURI = "https://dev79032.service-now.com/api/now/table/incident";
		RestAssured.authentication = RestAssured.basic("admin", "Tuna@123");
		Response response = RestAssured
				.given()
				.contentType(ContentType.JSON)
				.body("{ \"short_description\": \"Display Issue\", \"category\": \"hardware\" }")
				.post()
				.then()
				//path of field, value
//				.body("result.short_description", equalTo("Display Issue"))
				.body("result.short_description", containsString("Display"))
				.extract().response();
		response.prettyPrint();
		
		
//		String asString = response.asString();
//		
//		if(asString.equals(new File("path")))
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
