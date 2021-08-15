package channing;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class CreateIncidentWithOutBody extends baseAPI{

	@Test
	public void createIncidentWithOutBody() {

//		step3: Request Type 
		Response response = RestAssured
				.given()
				.log().all()
				.contentType(ContentType.JSON)
				.post();
//		step6: print (Response)
		response.prettyPrint();
//		step4: print (Response Content type -> xml/json)
		System.out.println(response.contentType());
//		step5: print (Response statu code -> 200)
		System.out.println(response.statusCode());
		
		JsonPath jsonPath = response.jsonPath();
		sysID = jsonPath.get("result.sys_id");

	}

}
