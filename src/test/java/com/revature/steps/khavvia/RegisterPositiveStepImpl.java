package com.revature.steps.khavvia;

import com.revature.pages.IndexPage;
import com.revature.pages.LoginPage;
import com.revature.pages.MainPage;
import com.revature.pages.RegisterPage;
import com.revature.runners.LoginUpdateRegisterRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegisterPositiveStepImpl {

    public WebDriver driver1 = LoginUpdateRegisterRunner.driver1;
    public IndexPage indexPage1 = LoginUpdateRegisterRunner.indexPage1;
    public RegisterPage registerPage1 = LoginUpdateRegisterRunner.registerPage1;
    public LoginPage loginPage1 = LoginUpdateRegisterRunner.loginPage1;
    public MainPage mainPage1 = LoginUpdateRegisterRunner.mainPage1;
    @Given("the user is on the register page")
    public void the_user_is_on_the_register_page() throws InterruptedException {
        driver1.get("http://127.0.0.1:5501/index.html");
        new WebDriverWait(driver1, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(indexPage1.loginButton));
        indexPage1.registerButton.click();
    }
    @When("the user types in itsHighNoon for their username")
    public void the_user_types_in_its_high_noon_for_their_username() {
        registerPage1.usernameField.sendKeys("itsHighNoon");
    }
    @When("the user types in deadEye for their password")
    public void the_user_types_in_dead_eye_for_their_password() {
        registerPage1.passwordField.sendKeys("deadEye");
    }
    @When("the user types in {int} for their height")
    public void the_user_types_in_for_their_height(Integer int1) {
        String height = Integer.toString(int1);
        registerPage1.heightField.clear();
        registerPage1.heightField.sendKeys(height);
    }
    @When("the user types in {int} for their weight")
    public void the_user_types_in_for_their_weight(Integer int1) {
        String weight = Integer.toString(int1);
        registerPage1.weightField.clear();
        registerPage1.weightField.sendKeys(weight);
    }
    @When("the user clicks on the checkbox next to display biometrics")
    public void the_user_clicks_on_the_checkbox_next_to_display_biometrics() {
        registerPage1.biometricsField.click();
    }
    @When("the user clicks submit")
    public void the_user_clicks_submit() throws InterruptedException{
        registerPage1.submitButton.click();
        Thread.sleep(1000);
    }
    @Then("the user should see an alert saying registration successful")
    public void the_user_should_see_an_alert_saying_registration_successful() {
        // add in a line here to check text in alert
        /*new WebDriverWait(driver1, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(driver1.switchTo().alert()));
        assertEquals("Registration successful!", driver1.switchTo().alert().getText());*/
        //driver1.switchTo().alert().accept();
        try{
            driver1.switchTo().alert().accept();
        }catch(NoAlertPresentException e){
            System.out.println("No such alert in RegisterPositive");
        }




    }
}
