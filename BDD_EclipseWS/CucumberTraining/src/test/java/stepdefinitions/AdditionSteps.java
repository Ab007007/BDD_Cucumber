package stepdefinitions;


import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.BeforeStep;

//import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class AdditionSteps {
	int res;
	int num1,num2;
	double result;

//	@BeforeAll
//	public void first() {
//		System.out.println("Create Execution report");
//	}
//
//	@AfterAll
//	public void last() {
//		System.out.println("Save Execution report");
//	}
	
	
	
	@Given("user has two numbers")
	public void user_has_two_numbers() {
		System.out.println(" Numbers are passed from Step ");
		
	}


	@Then("sum of two numbers is valid")
	public void sum_of_two_numbers_is_valid() {
	    System.out.println("Sum of two numbers : " + res);
	    Assert.assertEquals(res, (num1+ num2));
		
	}

	@Then("user validates the successful addition")
	public void user_validates_the_successful_addition() {
		 Assert.assertEquals(res, (num1+ num2));
	}

	
	@When("user divide {int} and {int}")
	public void user_divide_num1_and_num2(Integer num1, Integer num2) {
		result =  num1 / num2;
	}

	
	@When("user add {double} and {double}")
	public void user_add_and(Double double1, Double double2) {
		result = double1 + double2;
	}
	
	
	@SuppressWarnings("deprecation")
	@Then("sum of two numbers is {double}")
	public void sum_of_two_numbers_is(Double res) {
		System.out.println("res " + res.doubleValue());
	//	System.out.println("result " + result.doubleValue());
		Assert.assertEquals(res.doubleValue(), result);
		
	}

	@Then("sum of two numbers is not equal to {double}")
	public void sum_of_two_numbers_is_not_equal_to(Double res) {
		System.out.println("!res " + res.doubleValue());
		System.out.println("!result " + result);
		
	    Assert.assertTrue(res.doubleValue()!=result); 
	}

	
	@Then("user may get float {double}")
	public void user_may_get_float(Double double1) {
	    System.out.println(double1);
	}




}
