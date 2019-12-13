package base;


import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.BeforeClass;


import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import utilities.ConfigDataprovider;

public class TestBase {
	public Logger logger;
	public ConfigDataprovider config;
	public Response response;
	public RequestSpecification httpRequest;
	public String empId;
	
	public List<String> urlString;

	@BeforeClass
	public void setUp() {

		PropertyConfigurator.configure(System.getProperty("user.dir") + "/src/main/java/resources/log4j.properties");
		logger = Logger.getLogger("RestAssured");
		config = new ConfigDataprovider();
		empId = "111";
				

	}




}
