package checkout;

import java.util.logging.Logger;

import org.testng.Assert;
import org.testng.annotations.AfterClass;

import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.epam.tat.module4.Calculator;

public class TestCalculator {
	static Logger logger = Logger.getLogger(TestCalculator.class.getName());
	static Calculator calculator;
	SoftAssert softAssert;

	@BeforeMethod
	public void setUp() {
		calculator = new Calculator();
		

	}

	@Test(dataProvider = "dataForDoubleSum", dataProviderClass = DataProviderClas.class, groups = "Arithmetic", priority = 1)
	public void sum(String number1, String number2, String expected) {
		System.out.println(Thread.currentThread().getId());
		Assert.assertEquals(calculator.sum(DoubleOf(number1), DoubleOf(number2)), DoubleOf(expected));

	}

	@Test(expectedExceptions = NumberFormatException.class, groups = "Arithmetic")
	public void DivideByZero() {
		Assert.assertEquals(calculator.div(1, 0), 1d / 0d);
	}

	@Test(dataProvider = "dataForDoubleMul", dataProviderClass = DataProviderClas.class, groups = "Arithmetic", priority = 2)
	public void mult(String number1, String number2, String expected) {
		System.out.println(Thread.currentThread().getId());
		Assert.assertEquals(calculator.mult(DoubleOf(number1), DoubleOf(number2)), DoubleOf(expected));

	}

	@Test(dataProvider = "dataForDoubleDiv", dataProviderClass = DataProviderClas.class, groups = "Arithmetic", priority = 3)
	public void div(String number1, String number2, String expected) throws java.lang.AssertionError {
		System.out.println(Thread.currentThread().getId());

		Assert.assertEquals(calculator.div(DoubleOf(number1), DoubleOf(number2)), DoubleOf(expected));

	}

	@Test(dataProvider = "dataForDoubleSub", dataProviderClass = DataProviderClas.class, groups = "Arithmetic", priority = 4)
	public void sub(String number1, String number2, String expected) {
		Assert.assertEquals(calculator.sub(DoubleOf(number1), DoubleOf(number2)), DoubleOf(expected));

	}

	@Test(dataProvider = "dataForDoubleSqrt", dataProviderClass = DataProviderClas.class, groups = "Arithmetic", priority = 5)
	public void sqrt(String number1, String expected) {
		System.out.println(Thread.currentThread().getId());
		Assert.assertEquals(calculator.sqrt(DoubleOf(number1)), DoubleOf(expected));

	}

	@Test(dataProvider = "dataForDoublePow", dataProviderClass = DataProviderClas.class, priority = 6)
	public void pow(String number1, String number2, String expected) {
		Assert.assertEquals(calculator.pow(DoubleOf(number1), DoubleOf(number2)), DoubleOf(expected));
	}
  public double DoubleOf(String number) {
	  return Double.parseDouble(number);
  }
	@AfterClass
	public void close() {
		logger.info("All completed");

	}

}
