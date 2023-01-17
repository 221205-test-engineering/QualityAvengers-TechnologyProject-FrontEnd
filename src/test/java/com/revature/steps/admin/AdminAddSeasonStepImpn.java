package com.revature.admin.steps;

import com.revature.admin.runner.AdminRunner;
import com.revature.admin.pages.AddSeasonPage;
import com.revature.admin.pages.AdminPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AdminAddSeasonStepImpn {
    public WebDriver driver = AdminRunner.driver;

    public AdminPage admin = AdminRunner.admin;
    public AddSeasonPage addSeason = AdminRunner.addSeason;

    @When("Admin clicks add season button")
    public void admin_clicks_add_season_button(){
        admin.addSeason.click();
    }
    @Then("Admin is on the season scheduler page")
    public void admin_is_on_the_season_scheduler_page(){
        assertTrue(addSeason.titleAddSeasonPage.getText().contains("Season Scheduler"));
    }
    @Then("Admin should be able to see current seasons")
    public void admin_should_be_able_to_see_current_seasons(){
        for(WebElement season : addSeason.listOfSeasons){
            System.out.println(season.getText());
        }
    }
    @When("Admin inputs a new season")
    public void admin_inputs_a_season(String docString){
        addSeason.addNewSeason.sendKeys(docString);
    }
    @When("Admin clicks add season submit button")
    public void admin_clicks_add_season_submit_button(){
        addSeason.newSeasonSubmit.click();
    }
    @Then("New scheduled season should appear at the end of list of seasons")
    public void new_scheduled_season_appears_at_the_end() {

            System.out.println(addSeason.listOfSeasons.get(addSeason.listOfSeasons.size() - 1).getText());

    }
    @When("Admin clicks add season back button")
    public void admin_clicks_add_season_back_button(){
        addSeason.addSeasonToAdminPage.click();
    }
}
