package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MultiplicationSteps {

	int num ;
	
	@Given("user has a number")
	public void user_has_a_number() {
	    num = 10;
	}

	@Given("user has a {int}")
	public void user_has_a_twentyfive(int number) {
		num = number ; 
	}

	@When("a table for numbers is generated")
	public void a_table_for_twenty_numbers_is_generated() {
	   System.out.println("Generating a Table for " + num +  " from 1-20");
	}

	@Then("the application prints the table generated")
	public void the_application_prints_the_table_generated() {
		 for (int i = 1; i < 20 ; i++) 
		    {
		    	System.out.println(num + " * " + i + " = " + (num * i));
				
			}
	}

}
