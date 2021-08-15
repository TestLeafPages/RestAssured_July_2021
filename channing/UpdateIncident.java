package channing;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UpdateIncident extends baseAPI{

	@Test(dependsOnMethods = {"channing.CreateIncidentWithOutBody.createIncidentWithOutBody"})
	public void updateIncident() {
//		step3: Request Type 
		Response response = RestAssured
				.given()
				.contentType(ContentType.JSON)
				.log().all()
				.body("{ \"short_description\": \"OS Update\", \"category\": \"software\" }")
				.pathParam("ID", sysID)
				.put("{ID}");
//		step6: print (Response)
		response.prettyPrint();
//		step4: print (Response Content type -> xml/json)
		System.out.println(response.contentType());
//		step5: print (Response statu code -> 200)
		System.out.println(response.statusCode());
	}

}
