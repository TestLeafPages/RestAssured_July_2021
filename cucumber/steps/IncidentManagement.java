package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class IncidentManagement {

	Response response;
	
/*	@Given("set the endpoint")
	public void setEndpoint() {
		RestAssured.baseURI = "https://dev79032.service-now.com/api/now/table/incident";
	}

	@And("set the authorization")
	public void setAuthentication() {
		RestAssured.authentication = RestAssured.basic("admin", "Tuna@123");
	}
*/
	@When("you send the request as get")
	public void getIncident() {
		response = RestAssured.get();
	}

	@Then("verify the status code as {int}")// .* => for string
	public void verifyStatusCode(int code) {
		response.then().assertThat().statusCode(code);
	}

	@And("print the response")
	public void printResponse() {
		response.prettyPrint();
	}

	@When("you send the request as post")
	public void createIncident() {
		response = RestAssured
	   .given()
	   .contentType(ContentType.JSON)
	   .post();
	}
	
	@And("create incident with short_description as {string} and category as {string}")
	public void createIncidentWithShortdescriptionAndCategory(String description, String category) {
		response = RestAssured
		.given()
		.contentType(ContentType.JSON)
		.body("{ \"short_description\": \""+description+"\", \"category\": \""+category+"\" }")
		.post();
	}

	
	
	
	
	
	
	
	
	
	
	
	
}
