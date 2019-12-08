package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {
	XSSFWorkbook workBook;
	XSSFSheet workSheet;
	public XSSFRow Row;

	Logger logger = Logger.getLogger(ExcelDataProvider.class);
	String line = "";

	public ExcelDataProvider() {
	File src = new File("./test-data/dataforEmp.xlsx");
		//File src = new File("./TestData/TestData.xlsx");
		// FileInputStream fis;
		try (FileInputStream fis = new FileInputStream(src);) {

			workBook = new XSSFWorkbook(fis);

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		} catch (Exception e) {
			logger.warn("Unable to Read Excel File" + e.getMessage());
		}

	}

	public List<String> getStringData(int sheetName) {
		List<String> urlString = new ArrayList<>();
		workSheet = workBook.getSheetAt(sheetName);
		for (int i = 1; i < workSheet.getLastRowNum() + 1; i++) {
			Row = workSheet.getRow(i);

			for (int j = 0; j < Row.getLastCellNum(); j++) {
				line += String.valueOf(Row.getCell(j)) + "%";

			}
			urlString.add(line);
			line = "";
		}
		return urlString;
	}

	public void getStringData(int sheetIndex, int row, int column) {
		workBook.getSheetAt(sheetIndex).getRow(row).getCell(column).getStringCellValue();
	}

	public void getStringData(String sheetName, int row, int column) {
		workBook.getSheet(sheetName).getRow(row).getCell(column).getStringCellValue();
	}

	public double getNumericData(String sheetName, int row, int column) {
		return workBook.getSheet(sheetName).getRow(row).getCell(column).getNumericCellValue();

	}
}
