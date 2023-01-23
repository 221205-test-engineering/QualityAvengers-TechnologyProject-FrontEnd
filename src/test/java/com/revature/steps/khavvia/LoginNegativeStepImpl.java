package com.revature.steps.khavvia;

import com.revature.pages.IndexPage;
import com.revature.pages.LoginPage;
import com.revature.pages.MainPage;
import com.revature.runners.LoginUpdateRegisterRunner;
import io.cucumber.java.en.Then;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;

public class LoginNegativeStepImpl {
    public WebDriver driver1 = LoginUpdateRegisterRunner.driver1;
    public IndexPage indexPage1 = LoginUpdateRegisterRunner.indexPage1;
    public LoginPage loginPage1 = LoginUpdateRegisterRunner.loginPage1;
    public MainPage mainPage1 = LoginUpdateRegisterRunner.mainPage1;

    @Then("the employee should see an alert saying user does not exist")
    public void the_employee_should_see_an_alert_saying_user_does_not_exist() {
        assertEquals("Login", driver1.getTitle());

    }
}
