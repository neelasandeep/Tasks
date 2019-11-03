package checkout;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listenerclass	implements ITestListener{

	public void onTestStart(ITestResult result) {
		System.out.println("test started");
		
	}

	
	public void onTestSuccess(ITestResult result) {
		System.out.println("success");
		
	}

	
	public void onTestFailure(ITestResult result) {
		System.out.println("test fialed");
		
	}

	
	public void onTestSkipped(ITestResult result) {
		System.out.println("test skipped");
		
	}


	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}


	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}


	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}		
}