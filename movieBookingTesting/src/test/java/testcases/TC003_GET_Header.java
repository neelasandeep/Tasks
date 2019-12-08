package testcases;


import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base.TestBase;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utilities.listeners.TestListenerr;

@Listeners({ TestListenerr.class })
public class TC003_GET_Header extends TestBase {
	
	@Test
	  public void get() {
		RestAssured.baseURI=config.getDataFromConfig("googleuri");
		RequestSpecification httpRequest=RestAssured.given();
		Response responce= httpRequest.request(Method.GET,config.getDataFromConfig("googlepath"));
		String responseBody=responce.getBody().asString();
		logger.info(responseBody);
		
		Headers allheaders=responce.headers();
		for(Header head:allheaders) {
			logger.info(head.getName()+" --> "+head.getValue());
		}
		logger.info(responce.getStatusCode());
	  }
	
	  

}
