package utilities;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {
	XSSFWorkbook workBook;
	XSSFSheet workSheet;
	XSSFRow row;
	ConfigDataprovider config;
	Logger logger;
	String line = "";

	public ExcelDataProvider() throws IOException {
		config = new ConfigDataprovider();
		PropertyConfigurator.configure(config.getLogprop());
		logger = Logger.getLogger(ExcelDataProvider.class);
		File src = new File(config.getExcelPath());

		FileInputStream fis = new FileInputStream(src);
		workBook = new XSSFWorkbook(fis);

	}

	public List<String> getStringData(int sheetnumber) {
		List<String> urlString = new ArrayList<>();

		workSheet = workBook.getSheetAt(sheetnumber);
		for (int i = 1; i < workSheet.getLastRowNum() + 1; i++) {
			row = workSheet.getRow(i);

			for (int j = 0; j < row.getLastCellNum(); j++) {
				line=line.concat(String.valueOf(row.getCell(j)) + "%");

			}
			urlString.add(line);
			line = "";
		}
		return urlString;
	}

}
