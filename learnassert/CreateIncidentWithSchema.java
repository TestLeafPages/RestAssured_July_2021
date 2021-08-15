package learnassert;

import java.io.File;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;

public class CreateIncidentWithSchema {

	public static void main(String[] args) {
		RestAssured.baseURI = "https://dev79032.service-now.com/api/now/table/incident";
		RestAssured.authentication = RestAssured.basic("admin", "Tuna@123");
		
		File file =  new File("./data/CreateIncidentSchema.json");
		
		Response response =  RestAssured
				.given()
				//request header
				.contentType(ContentType.JSON)
				.when()
				.post()
				.then()
				.assertThat()
				.body(JsonSchemaValidator.matchesJsonSchema(file))
				.contentType(ContentType.JSON)
				.statusCode(201)
				.extract().response()
				;
		
		response.prettyPrint();

	}

}
