package dataprovider;

import java.io.IOException;
import java.util.List;

import org.testng.annotations.DataProvider;

import utilities.ExcelDataProvider;

public class Dataprovider {
	@DataProvider(name = "empdata")
	public String[] getEmpData() throws IOException {
		return getdata(3);
	}

	@DataProvider(name = "empupdatedata")
	public String[] getEmpUpdateData() throws IOException {
		return getdata(1);
	}
	@DataProvider(name = "empdeletedata")
	public String[] getEmpDeleteData() throws IOException {
		return getdata(2);
	}

	public String[] getdata(int sheetNumber) throws IOException {
		List<String> urlString;

		ExcelDataProvider excel = new ExcelDataProvider();

		urlString = excel.getStringData(sheetNumber);

		String[] empData = new String[urlString.size()];
		for (int datalength = 0; datalength < urlString.size(); datalength++) {
			empData[datalength] = urlString.get(datalength);
		}
		return empData;
	}

}
