package com.epam.utilities;

import java.io.File;
import java.io.FileInputStream;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {
	XSSFWorkbook workBook;
	XSSFSheet workSheet;
     XSSFRow row;
	
	Logger logger = Logger.getLogger(ExcelDataProvider.class);
	String line="";
	public ExcelDataProvider() {
		File src = new File("./TestData/TestData.xlsx");
		
		try(FileInputStream fis = new FileInputStream(src);) {
			

			workBook = new XSSFWorkbook(fis);

		} catch (Exception e) {

			logger.info("file not found in excell data prrovider");
		} 
	}

	public List<String> getStringData(int sheetName) {
		List<String> urlString = new ArrayList<>();
		workSheet = workBook.getSheetAt(sheetName);
		for (int i = 0; i < workSheet.getLastRowNum() + 1; i++) {
			row = workSheet.getRow(i);
		
			for (int j = 0; j < row.getLastCellNum(); j++) {
				line+=String.valueOf(row.getCell(j))+"%";
				
			}
			urlString.add(line);
			line="";
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
