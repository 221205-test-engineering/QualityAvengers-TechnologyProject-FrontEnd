package com.revature.steps.ayiana;

import com.revature.pages.MainPage;
import com.revature.runners.MainRunner;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SeasonsImpl
{
    public static WebDriver driver = MainRunner.driver;
    MainPage mainPage = new MainPage(driver);

    @When("The user presses the Seasons button")
    public void the_user_presses_the_seasons_button()
    {
        try
        {
            new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/a[4]")));
            mainPage.seasonLink.click();
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

    @Then("The user will be able to see all the seasons")
    public void the_user_will_be_able_to_see_all_the_seasons()
    {
        WebElement seasonName = driver.findElement(By.xpath("/html/body/table/thead/tr/th[1]"));
        String seasonNameText = seasonName.getText();
        Assert.assertEquals("Season Name", seasonNameText);
    }
}
