package channing;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class DeleteIncident extends baseAPI{

	@Test(dependsOnMethods = {"channing.UpdateIncident.updateIncident"})
	public void deleteIncident() {
//		step3: Request Type 
		Response response = RestAssured
				.given()
				.log().all()
				.delete(sysID);
//		step6: print (Response)
		response.prettyPrint();
//		step4: print (Response Content type -> xml/json)
		System.out.println(response.contentType());
//		step5: print (Response statu code -> 200)
		System.out.println(response.statusCode());
	}

}
