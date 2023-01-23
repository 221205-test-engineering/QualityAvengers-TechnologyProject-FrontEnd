package com.revature.steps.khavvia;

import com.revature.pages.IndexPage;
import com.revature.pages.LoginPage;
import com.revature.pages.MainPage;
import com.revature.pages.RegisterPage;
import com.revature.runners.LoginUpdateRegisterRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class UpdatePositiveStepImpl {
    public WebDriver driver1 = LoginUpdateRegisterRunner.driver1;
    public IndexPage indexPage1 = LoginUpdateRegisterRunner.indexPage1;
    public RegisterPage registerPage1 = LoginUpdateRegisterRunner.registerPage1;
    public LoginPage loginPage1 = LoginUpdateRegisterRunner.loginPage1;
    public MainPage mainPage1 = LoginUpdateRegisterRunner.mainPage1;
    @Given("the employee is on their home page")
    public void the_employee_is_on_their_home_page() throws InterruptedException{
        driver1.get("http://127.0.0.1:5501/index.html");
        new WebDriverWait(driver1, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(indexPage1.loginButton));
        indexPage1.loginButton.click();
        loginPage1.usernameField.sendKeys("gatorFan99");
        loginPage1.passwordField.sendKeys("chomp!!");
        loginPage1.loginButton.click();
        Thread.sleep(1000);
    }
    @When("the employee clicks on edit user profile")
    public void the_employee_clicks_on_edit_user_profile() throws InterruptedException {
        mainPage1.editProfileLink.click();
        Thread.sleep(1000);
    }
    @When("the employee types in pass1234")
    public void the_employee_types_in_pass1234() {
        registerPage1.passwordField.clear();
        registerPage1.passwordField.sendKeys("chomp!!");//////////change this back to pass1234
    }
    @When("the employee clicks on the checkbox next to display biometrics")
    public void the_employee_clicks_on_the_checkbox_next_to_display_biometrics() {
        registerPage1.biometricsField.click();
    }
    @When("the employee clicks on the submit button")
    public void the_employee_clicks_on_the_submit_button() throws InterruptedException{
        registerPage1.submitButton.click();
        Thread.sleep(1000);

    }
    @Then("the employee should see an alert saying Are you sure you want to edit your user profile")
    public void the_employee_should_see_an_alert_saying_are_you_sure_you_want_to_edit_your_user_profile() {
        driver1.switchTo().alert();
    }
    @When("the employee clicks ok")
    public void the_employee_clicks_ok() throws InterruptedException{
        driver1.switchTo().alert().accept();
        Thread.sleep(1000);
    }

    // fix this
    @Then("the employee should see an alert saying update successful")
    public void the_employee_should_see_an_alert_saying_update_successful() {
        driver1.switchTo().alert().accept();
    }

}
