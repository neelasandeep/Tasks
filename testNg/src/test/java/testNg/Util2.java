package testNg;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Util2 {
	
	private  XSSFSheet ExcelWSheet;
	 
	 private XSSFWorkbook ExcelWBook;
	 
	 
	 
	 private  XSSFRow Row;
	 String line="";
	
	 ArrayList<ArrayList<String>> dataObjects=new ArrayList<>();
	 ArrayList<String>  data=new ArrayList<>();
	public  ArrayList<ArrayList<String>> readXls() throws IOException {
		String path=System.getProperty("user.dir");
		ExcelWBook = new XSSFWorkbook(path+"\\excell\\data4.xlsx");
		 
	    ExcelWSheet = ExcelWBook.getSheet("Data4");
		
		
		
    for(int i=0;i<ExcelWSheet.getLastRowNum()+1;i++){
    	Row=ExcelWSheet.getRow(i);
    	
    	if(String.valueOf(Row.getCell(0)).contains("//")) {
    		dataObjects.add(data);
    		data=new ArrayList<>();
    	}else {
    	int j;
    	for( j=0;j<Row.getLastCellNum();j++) {
    	line+=Row.getCell(j)+",";
    	}
    	
    	
    	System.out.println(line);
    	data.add(line);
    	line="";
    	}
    	
//    	Row=ExcelWSheet.getRow(i);
//    	 System.out.println(Row.getCell(0));
//    	 if(row.contains("//")) {
//    		 dataObjects.add(data);
//    		 data=new ArrayList<>();
//    	 }else {
//    	 data.add(row);
//    	 }
       // String[] data = row.split(",");
    // do something with the data
}
     dataObjects.add(data);
    
     return dataObjects;
	}
	public static void main(String[] args) throws IOException {
		new Util2().readXls();
	}
}
