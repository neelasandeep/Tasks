package testNg;

import java.io.IOException;
import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.epam.tat.module4.Calculator;

public class Testclass {

	ArrayList<ArrayList<String>> dataObject;
	Calculator calculator;
	SoftAssert softAssert;
	ArrayList<String> data;
	String[] dataItem;
	@BeforeMethod(alwaysRun = true)
	public void setUp() throws IOException {
		calculator = new Calculator();
		dataObject = new Util2().readXls();
	 softAssert=new SoftAssert();
	}

	@Test(groups = "Doublesum")
	public void sum() {
		
		data = dataObject.get(0);
		System.out.println(Thread.currentThread().getId());
		for(int i=0;i<data.size();i++) {
			softAssert.assertTrue(false);
			dataItem=data.get(i).split(",");
			
			softAssert.assertEquals(calculator.sum(Double.parseDouble(dataItem[0]),Double.parseDouble(dataItem[1])), Double.parseDouble(dataItem[2]));
		}
		softAssert.assertAll();
		
	}
	@Test(groups = "Arithmetic")
	public void mult() {
		
		 data = dataObject.get(1);
		System.out.println(Thread.currentThread().getId());
		for(int i=0;i<data.size();i++) {
			softAssert.assertTrue(false);
		dataItem=data.get(i).split(",");
			softAssert.assertEquals(calculator.mult(Double.parseDouble(dataItem[0]),Double.parseDouble(dataItem[1])), Double.parseDouble(dataItem[2]));
		}
		softAssert.assertAll();
		
	}
	@Test(expectedExceptions = NumberFormatException.class, groups="Arithmetic")
	 public void DivideByZero() {
		Assert.assertEquals(calculator.div(1,0), 12);
	}
	@Test(dependsOnMethods="DivideByZero",expectedExceptions = NumberFormatException.class,groups = "Arithmetic")
	public void div() {
		
	 data = dataObject.get(2);
		System.out.println(Thread.currentThread().getId());
		for(int i=0;i<data.size();i++) {
			softAssert.assertTrue(false);
		dataItem=data.get(i).split(",");
			softAssert.assertEquals(calculator.div(Double.parseDouble(dataItem[0]),Double.parseDouble(dataItem[1])), Double.parseDouble(dataItem[2]));
		}
		softAssert.assertAll();
		
	}
	
	
	@Test(groups = "Arithmetic")
	public void sub() {
	
		 data = dataObject.get(3);
		System.out.println(Thread.currentThread().getId());
		for(int i=0;i<data.size();i++) {
			softAssert.assertTrue(false);
		 dataItem=data.get(i).split(",");
			softAssert.assertEquals(calculator.sub(Double.parseDouble(dataItem[0]),Double.parseDouble(dataItem[1])), Double.parseDouble(dataItem[2]));
		}
		softAssert.assertAll();
		
	}
	@Test(groups = "Arithmetic")
	public void sqrt() {
	
		 data = dataObject.get(4);
		System.out.println(Thread.currentThread().getId());
		for(int i=0;i<data.size();i++) {
			softAssert.assertTrue(false);
		 dataItem=data.get(i).split(",");
			softAssert.assertEquals(calculator.sqrt(Double.parseDouble(dataItem[0])), Double.parseDouble(dataItem[1]));
		}
		softAssert.assertAll();
		
	}
	@Test(groups = "Arithmetic")
	public void pow() {
	
		 data = dataObject.get(5);
		System.out.println(Thread.currentThread().getId());
		for(int i=0;i<data.size();i++) {
			softAssert.assertTrue(false);
		 dataItem=data.get(i).split(",");
			softAssert.assertEquals(calculator.pow(Double.parseDouble(dataItem[0]),Double.parseDouble(dataItem[1])), Double.parseDouble(dataItem[2]));
		}
		softAssert.assertAll();
		
	}
	
}
