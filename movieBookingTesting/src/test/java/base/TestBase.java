package base;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pojo.PojoData;
import utilities.ConfigDataprovider;
import utilities.ExcelDataProvider;

public class TestBase {
	public Logger logger;
	public ConfigDataprovider config;
	public Response response;
	public RequestSpecification httpRequest;
	public String empId;
	public PojoData user;
	public List<String> urlString;

	@BeforeClass
	public void setUp() {

		PropertyConfigurator.configure(System.getProperty("user.dir") + "/src/main/java/resources/log4j.properties");
		logger = Logger.getLogger("RestAssured");
		config = new ConfigDataprovider();
		empId = "111";
				

	}

	@DataProvider(name = "empdata")
	public String[] getEmpData() throws IOException {
		List<String> urlString;

		ExcelDataProvider excel = new ExcelDataProvider();

		urlString = excel.getStringData(0);
		// System.out.println( urlString.get(0));
		String[] empData = new String[urlString.size()];
		for (int datalength = 0; datalength < urlString.size(); datalength++) {
			empData[datalength] = urlString.get(datalength);
		}
		return empData;
	}

	@DataProvider(name = "updatedata")
	public String[] updateEmpData() throws IOException {
		List<String> urlString;

		ExcelDataProvider excel = new ExcelDataProvider();

		urlString = excel.getStringData(1);
		// System.out.println( urlString.get(0));
		String[] empData1 = new String[urlString.size()];
		for (int datalength = 0; datalength < urlString.size(); datalength++) {
			empData1[datalength] = urlString.get(datalength);
		}
		return empData1;
	}

	public PojoData createDummyUser(String data) {
		String employeedata[] = data.split("%");
		user = new PojoData();
		user.setName(employeedata[0]);
		user.setSalary(employeedata[1]);
		user.setAge(employeedata[2]);
		return user;
	}

}
