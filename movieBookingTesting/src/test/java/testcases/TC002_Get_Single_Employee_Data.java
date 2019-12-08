package testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base.TestBase;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import utilities.listeners.TestListenerr;
@Listeners({ TestListenerr.class })
public class TC002_Get_Single_Employee_Data extends TestBase {
	@BeforeClass
	public void getEmployees() {
		RestAssured.baseURI=config.getDataFromConfig("emppath");
		 httpRequest=RestAssured.given();
		 response= httpRequest.request(Method.GET,"/employee/"+empId);
	}
	@Test
	void CheckResponseBody() {
		logger.info("******checking Response Body**************");
		String responseBody=response.getBody().asString();
		logger.info("Response Body===>"+responseBody);
		Assert.assertEquals(responseBody.contains(empId),true);
		
	}
	@Test
	void CheckStatusCode() {
		logger.info("******checking Status Code**************");
		int statuscode=response.getStatusCode();
		logger.info(statuscode);
		Assert.assertEquals(statuscode, 200);
		
	}
	@Test
	void CheckResponseTime() {
		logger.info("******checking ResponseTime**************");
		long responseTime=response.getTime();
		logger.info(responseTime);
		if(responseTime>100000) 
			logger.warn("Response Time is Greater Than 5000");
			
		//Assert.assertTrue(responseTime<13000);
		
		
	}
	@AfterClass
	void tearDown() {
		logger.info("*******Completed TC001_Get_All_Employees Test ***********");
	}
	
}
