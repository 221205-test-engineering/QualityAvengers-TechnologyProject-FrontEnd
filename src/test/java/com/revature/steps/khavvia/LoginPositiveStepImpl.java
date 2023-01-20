package com.revature.steps.khavvia;

import com.revature.runners.LoginUpdateRegisterRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class LoginPositiveStepImpl {

    public static WebDriver driver = LoginUpdateRegisterRunner.driver;


    @Given("The employee is on the login page")
    public void the_employee_is_on_the_login_page() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("The employee types {string} into username input")
    public void the_employee_types_into_username_input(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("The employee types {string} into password input")
    public void the_employee_types_into_password_input(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("The employee clicks on the login button")
    public void the_employee_clicks_on_the_login_button() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("the employee should be on the {string} page")
    public void the_employee_should_be_on_the_page(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("The employee should see their name {string}")
    public void the_employee_should_see_their_name(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

}
