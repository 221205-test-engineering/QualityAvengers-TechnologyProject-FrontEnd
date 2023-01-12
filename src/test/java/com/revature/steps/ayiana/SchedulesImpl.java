package com.revature.steps.ayiana;

import com.revature.runners.MainRunner;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SchedulesImpl
{
    public static WebDriver driver = MainRunner.driver;


    /*@When("The user presses the Games button")
    public void the_user_presses_the_games_button()
    {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }*/

    @Then("The user will be able to see all the games schedules")
    public void the_user_will_be_able_to_see_all_the_games_schedules()
    {
        WebElement date = driver.findElement(By.xpath("/html/body/table/thead/tr/th[2]"));
        String dateText = date.getText();
        Assert.assertEquals("Date", dateText);
    }
}
