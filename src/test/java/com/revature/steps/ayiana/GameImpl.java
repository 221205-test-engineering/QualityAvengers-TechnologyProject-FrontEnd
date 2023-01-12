//package com.revature.steps.ayiana;
//
//import com.revature.pages.IndexPage;
//import com.revature.pages.LoginPage;
//import com.revature.pages.MainPage;
//import com.revature.runners.MainRunner;
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//import org.junit.Assert;
//import org.openqa.selenium.By;
//import org.openqa.selenium.TimeoutException;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//import java.time.Duration;
//
//public class GameImpl
//{
//    public static WebDriver driver = MainRunner.driver;
//    IndexPage indexPage = new IndexPage(driver);
//    LoginPage logIn = new LoginPage(driver);
//    MainPage mainPage = new MainPage(driver);
//
//    @Given("The user is logged in")
//    public void the_user_is_logged_in()
//    {
//        driver.get("http://127.0.0.1:5500/index.html");
//        indexPage.loginButton.click();
//        logIn.usernameField.sendKeys("Bobby202");
//        logIn.passwordField.sendKeys("pass123");
//        logIn.loginButton.click();
//    }
//
//    @When("The user presses the Games button")
//    public void the_user_presses_the_games_button()
//    {
//        try
//        {
//            new WebDriverWait(driver, Duration.ofSeconds(10))
//                    .until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/a[2]")));
//            mainPage.gameLink.click();
//        }
//        catch (TimeoutException t)
//        {
//            /*In the case of an unregistered user, they will
//              not be able to get pass the login/register page
//              so instead of the test failing due to an exception
//              it will fail because of a false condition
//            */
//            Assert.assertTrue(false);
//        }
//    }
//
//    @Then("The user will be able to see all the games")
//    public void the_user_will_be_able_to_see_all_the_games()
//    {
//        WebElement gameID = driver.findElement(By.xpath("/html/body/table/thead/tr/th[1]"));
//        String gameIDText = gameID.getText();
//        Assert.assertEquals("Game ID", gameIDText);
//    }
//}
