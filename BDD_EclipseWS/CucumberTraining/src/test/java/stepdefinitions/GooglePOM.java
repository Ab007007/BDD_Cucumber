package stepdefinitions;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page.GoogleSearchPage;
import utils.WebDriverUtils;

public class GooglePOM extends WebDriverUtils 
{

	GoogleSearchPage gsp = null;
	@Before("@development")
	public void setup()
	{
		driver = getDriver();
		gsp = new GoogleSearchPage(driver);
		
	}
	
	
	@After("@development")
	public void getStatusAndCaptureSS(Scenario sc)
	{
		if(sc.isFailed())
		{
			System.out.println("Scenario " + sc.getName() + " is Failed");
			String name = "SS_" + new Date().toString().replace(":", "_").replace(" ", "_");
			TakesScreenshot ss = (TakesScreenshot) driver;
			File sourceFile = ss.getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(sourceFile, new File("target/" + name + ".png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else
		{
			System.out.println("Scenario " + sc.getName() + " is passsed ");
			System.out.println("------------------------------------------");
			System.out.println("Scenario Details : " + sc.getId() + " and " + sc.getSourceTagNames());
			
		}
	}
	
	@Given("pomuser is on google search page")
	public void pomuser_is_on_google_search_page() {
		driver.get("https://www.google.com/");
	
	}
	@When("pomuser enter {} in the search box")
	public void pomuser_enter_synechron_in_the_search_box(String text) {
	    gsp.enterText(text);
	}
	@Then("pomuser get auto suggestion")
	public void pomuser_get_auto_suggestion() {
	    gsp.getTotoalSuggetionCount();
	}
	@Then("pomuser print all the auto suggestion")
	public void pomuser_print_all_the_auto_suggestion() {
	   gsp.printAllSuggestions();
	}
	@Then("pomuser close the browser")
	public void pomuser_close_the_browser() {
	   driver.close();
	}

	
	@Then("fail the test")
	public void fail_the_test() {
	   Assert.assertFalse(true);
	}
}
