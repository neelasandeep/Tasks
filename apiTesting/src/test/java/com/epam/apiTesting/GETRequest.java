package com.epam.apiTesting;

import java.util.ArrayList;


import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class GETRequest {
	
	
	@Ignore  
	@Test
	public void requesting() {
		RestAssured.baseURI="https://petstore.swagger.io/v2/pet";
		RequestSpecification request=RestAssured.given();
		Response response=request.request(Method.GET,"/15");
		int statusCode=response.getStatusCode();
		//System.out.println(statusCode);
		Assert.assertEquals(200, statusCode);
		
	}
	@Ignore
	@Test
	public void resposeHeader() {
		RestAssured.baseURI="https://petstore.swagger.io/v2/pet";
		RequestSpecification request=RestAssured.given();
		Response response=request.request(Method.GET,"/15");
		String contentType=response.getHeader("Content-Type");
		System.out.println(contentType);
		Assert.assertEquals("application/json", contentType);
	}
	
	
	@Test
	public void responseHeader() {
		RestAssured.baseURI="https://jsonplaceholder.typicode.com/users";
		RequestSpecification request=RestAssured.given();
		Response response=request.request(Method.GET);
          ArrayList<String>users= response.jsonPath().get("id");
              System.out.println(users.size());
              Assert.assertEquals(10, users.size());
		
	}

}
