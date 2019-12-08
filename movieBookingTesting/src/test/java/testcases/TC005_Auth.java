package testcases;


import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base.TestBase;
import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utilities.listeners.TestListenerr;

@Listeners({ TestListenerr.class })
public class TC005_Auth extends TestBase {
	
	
	
  @Test
  public void get() {
	RestAssured.baseURI=config.getDataFromConfig("auth");
	PreemptiveBasicAuthScheme authsceme=new PreemptiveBasicAuthScheme();
	authsceme.setUserName("ToolsQA");
	authsceme.setPassword("TestPassword");
	RestAssured.authentication=authsceme;
	RequestSpecification httpRequest=RestAssured.given();
	Response responce= httpRequest.request(Method.GET);
	String responseBody=responce.asString();
	logger.info(responseBody);
	logger.info(responce.getStatusCode());
  }
}
