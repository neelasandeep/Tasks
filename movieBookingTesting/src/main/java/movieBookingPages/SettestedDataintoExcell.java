package moviebookingpages;

import java.io.FileInputStream;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class SettestedDataintoExcell {
	int row;
	 String data;
	BaseClass bs;
	Logger logger = Logger.getLogger(SettestedDataintoExcell.class);
	
	FileOutputStream fileOut;
	public SettestedDataintoExcell(String data) {
		super();
		
		this.data=data;
		bs = new BaseClass();
	}

	

	public  void setExcellData() {
		 
		 
		
		try (FileInputStream fis = new FileInputStream("./src/main/java/test-data/tested.xlsx");
				Workbook wb = new XSSFWorkbook(fis)){
			
			 Sheet sh1=wb.getSheet("Array");
			  row=sh1.getLastRowNum();
			 Row sheetRow=sh1.createRow(row+1);
			 logger.info(sh1.getLastRowNum());
			 String[] split=data.split("%");
			 for (int i = 0; i < split.length; i++) {
				Cell cell= sheetRow.createCell(i);
				 cell.setCellValue(split[i]);
				
			}
			  fileOut = new FileOutputStream("./src/main/java/test-data/tested.xlsx"); 
	
			logger.info("done");
			 wb.write(fileOut); 
			 
			
		} catch (IOException e) {
			
			logger.warn("Xl file not correct");
		}
		 
	}

}
