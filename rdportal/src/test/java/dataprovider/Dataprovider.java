package dataprovider;

import java.io.IOException;
import java.util.List;

import org.testng.annotations.DataProvider;

import utilities.ExcelDataProvider;

public class Dataprovider {
	@DataProvider(name = "empdata")
	public String[] getEmpData() throws IOException {
		List<String> urlString;

		ExcelDataProvider excel = new ExcelDataProvider();

		urlString = excel.getStringData(0);

		String[] empData = new String[urlString.size()];
		for (int datalength = 0; datalength < urlString.size(); datalength++) {
			empData[datalength] = urlString.get(datalength);
		}
		return empData;
	}

}
