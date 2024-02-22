package stepdefinitions;


import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.WebDriverUtils;

public class GooglePageSteps extends WebDriverUtils
{
	List<WebElement> suggestions = null;
	List<WebElement> results = null;
	
	
	@Given("user is on google/yahoo search page")
	public void user_is_on_google_search_page() {
	    getDriver();
	    driver.get("https://www.google.com/");
	}

	@When("user enter(s) {} in the search box")
	public void user_enter_synechron_in_the_search_box(String text) {
	    driver.findElement(By.name("q")).sendKeys(text);
	}

	@Then("google displayes auto suggestion")
	public void google_displayes_auto_suggestion() {
	    suggestions = null;
	    suggestions = driver.findElements(By.xpath("//ul[@role='listbox']//div[@role='presentation']/span"));
	    System.out.println("Total Suggestions displayed " + suggestions.size());
	}

	@Then("user print all the auto suggestion")
	public void user_print_all_the_auto_suggestion() {
		printCollection(suggestions);
	
	}

	@Then("close the browser")
	public void close_the_browser() {
		System.out.println("closing the Browser");
		if(driver!=null) {
			driver.close();
			driver = null;
		}
		else
		{
			System.out.println("Driver is already null");
		}
	    suggestions = null;
	    results = null;
	    		
	}

	@When("click on search button")
	public void click_on_search_button() {
	    driver.findElement(By.name("btnK")).click();
	}

	@Then("google/yahoo result(s) are displayed")
	public void google_results_are_displayed() {
	    results = driver.findElements(By.tagName("h3"));
	    System.out.println("Total search Results " + results.size());
	}

	@Then("user print(s) all the hyperlinks from the result(s) page")
	public void user_prints_all_the_hyperlinks_from_the_results_page() {

		printCollection(results);
	}

	@Then("user print(s) only hyperlinks which are starting with {}")
	public void user_prints_only_hyperlinks_which_are_starting_with_synechron(String searchText) {
	    
		results = driver.findElements(By.xpath("//h3[starts-with(text(),'" + searchText + "')]"));
		System.out.println("Printing only links starting with " + searchText + " : " + results.size());
		printCollection(results);
	}



	public void printCollection(List<WebElement> collections)
	{
		for (WebElement collection : collections) 
		{
			if(collection.getText().length()>0)
				System.out.println(collection.getText());
			
		}
	}
	
	
	@When("user enter text in searchbox and print all the suggestion as List")
	public void user_enter_text_in_searchbox_and_print_all_the_suggestion(DataTable dataTable) throws InterruptedException 
	{
		List<String> data = dataTable.asList();
		int iteration = data.size();
		for (int i = 0; i < iteration; i++) 
		{
			System.out.println("Searching for " + data.get(i));
			
			user_enter_synechron_in_the_search_box(data.get(i));
			Thread.sleep(5000);
			google_displayes_auto_suggestion();
			user_print_all_the_auto_suggestion();
			driver.findElement(By.name("q")).clear();
			Thread.sleep(5000);
			
			
		}
		    		
	}
	
	@When("user enter text in searchbox and print all the suggestion as Map")
	public void user_enter_text_in_searchbox_and_print_all_the_suggestion_as_map(DataTable dataTable) throws InterruptedException 
	{
		List<Map<String, String>> data = dataTable.asMaps();
		int iteration = data.size();
		for (int i = 0; i < iteration; i++) 
		{
			System.out.println("Searching for " + data.get(i).get("companyName"));
			
			user_enter_synechron_in_the_search_box(data.get(i).get("companyName"));
			Thread.sleep(5000);
			google_displayes_auto_suggestion();
			user_print_all_the_auto_suggestion();
			driver.findElement(By.name("q")).clear();
			Thread.sleep(5000);
		}
			
	}

	


}
