package dev.sony.admin.steps;

import dev.sony.admin.pages.AdminPage;
import dev.sony.admin.pages.AdminScheduleGamesPage;
import dev.sony.admin.pages.LoginPage;
import dev.sony.admin.runner.AdminRunner;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AdminScheduleGamesStepImpn {
    public WebDriver driver = AdminRunner.driver;
    public AdminPage admin = AdminRunner.admin;
    public LoginPage login = AdminRunner.login;
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
    @When("Admin select one of the venues option")
    public void admin_select_one_of_the_venues_options(){
        Select select = new Select(WebElement scheduleGames.venueList);
        assertNotNull(select.getFirstSelectedOption());
    }
    @When("Admin clicks date button")
    public void admin_clicks_date_button(){
        
    }
}
