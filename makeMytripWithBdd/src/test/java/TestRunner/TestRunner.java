package TestRunner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.TestNGCucumberRunner;
import cucumber.api.testng.CucumberFeatureWrapper;

import org.testng.annotations.AfterClass;

import org.testng.annotations.BeforeClass;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.epam.makeMytriptestcasesPagess.BaseClass;

@CucumberOptions(features = "src/main/java/Features", glue = { "Stepdefs" }, plugin = { "pretty",
		"html:target/cucumber-reports/cucumber-pretty", "json:target/cucumber-jsonReports/CucumberTestReport.json",
//	                "rerun:target/cucumber-reports/rerun.txt"
})
public class TestRunner extends BaseClass {
	private TestNGCucumberRunner testNGCucumberRunner;

	@BeforeClass(alwaysRun = true)
	public void setUpClass() throws Exception {
		testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
	}

	@Test(description = "Runs Cucumber Feature", dataProvider = "features")
	public void feature(CucumberFeatureWrapper cucumberFeature) {

		loggerextent = extentreport.createTest("TestMakeMyTripNavBar");
		loggerextent.info("Test started");
		testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
	}

	@DataProvider(name = "features")
	public Object[][] features() {
		return testNGCucumberRunner.provideFeatures();
	}

	@AfterClass(alwaysRun = true)
	public void tearDownClass() throws Exception {
		testNGCucumberRunner.finish();
	}

}
