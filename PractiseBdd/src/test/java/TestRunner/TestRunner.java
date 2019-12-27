package TestRunner;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.epam.makemytriptestcasespagess.BaseClass;
import com.epam.utilities.AllureReportListener;

import org.testng.annotations.BeforeClass;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.TestNGCucumberRunner;

import cucumber.api.testng.CucumberFeatureWrapper;



import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;





@CucumberOptions(features = "src/main/java/Features", glue = { "stepdefs" }
,tags={"@Traveller"}
      //, plugin = { "pretty",
	//	"html:target/cucumber-reports/cucumber-pretty", "json:target/cucumber-jsonReports/CucumberTestReport.json",
//	                "rerun:target/cucumber-reports/rerun.txt"
)
@Listeners({ AllureReportListener.class })
public class TestRunner extends BaseClass {
	private TestNGCucumberRunner testNGCucumberRunner;

	@BeforeClass(alwaysRun = true)
	public void setUpClass() throws Exception {
		testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
	}
	@Test(description = "Runs Cucumber Feature", dataProvider = "features")
	public void feature(CucumberFeatureWrapper cucumberFeature) {

		
		testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
	}

	@DataProvider
	public Object[][] features() {
		return testNGCucumberRunner.provideFeatures();
	}

	@AfterClass(alwaysRun = true)
	public void tearDownClass() throws Exception {
		testNGCucumberRunner.finish();
	}

}
