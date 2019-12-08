package testcases;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import base.TestBase;
import io.restassured.RestAssured;
import io.restassured.http.Method;

import io.restassured.specification.RequestSpecification;
import pojo.PojoData;

public class TC003_Post_Employee_Record extends TestBase {
	PojoData user;
	List<String> urlString;

	@Test(dataProvider = "empdata")
	public void postEmployee(String data) throws JsonProcessingException {
		user = createDummyUser(data);
		System.out.println(data);
		ObjectMapper mapper = new ObjectMapper();
		String jsonInString = mapper.writeValueAsString(user);
		RestAssured.baseURI = config.getDataFromConfig("postpath");
		RequestSpecification httpRequest = RestAssured.given();
		httpRequest.header("Content-Type", "application/json");
		httpRequest.body(jsonInString);
		response = httpRequest.request(Method.POST);
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
