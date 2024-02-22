package testrunner;


import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)

@CucumberOptions (features = {"src/test/resources"},
				 glue = {"parallel"},
				 plugin = {"pretty","junit:target/JunitReports/report.xml",
						 			"json:target/JsonReports/report.json",
						 			"html:target/HTMLReports/report.html"
						 	},
				 monochrome = true,
//				 dryRun = true
				 dryRun = false
		
		)
public class RunCucumberIT {

}
