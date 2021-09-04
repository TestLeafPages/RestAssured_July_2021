package learn.wiremock;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class LearnWireMockRecording {

	
	@Test
	public void getIncident() {
		RestAssured.baseURI = "http://localhost:8080/api/now/table/incident";
		RestAssured.authentication = RestAssured.basic("admin", "Tuna@123");
		 Response response = RestAssured
				 .given()
				 .contentType(ContentType.JSON)
				 .body("{ \"short_description\": \"create incident with body as string\", \"category\": \"hardware\" }")
				 .post();
		response.prettyPrint();
	}

	
}
