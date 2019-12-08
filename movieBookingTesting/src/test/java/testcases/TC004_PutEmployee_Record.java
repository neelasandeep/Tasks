package testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import base.TestBase;
import io.restassured.RestAssured;
import io.restassured.http.Method;

import io.restassured.specification.RequestSpecification;
import utilities.listeners.TestListenerr;
@Listeners({ TestListenerr.class })
public class TC004_PutEmployee_Record extends TestBase {

	@Test(dataProvider = "updatedata")
	public void UpdateRecords(String data) throws JsonProcessingException {

		user = createDummyUser(data);
		System.out.println(data);
		ObjectMapper mapper = new ObjectMapper();
		String jsonInString = mapper.writeValueAsString(user);
		RestAssured.baseURI = config.getDataFromConfig("emppath");
		RequestSpecification httpRequest = RestAssured.given();

		httpRequest.header("Content-Type", "application/json");

		httpRequest.body(jsonInString);
		response = httpRequest.request(Method.PUT, "/update/" + empId);

		String responseBody = response.getBody().asString();
		logger.info(responseBody);
		Assert.assertTrue(responseBody != null);

		logger.info("******checking Status Code**************");
		int statuscode = response.getStatusCode();
		logger.info(statuscode);
		Assert.assertEquals(statuscode, 200);

		logger.info("******checking ResponseTime**************");
		long responseTime = response.getTime();
		logger.info(responseTime);
		if (responseTime > 8000)
			logger.warn("Response Time is Greater Than 5000");

		Assert.assertTrue(responseTime < 8000);

	}

	@AfterClass
	public void tearDown() {
		logger.info("******Finished Test**************");
	}

}
