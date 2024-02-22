package stepdefinitions;

import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;

public class Hooks {

	public static ExtentReports reports;
	public static ExtentTest test;

	@BeforeAll
	public static void setupReports() {
		 String date = new Date().toString().replace(":" , "_").replace(" ", " ");
		 ExtentSparkReporter spark = new ExtentSparkReporter("target/HTMLReports/ExtentSpark_"+ date+".html");
		 reports = new ExtentReports();
		 reports.attachReporter(spark);
	}
	@AfterAll
	public static void saveReports() {
		reports.flush();
	}
	@Before
	public void setup(Scenario sc) {
		test = reports.createTest(sc.getName());
	}
	@After
	public void tearDown(Scenario sc) {
		if(sc.isFailed())
		{
			test.log(Status.FAIL, "Scenario Failed");
		}
		else {
			test.log(Status.PASS,	"Test Execution successfull");
		}
		System.out.println();
	}
	@BeforeStep
	public void stepStatus(Scenario sc)
	{
		test.log(Status.INFO, sc.getLine() + " Executing ..." + " from " + sc.getName());
	}
	
	@AfterStep
	public void status(Scenario sc)
	{
		test.log(Status.INFO, sc.getLine() + " Executed ..." + " from " + sc.getName());
	}
	
	
}
