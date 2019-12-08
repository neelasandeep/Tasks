package com.epam.apiTesting;

import java.util.LinkedHashMap;
import java.util.Map;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class PostChecking {

    @Test
	public void postcheck() {

		ObjectMapper mapper = new ObjectMapper();
		UserPojo user = createDummyUser();

		try {
			String jsonInString = mapper.writeValueAsString(user);
			RestAssured.baseURI="https://petstore.swagger.io/v2/pet";
			RequestSpecification request=RestAssured.given();
			request.header("Content-Type","application/json");
			System.out.println(jsonInString);
			request.body(jsonInString);
			Response response=request.request(Method.POST);
			
			
			int id=response.jsonPath().get("id");
			String contentType=response.getHeader("Content-Type");
			String acsess_control=response.getHeader("access-control-allow-origin");
			
			
			Assert.assertEquals(3, id);
			Assert.assertEquals("*", acsess_control);
			Assert.assertEquals("application/json", contentType);
			Assert.assertEquals(200, response.getStatusCode());
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static UserPojo createDummyUser() {

		UserPojo user = new UserPojo();
		Address address = new Address();

		user.setId(3);
		user.setName("Sandeep");
		user.setUsername("Neela");
		user.setEmail("sandeep199@");
		address.setStreet("vijayapuricolony");
		address.setSuite("2");
		address.setCity("hyderabad");
		address.setZipcode("500035");
		Map<String, String> geo = new LinkedHashMap<>();
		geo.put("lat", "-37.3159");
		geo.put("lng", "81.1496");
		address.setGeo(geo);
		user.setAddress(address);
		user.setPhone("9876543223");
		user.setWebsite("hildegard.org");
		Map<String, String> company = new LinkedHashMap<>();
		company.put("name", "Romaguera-Crona");
		company.put("catchPhrase", "Multi-layered client-server neural-net");
		company.put("bs", "harness real-time e-markets");

		user.setCompany(company);

		return user;

	}

}

