package testRunner;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;



import cucumber.api.CucumberOptions;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;
import utilities.listeners.TestListener;

@CucumberOptions(features = "src/main/java/features", glue = { "stepdefs" },tags= {"@flights"}

)
@Listeners({ TestListener.class })
public class TestRunner {
	private TestNGCucumberRunner testNGCucumberRunner;

	@BeforeClass(alwaysRun = true)
	public void setUpClass() throws Exception {
		testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
	}

	@Test(description = "Runs Cucumber Feature", threadPoolSize = 5, dataProvider = "features")
	public void feature(CucumberFeatureWrapper cucumberFeature) {

	
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