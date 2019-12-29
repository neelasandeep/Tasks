package rdportaltest;

import org.testng.annotations.Test;

import dataprovider.Dataprovider;
import register.RegisterEmployee;

public class InsertTest {

	@Test(dataProvider = "empdata", dataProviderClass = Dataprovider.class)
	public void storeSeatInfo(String empdata) {
		RegisterEmployee employee = new RegisterEmployee();
		employee.registerEmployee(empdata);
		employee.checkregisteredDetails();

	}

}
