package com.epam.apiTesting;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class PostMethodJsonToPojo {

	
	
	@Test
	public void pojoCheck(){
		ObjectMapper mapper=new ObjectMapper();
		String JsonSting="{\r\n" + 
				"    \"id\": 78,\r\n" + 
				"    \"name\": \"Ervin Howell\",\r\n" + 
				"    \"username\": \"Antonette\",\r\n" + 
				"    \"email\": \"Shanna@melissa.tv\",\r\n" + 
				"    \"address\": {\r\n" + 
				"      \"street\": \"Victor Plains\",\r\n" + 
				"      \"suite\": \"Suite 879\",\r\n" + 
				"      \"city\": \"Wisokyburgh\",\r\n" + 
				"      \"zipcode\": \"90566-7771\",\r\n" + 
				"      \"geo\": {\r\n" + 
				"        \"lat\": \"-43.9509\",\r\n" + 
				"        \"lng\": \"-34.4618\"\r\n" + 
				"      }\r\n" + 
				"    },\r\n" + 
				"    \"phone\": \"010-692-6593 x09125\",\r\n" + 
				"    \"website\": \"anastasia.net\",\r\n" + 
				"    \"company\": {\r\n" + 
				"      \"name\": \"Deckow-Crist\",\r\n" + 
				"      \"catchPhrase\": \"Proactive didactic contingency\",\r\n" + 
				"      \"bs\": \"synergize scalable supply-chains\"\r\n" + 
				"    }\r\n" + 
				"  }";
		
		
		try {
			UserPojo user1 = mapper.readValue(JsonSting, UserPojo.class);
			System.out.println(user1);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
