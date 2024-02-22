package parallel;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.WebDriverUtils;

public class FormySteps extends WebDriverUtils {

	String firstname, lastname, jobtitle, education, sex, experience;
	private WebDriver driver = null;
	
	@Given("User is on formy form page")
	public void user_is_on_formy_form_page() {
		this.driver = getDriver("chrome");
		driver.get("https://formy-project.herokuapp.com/form");
		Assert.assertEquals("Formy", driver.getTitle());
	}

	@When("User enter firstname {}")
	public void user_enter_user_firstname(String fn) {
		driver.findElement(By.id("first-name")).sendKeys(fn);
	}

	@When("user enter lastname {}")
	public void user_enter_user_lastname(String ln) {
		driver.findElement(By.id("last-name")).sendKeys(ln);
	}

	@When("user enter jobtitle {}")
	public void user_enter_jottitle(String jt) {
		driver.findElement(By.id("job-title")).sendKeys(jt);
	}

	@When("select {} details")
	public void select_education_details(String type) {
		switch (type) {
		case "College":
			driver.findElement(By.id("radio-button-1")).click();
			break;

		case "High School":
			driver.findElement(By.id("radio-button-2")).click();
			break;

		case "Grad School":
			driver.findElement(By.id("radio-button-3")).click();
			break;

		default:
			System.out.println("Option is wrong!!!");
			break;
		}

	}

	@When("select the {} type")
	public void select_the_sex_type(String type) {
		switch (type) {
		case "Male":
			driver.findElement(By.id("checkbox-1")).click();
			break;

		case "Female":
			driver.findElement(By.id("checkbox-2")).click();
			break;

		case "Prefer not to say":
			driver.findElement(By.id("checkbox-3")).click();
			break;

		default:
			System.out.println("Option is wrong!!!");
			break;
		}

	}

	@When("user provide total {}")
	public void user_provide_total_experience(String exp) {
		WebElement dropDown = driver.findElement(By.id("select-menu"));
		Select sel = new Select(dropDown);

		sel.selectByVisibleText(exp);
	}

	@When("select the current date")
	public void select_the_current_date() {
		driver.findElement(By.id("datepicker")).click();
		driver.findElement(By.xpath("//td[@class='today day']")).click();
	}

	@When("click on submit button")
	public void click_on_submit_button() {
		driver.findElement(By.linkText("Submit")).click();

	}

	@Then("user validate the success message")
	public void user_validate_the_success_message() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement ele = wait
				.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@role='alert']"))));

		System.out.println("***********************************");
		System.err.println(ele.getText());
		System.out.println("***********************************");

		 driver.close();
		 driver=null;

	}

	@When("user enters and submit all the required values and validate success messsage as list")
	public void user_enters_and_submit_all_the_required_values_and_validate_success_messsage_as_list(
			DataTable dataTable) {
		List<List<String>> data = dataTable.asLists();
		int iterations = data.size();
		System.out.println("Total " + iterations + " number of data available in the data table");
		for (int i = 0; i < iterations; i++) {
			System.out.println("Element at index " + i + " is :");
			printCollections(data.get(i));

			List<String> values = data.get(i);

			firstname = values.get(0);
			lastname = values.get(1);
			jobtitle = values.get(2);
			education = values.get(3);
			sex = values.get(4);
			experience = values.get(5);

			user_enter_user_firstname(firstname);
			user_enter_user_lastname(lastname);
			user_enter_jottitle(jobtitle);
			select_education_details(education);
			select_the_sex_type(sex);
			user_provide_total_experience(experience);
			click_on_submit_button();
			user_validate_the_success_message();
			LaunchFormyFormpage();
			values.clear();
		}
	}

	public void LaunchFormyFormpage() {
		driver.get("https://formy-project.herokuapp.com/form");
		Assert.assertEquals("Formy", driver.getTitle());
	}

	@When("user enters and submit all the required values and validate success messsage as Map")
	public void user_enters_and_submit_all_the_required_values_and_validate_success_messsage_as_map(
			DataTable dataTable) {
		List<Map<String, String>> data = dataTable.asMaps();
		int iterations = data.size();
		System.out.println("Total " + iterations + " number of data available in the data table");

		for (int i = 0; i < iterations; i++) {
			System.out.println("Element at index " + i + " is :");
			printCollections(data.get(i));
			firstname = data.get(i).get("firstname");
			lastname = data.get(i).get("lastname");
			jobtitle = data.get(i).get("jobtitle");
			education = data.get(i).get("education");
			sex = data.get(i).get("sex");
			experience = data.get(i).get("experience");
			user_enter_user_firstname(firstname);
			user_enter_user_lastname(lastname);
			user_enter_jottitle(jobtitle);
			select_education_details(education);
			select_the_sex_type(sex);
			user_provide_total_experience(experience);
			click_on_submit_button();
			user_validate_the_success_message();
			LaunchFormyFormpage();
		}
	}

	

}