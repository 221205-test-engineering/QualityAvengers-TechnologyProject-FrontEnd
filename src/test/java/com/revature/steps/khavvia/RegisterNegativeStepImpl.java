package com.revature.steps.khavvia;

import com.revature.pages.IndexPage;
import com.revature.pages.LoginPage;
import com.revature.pages.MainPage;
import com.revature.pages.RegisterPage;
import com.revature.runners.LoginUpdateRegisterRunner;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;

public class RegisterNegativeStepImpl {
    public WebDriver driver1 = LoginUpdateRegisterRunner.driver1;
    public IndexPage indexPage1 = LoginUpdateRegisterRunner.indexPage1;
    public RegisterPage registerPage1 = LoginUpdateRegisterRunner.registerPage1;
    public LoginPage loginPage1 = LoginUpdateRegisterRunner.loginPage1;
    public MainPage mainPage1 = LoginUpdateRegisterRunner.mainPage1;


    @When("the user types in {string} for their username")
    public void the_user_types_in_for_their_username(String string) {
        registerPage1.usernameField.sendKeys(" ");
    }

    @Then("the user should see an alert saying fields incomplete")
    public void the_user_should_see_an_alert_saying_fields_incomplete() {
        /*try{
            assertEquals("Fields incomplete", driver1.switchTo().alert().getText());
        }catch(NoAlertPresentException e){
            System.out.println("Register negative failed");
        }*/

        assertEquals("Fields incomplete", driver1.switchTo().alert().getText());

    }
}
