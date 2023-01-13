package dev.sony.admin.steps;

import dev.sony.admin.pages.AdminPage;
import dev.sony.admin.pages.AdminScheduleGamesPage;
import dev.sony.admin.runner.AdminRunner;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

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
        new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NullPointerException.class)
                .until(ExpectedConditions
                        .visibilityOfAllElements(scheduleGames.venueList));
        scheduleGames.venueList.get(0);
    }
    @When("Admin inputs a date to the date box")
    public void admin_inputs_a_date_to_the_input_box(){
        scheduleGames.time.sendKeys("01122023");
        scheduleGames.time.sendKeys(Keys.TAB);
        scheduleGames.time.sendKeys("0335");
    }
    @When("Admin select one of the season from the options")
    public void admin_clicks_list_of_season(){
        new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NullPointerException.class)
                .until(ExpectedConditions
                        .visibilityOfAllElements(scheduleGames.seasonOptions));
        scheduleGames.seasonOptions.get(0);
    }
    @When("Admin select one of the sports from the options")
    public void admin_select_one_of_the_sports_from_the_options(){
        new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NullPointerException.class)
                .until(ExpectedConditions
                        .visibilityOfAllElements(scheduleGames.sportList));
        scheduleGames.sportList.get(0);
    }
    @When("Admin select one from the list of home teams")
    public void admin_select_one_from_the_list_of_home_teams(){
        new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NullPointerException.class)
                .until(ExpectedConditions
                .visibilityOfAllElements(scheduleGames.homeTeamList));
        scheduleGames.homeTeamList.get(0);
    }
    @When("Admin select one from the list of away team")
    public void admin_select_one_from_the_list_of_away_team(){
        new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NullPointerException.class)
                .until(ExpectedConditions
                .visibilityOfAllElements(scheduleGames.awayTeamList));
        scheduleGames.awayTeamList.get(0);
    }
    @When("Admin clicks schedule button")
    public void admin_clicks_schedule_button(){
        scheduleGames.schedule.click();
    }
//    @Then("A message appears showing game scheduled")
//    public void a_message_appears_showing_game_scheduled(){
//        assertTrue(driver.switchTo().alert().getText().contains("Game Scheduled"));
//    }
    @When("Admin clicks back button from game schedule page")
    public void admin_clicks_back_button_from_game_schedule_page(){
        scheduleGames.scheduleToAdminPage.click();
    }


}