package testrunner;

import java.util.Date;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)

@CucumberOptions (features = {"src/test/java/features/"},
				 glue = {"stepdefinitions"},
				 plugin = {"pretty","junit:target/JunitReports/report.xml",
						 			"json:target/JsonReports/report.json",
						 			"html:target/HTMLReports/report.html"
						 	},
				 monochrome = true,
//				 tags = "@non-ui",
//				 tags = "@non-ui and @smoke",
//				 tags = "@non-ui or @smoke",
				 tags = "@ui and not @google",
//				 dryRun = true
				 dryRun = false
		
		)
public class TestRunner {

}
