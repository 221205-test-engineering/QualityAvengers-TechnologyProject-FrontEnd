package com.revature.admin.steps;

import com.revature.admin.pages.AdminPage;
import com.revature.admin.runner.AdminRunner;
import com.revature.admin.pages.AdminScheduleGamesPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AdminScheduleGamesStepImpn {
    public WebDriver driver = AdminRunner.driver;
    public AdminPage admin = AdminRunner.admin;
    AdminScheduleGamesPage scheduleGames = AdminRunner.scheduleGames;
    @When("Admin clicks schedule game button")
    public void admin_clicks_schedule_game_button(){

        admin.scheduleGame.click();
    }
    @Then("Admin is on the game schedule page")
    public void admin_is_on_the_game_schedule_page(){
        assertTrue(scheduleGames.schedule.getText().contains("Schedule"));
    }

    // Time and Location
    @When("Admin select one of the venues options")
    public void admin_select_one_of_the_venues_options(){
        new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions
                .visibilityOfAllElements(scheduleGames.venueList));
        scheduleGames.venueList.click();

    }
    @When("Admin inputs a date to the date box")
    public void admin_inputs_a_date_to_the_input_box(){
        scheduleGames.time.sendKeys("01122023");
        scheduleGames.time.sendKeys(Keys.TAB);
        scheduleGames.time.sendKeys("0335PM");

    }
    @When("Admin select one of the season from the options")
    public void admin_clicks_list_of_season() throws InterruptedException {
        Thread.sleep(2000);
        Select season = new Select(scheduleGames.seasonOptions);
        season.selectByIndex(0);
    }
    @When("Admin select one of the sports from the options")
    public void admin_select_one_of_the_sports_from_the_options() throws InterruptedException {
        Select sport = new Select(scheduleGames.sportList);
        sport.selectByIndex(1);
        scheduleGames.sportList.sendKeys(Keys.TAB);
        Thread.sleep(2000);
    }
    @When("Admin select one from the list of home teams")
    public void admin_select_one_from_the_list_of_home_teams(){
        try{
            new FluentWait<>(driver).withTimeout(Duration.ofSeconds(10))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class)
                    .until(ExpectedConditions.invisibilityOf(scheduleGames.homeTeamList));
            Select rows = new Select(scheduleGames.homeTeamList);
            rows.selectByIndex(1);
        }catch(Throwable e){
            System.out.println("Error found: "+e.getMessage());
        }
    }
    @When("Admin select one from the list of away team")
    public void admin_select_one_from_the_list_of_away_team(){
        try {
            Actions doubleClickAction = new Actions(driver);
            List<WebElement> list = scheduleGames.awayTeamList.findElements(By.tagName("option"));

            for (WebElement option : list) {
                if (option.getText().equals("The Splash")) {
                    option.click();
                    doubleClickAction.moveToElement(option).doubleClick().build().perform();
                    break;
                }
            }
        }catch(Throwable e){
            System.out.println("Error found: " + e.getMessage());
        }

    }
    @When("Admin clicks schedule button")
    public void admin_clicks_schedule_button(){
        scheduleGames.schedule.click();
    }

    @When("Admin clicks back button from game schedule page")
    public void admin_clicks_back_button_from_game_schedule_page(){
        scheduleGames.scheduleToAdminPage.click();
    }

}
