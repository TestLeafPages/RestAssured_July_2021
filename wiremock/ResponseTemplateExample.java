package learn.wiremock;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class ResponseTemplateExample {
	/*http://wiremock.org/docs/running-standalone/
		http://wiremock.org/docs/response-templating/
*/	@Test
	public void getIncident() {
		RestAssured.baseURI = "http://localhost:8080/testleaf/traning/course";
		 Response response = RestAssured
				 .given()
				 .queryParam("course_name", "Rest Assured")
				 .queryParam("type", "line")
				 .get();
		response.prettyPrint();
	}

	
}
