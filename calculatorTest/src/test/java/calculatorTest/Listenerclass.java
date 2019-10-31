package calculatorTest;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listenerclass	implements ITestListener{

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("test started");
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("success");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("test fialed");
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("test skipped");
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}		
}