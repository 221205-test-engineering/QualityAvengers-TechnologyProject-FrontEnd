package com.revature.steps.khavvia;

import com.revature.pages.IndexPage;
import com.revature.pages.LoginPage;
import com.revature.pages.MainPage;
import com.revature.pages.RegisterPage;
import com.revature.runners.LoginUpdateRegisterRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
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
        loginPage1.usernameField.sendKeys("slafoy1");
        loginPage1.passwordField.sendKeys("3hOS1nh");
        loginPage1.loginButton.click();
        Thread.sleep(2000);
    }
    @When("the employee clicks on edit user profile")
    public void the_employee_clicks_on_edit_user_profile() throws InterruptedException {
        mainPage1.editProfileLink.click();
        Thread.sleep(1000);
    }
    @When("the employee clicks on the checkbox next to display biometrics")
    public void the_employee_clicks_on_the_checkbox_next_to_display_biometrics() {
        registerPage1.biometricsField.click();
    }
    @When("the employee clicks on the submit button")
    public void the_employee_clicks_on_the_submit_button() throws InterruptedException{
        registerPage1.submitButton.click();
        Thread.sleep(2000);
    }
    @Then("the employee should see an alert saying Are you sure you want to edit your user profile")
    public void the_employee_should_see_an_alert_saying_are_you_sure_you_want_to_edit_your_user_profile() {
        driver1.switchTo().alert();
    }
    @When("the employee clicks ok")
    public void the_employee_clicks_ok() {
        driver1.switchTo().alert().accept();
    }
    @Then("the employee should see an alert saying update successful")
    public void the_employee_should_see_an_alert_saying_update_successful() {
        driver1.switchTo().alert().accept();
    }

}
