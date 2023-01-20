package com.revature.steps.khavvia;

import com.revature.pages.AdminPage;
import com.revature.pages.IndexPage;
import com.revature.pages.LoginPage;
import com.revature.pages.MainPage;
import com.revature.runners.IntramuralRunner;
import com.revature.runners.LoginUpdateRegisterRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginPositiveStepImpl {

    public WebDriver driver1 = LoginUpdateRegisterRunner.driver1;
    public IndexPage indexPage1 = LoginUpdateRegisterRunner.indexPage1;
    public LoginPage loginPage1 = LoginUpdateRegisterRunner.loginPage1;
    public MainPage mainPage1 = LoginUpdateRegisterRunner.mainPage1;


    @Given("The employee is on the login page")
    public void the_employee_is_on_the_login_page() {
        driver1.get("http://127.0.0.1:5501/index.html");
        new WebDriverWait(driver1, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(indexPage1.loginButton));
        indexPage1.loginButton.click();
    }
    @When("The employee types {string} into username input")
    public void the_employee_types_into_username_input(String string) {
        loginPage1.usernameField.sendKeys(string);
    }
    @When("The employee types {string} into password input")
    public void the_employee_types_into_password_input(String string) {
        loginPage1.passwordField.sendKeys(string);
    }
    @When("The employee clicks on the login button")
    public void the_employee_clicks_on_the_login_button() throws  InterruptedException {
        loginPage1.loginButton.click();
        Thread.sleep(2000);
    }
    @Then("the employee should be on the {string} page")
    public void the_employee_should_be_on_the_page(String string) {
        assertEquals(string + " Page", mainPage1.role.getText());
    }
    @Then("The employee should see their name {string}")
    public void the_employee_should_see_their_name(String string) {
        String username = driver1.findElement(By.xpath("/html/body/div/p[1]")).getText();
        assertEquals("Welcome, " + string + "!", username);

    }

}
