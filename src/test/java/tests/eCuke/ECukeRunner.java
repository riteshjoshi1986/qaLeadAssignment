package tests.eCuke;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@CucumberOptions(
		features = {"src/test/java/tests/Features/APITest.feature"},
		tags = {"@api"},
		glue = { "tests.stepDefs"},
		plugin = {"pretty","html:target/cucumber-html-report-ECuke/","json:target/cucumber-json-report/cucumberReport_Batch1.json"}
		)
@RunWith(Cucumber.class)
public class ECukeRunner {}
