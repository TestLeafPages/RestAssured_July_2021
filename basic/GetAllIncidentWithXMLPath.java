package basic;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

public class GetAllIncidentWithXMLPath {

	public static void main(String[] args) {
		RestAssured.baseURI = "https://dev79032.service-now.com/api/now/table/incident/8d641046c0a80164000bc7c0d3ed46a0";
		RestAssured.authentication = RestAssured.basic("admin", "Tuna@123");
		Response response = RestAssured
				.given()
//				.accept("application/xml")
				.accept(ContentType.XML)
				.get();
		response.prettyPrint();
		System.out.println(response.contentType());
		System.out.println(response.statusCode());
		
//		// need to parse xml
		XmlPath xmlPath = response.xmlPath();
//		
		String sysId = xmlPath.get("response.result.number");
		System.out.println(sysId);
	}

}
