package learnassert;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CreateIncidentWithassert {

	public static void main(String[] args) {
		RestAssured.baseURI = "https://dev79032.service-now.com/api/now/table/incident";
		RestAssured.authentication = RestAssured.basic("admin", "Tuna@123");
		Response response =  RestAssured
				.given()
				//request header
				.contentType(ContentType.JSON)
				.when()
				.post()
				.then()
				.assertThat()
				.contentType(ContentType.JSON)
				.statusCode(201)
				.extract().response()
				;
		
		response.prettyPrint();

	}

}
