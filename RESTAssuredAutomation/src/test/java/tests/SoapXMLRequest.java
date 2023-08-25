package tests;

import org.apache.commons.io.IOUtils;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class SoapXMLRequest {
	@Test
	public void validateSOAPXML() throws IOException {
		File file = new File("./SoapRequest/Add.xml");
		if(file.exists()) 
			System.out.println("*********FILE EXISTS*******");
		FileInputStream fileIS = new FileInputStream(file);
		
		String request = IOUtils.toString(fileIS, "UTF-8");
		
		baseURI = "http://www.dneonline.com/";
		given().contentType(ContentType.XML).accept(ContentType.XML).body(request)
			.when().post("/calculator.asmx").then().statusCode(200).log().all();
	}
}
