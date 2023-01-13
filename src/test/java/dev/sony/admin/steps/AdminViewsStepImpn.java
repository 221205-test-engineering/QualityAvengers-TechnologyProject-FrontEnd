package dev.sony.admin.steps;

import dev.sony.admin.pages.*;
import dev.sony.admin.runner.AdminRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AdminViewsStepImpn {
    public static WebDriver driver = AdminRunner.driver;

    LoginPage login = AdminRunner.login;

    AdminPage admin = AdminRunner.admin;
    AdminViewsGamePage viewGames = AdminRunner.viewGames;
    AdminViewsSeasonPage seasons = AdminRunner.seasons;
    AdminViewsVenuePage venues = AdminRunner.venues;
    @Given("User logged in as Admin")
    public void user_logged_in_as_admin() throws InterruptedException {
        driver.get("http://127.0.0.1:5500/index.html");
        driver.findElement(By.xpath("//a[text() = 'Login']")).click();
        login.username.sendKeys("Mohan");
        login.password.sendKeys("Welcome2023");
        login.mainLogin.click();
        Thread.sleep(2000);
    }
    @When("Admin clicks view games button")
    public void admin_clicks_view_games_button(){
        admin.games.click();
    }
    @Then("Admin is on the view games page")
    public void admin_is_on_the_view_games_page(){

        assertTrue(viewGames.gameHeaderList.toString().length()>0);
    }
    @Then("Admin should see all the games scheduled")
    public void admin_should_see_all_the_games_scheduled(){
        List<String> viewgame = new ArrayList<>();
        for(WebElement games:viewGames.gamesList){
            viewgame.add(games.getText());
        }
        for(String gm : viewgame){
            System.out.println(gm);
        }
    }
    @When("Admin clicks show referees button")
    public void admin_clicks_show_referees_button(){
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions
                        .visibilityOf(viewGames.referees));
        viewGames.referees.click();
    }
    @Then("Shows referees details")
    public void shows_referees_details(){

        List<String> referee = new ArrayList<>();
        for(WebElement details: viewGames.refereeDetails){
            referee.add(details.getText());
        }
        for(String rfs : referee){
            System.out.println(rfs);
        }
    }
    @When("Admin clicks close button")
    public void admin_clicks_close_button(){
        viewGames.refereeDisappears.click();
    }
    @Then("Referee details should close")
    public void referee_details_should_close(){
        assertTrue(viewGames.refereeDetails.isEmpty());
    }
    @When("Admin clicks back button")
    public void admin_clicks_back_button(){
        viewGames.gameToAdminPage.click();
    }
    @Then("Admin is on the Admin page")
    public void admin_is_on_admin_page() throws InterruptedException {
        Thread.sleep(2000);
        assertEquals(admin.adminPage.getText(),"Admin Page");
    }

    // View Seasons

    @When("Admin clicks view seasons button")
    public void admin_clicks_view_seasons_button() {
        admin.viewSeasons.click();

    }
    @Then("Admin is on the view season page")
    public void admin_is_on_the_view_season_page() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(seasons.seasonName));
       assertTrue(seasons.seasonName.getText().contains("Season Name"));
    }
    @Then("Admin should see all the seasons")
    public void admin_should_see_all_the_seasons() {
       List<String> seasonData = new ArrayList<>();
       for(WebElement seas : seasons.seasonList){
           seasonData.add(seas.getText());
       }
       for(String listOfData : seasonData){
           System.out.println(listOfData);
       }
    }
    @When("Admin clicks seasons back button")
    public void admin_clicks_seasons_back_button(){
        seasons.seasonToAdminPage.click();
    }


    // View Venues


    @When("Admin clicks view venues button")
    public void admin_clicks_view_venues_button() {
        admin.viewVenue.click();
    }
    @Then("Admin is on the view venue page")
    public void admin_is_on_the_view_venue_page() {
        assertTrue(venues.venueName.getText().contains("Venue Name"));
    }
    @Then("Admin should see all the venues")
    public void admin_should_see_all_the_venues() {
        List<String> venue = new ArrayList<>();
        for(WebElement ven : venues.venueList){
            venue.add(ven.getText());
        }
        for(String venues : venue){
            System.out.println(venues);
        }
    }

    @When("Admin clicks venues back button")
    public void admin_clicks_venues_back_button(){
        venues.venueToAdminPage.click();
    }

}
