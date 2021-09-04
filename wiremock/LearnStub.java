package learn.wiremock;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class LearnStub {

/*	@BeforeMethod
	public void mockCreateIncident() {
		stubFor(post("/api/now/table/incident")
				.willReturn(aResponse()
						.withStatus(201)
						.withHeader("content-type", "application/json")
						.withBody("{ \r\n" + 
								"	'Number' : 'INC123456',\r\n" + 
								"	'sys_id' : '2435465d687f98g9h0joyteknre',\r\n" + 
								"	'category': 'Hardware'\r\n" + 
								"}")));
	}*/	
	
	@Test
	public void getIncident() {
		RestAssured.baseURI = "http://localhost:8080/api/now/table/incident";
//		RestAssured.authentication = RestAssured.basic("admin", "Tuna@123");
		 Response response = RestAssured
				 .given()
				 .contentType(ContentType.JSON)
				 .body("{ \"short_description\": \"create incident with body as string\", \"category\": \"hardware\" }")
				 .post();
		response.prettyPrint();
	}

	
}
