package page;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.WebDriverUtils;

public class GoogleSearchPage 
{

	
	@FindBy(name = "q")
	WebElement googleSearchBox;
	
	@FindBy(xpath = "//ul[@role='listbox']//div[@role='presentation']/span")
	List<WebElement> autoSuggestions;
	
	
	public void enterText(String text)
	{
		System.out.println("Entering the text " + text);
		googleSearchBox.sendKeys(text);
	}
	
	public void getTotoalSuggetionCount() {
		System.out.println("Total suggestions displayed is : " + autoSuggestions.size());
	}
	public void printAllSuggestions()
	{
		System.out.println("POM User Printing the Auto Suggestions");
		for (WebElement suggestion : autoSuggestions) 
		{
			if(suggestion.getText().length()>0)
				System.out.println(suggestion.getText());
			
		}
	}
	
	
	public GoogleSearchPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	
	
}
