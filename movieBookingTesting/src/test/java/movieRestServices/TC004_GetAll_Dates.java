package movieRestServices;

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
public class TC004_GetAll_Dates extends TestBase{
	@BeforeClass
	public void getEmployees() {
		RestAssured.baseURI = config.getbaseURI();
		httpRequest = RestAssured.given();
		response = httpRequest.request(Method.GET,"dates");
	}

	@Test
	void CheckResponseBody() {
		logger.info("******checking Response Body**************");
		String responseBody = response.getBody().asString();
		logger.info("Response Body===>" + responseBody);
		Assert.assertTrue(responseBody != null);

	}

	@Test
	void CheckStatusCode() {
		logger.info("******checking Status Code**************");
		int statuscode = response.getStatusCode();
		logger.info(statuscode);
		Assert.assertEquals(statuscode, 200);

	}

	@Test
	void CheckResponseTime() {
		logger.info("******checking ResponseTime**************");
		long responseTime = response.getTime();
		logger.info(responseTime);
		if (responseTime > 5000)
			logger.warn("Response Time is Greater Than 5000");

		Assert.assertTrue(responseTime < 5000);

	}

	@AfterClass
	void tearDown() {
		logger.info("*******Completed TC001_Get_All_Employees Test ***********");
	}

}
