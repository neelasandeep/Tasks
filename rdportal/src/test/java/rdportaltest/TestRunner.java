package rdportaltest;

import org.testng.annotations.Test;

import dataprovider.Dataprovider;
import register.DeleteEmpdata;
import register.RegisterEmployee;
import register.UpdateEmployee;

public class TestRunner {

	@Test(dataProvider = "empdata", dataProviderClass = Dataprovider.class,priority=1)
	public void registerEmpDataTest(String empdata) {
		RegisterEmployee employee = new RegisterEmployee();
		employee.registerEmployee(getEmpdata(empdata));
		employee.checkDetails(getEmpdata(empdata));

	}

	@Test(dataProvider = "empupdatedata", dataProviderClass = Dataprovider.class,priority=2)
	public void updateEmpDataTest(String empdata) {

		UpdateEmployee employee = new UpdateEmployee();
		employee.updateEmployee(getEmpdata(empdata));
		employee.checkDetails(getEmpdata(empdata));
	}

	@Test(dataProvider = "empdeletedata", dataProviderClass = Dataprovider.class,priority=3)
	public void deleteEmpDataTest(String empdata) {
		DeleteEmpdata employee = new DeleteEmpdata();
		employee.deleteEmployee(getEmpdata(empdata));

	}

	public String[] getEmpdata(String empdata) {
		return empdata.split("%");
	}

}
