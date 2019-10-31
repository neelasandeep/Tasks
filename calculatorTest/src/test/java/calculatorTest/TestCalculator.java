package calculatorTest;



import java.util.logging.Logger;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Test;

import com.epam.tat.module4.Calculator;

//@Listeners(Listenerclass.class)
public class TestCalculator {  
	static Logger logger = Logger.getLogger(TestCalculator.class.getName());
	Calculator calculator;
	@BeforeMethod(alwaysRun=true)
	public void setUp() {
		calculator=new Calculator();
		
	}
	@Test(dataProvider="dataForDoubleSum",dataProviderClass=DataProviderClas.class,groups="Doublesum")
	public void sum (double number1,double number2, double expected) {
		System.out.println(Thread.currentThread().getId());
		Assert.assertEquals(calculator.sum(number1,number2), expected);
		
	}
	@Test(expectedExceptions = NumberFormatException.class, groups="Arithmetic")
	 public void DivideByZero() {
		Assert.assertEquals(calculator.div(1,0), 12);
	}
	@Test(dataProvider="dataForDoubleMul",dataProviderClass=DataProviderClas.class,groups="Arithmetic")
	public void mult (double number1,double number2, double expected) {
		System.out.println(Thread.currentThread().getId());
		Assert.assertEquals(calculator.mult(number1,number2), expected);
		
	}
	@Test(dataProvider="dataForDoubleDiv",dataProviderClass=DataProviderClas.class,groups="Arithmetic")
	public void div (double number1,double number2, double expected) {
		System.out.println(Thread.currentThread().getId());
		Assert.assertEquals(calculator.div(number1,number2), expected);
		
	}
	@Test(dataProvider="dataForDoubleSub",dataProviderClass=DataProviderClas.class,groups="Arithmetic")
	public void sub (double number1,double number2, double expected) {
		Assert.assertEquals(calculator.sub(number1,number2), expected);
		
	}
	@Test(dataProvider="dataForDoubleSqrt",dataProviderClass=DataProviderClas.class,groups="Arithmetic")
	public void sqrt (double number1, double expected) {
		System.out.println(Thread.currentThread().getId());
		Assert.assertEquals(calculator.sqrt(number1), expected);
		
	}
	@Test(dataProvider="dataForDoublePow",dataProviderClass=DataProviderClas.class,groups="Arithmetic")
	public void pow (double number1,double number2, double expected) {
		System.out.println(Thread.currentThread().getId());
		Assert.assertEquals(calculator.pow(number1,number2), expected);
		
	}
	
	@Test(dataProvider="dataFortg",dataProviderClass=DataProviderClas.class,groups="Doubletg")
	public void tg (double number1, double expected) {
		Assert.assertEquals(calculator.tg(number1), expected);
		
	}
//	@Test(dataProvider="dataForLongSum",dataProviderClass=DataProviderClas.class,groups="Longsum")
//	public void sum (long number1,long number2, long expected) {
//		Assert.assertEquals(calculator.sum(number1,number2), expected);
//		
//	}
	
	
	@AfterClass
	public void close() {
		logger.info("All completed");
		
	}

}
