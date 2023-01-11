package dev.mallory.steps;

import dev.mallory.pages.GamePage;
import dev.mallory.pages.LogIn;
import dev.mallory.pages.MainPage;
import dev.mallory.runners.MainRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GameImpl
{
    public static WebDriver driver = MainRunner.driver;
    LogIn logIn = new LogIn(driver);
    MainPage mainPage = new MainPage(driver);
    GamePage gamePage = new GamePage(driver);

    @Given("The user is logged in")
    public void the_user_is_logged_in()
    {
        driver.get("http://127.0.0.1:5500/index.html");
        logIn.logInLink.click();
        logIn.usernameInput.sendKeys("Bobby202");
        logIn.passwordInput.sendKeys("pass123");
        logIn.logInButton.click();
    }

    @When("The user presses the Games button")
    public void the_user_presses_the_games_button()
    {
        try
        {
            new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/a[2]")));
            mainPage.gameLink.click();
        }
        catch (TimeoutException t)
        {
            /*In the case of an unregistered user, they will
              not be able to get pass the login/register page
              so instead of the test failing due to an exception
              it will fail because of a false condition
            */
            Assert.assertTrue(false);
        }
    }

    @Then("The user will be able to see all the games")
    public void the_user_will_be_able_to_see_all_the_games()
    {
        String gameIDText = gamePage.gameID.getText();
        Assert.assertEquals("Game ID", gameIDText);
    }
}
