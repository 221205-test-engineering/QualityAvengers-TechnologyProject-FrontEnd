package com.revature.steps.gameTeam;

import com.revature.pages.AppDenyPage;
import com.revature.pages.CptHomePage;
import com.revature.pages.IndexPage;
import com.revature.pages.LoginPage;
import com.revature.runners.IntramuralRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class captainSI {

    public WebDriver driver = IntramuralRunner.driver;
    public IndexPage indexPage = IntramuralRunner.indexPage;
    public LoginPage loginPage = IntramuralRunner.loginPage;
    public CptHomePage cptHomePage = IntramuralRunner.cptHomePage;
    public AppDenyPage appDenyPage = IntramuralRunner.AppDenyPage;

    @Given("the captain is logged in to the system")
    public void the_captain_is_logged_in_to_the_system() {
        // Write code here that turns the phrase above into concrete actions
        driver.get("http://127.0.0.1:5500/index.html");
        indexPage.loginButton.click();
        loginPage.usernameField.sendKeys("Bobby202");
        loginPage.passwordField.sendKeys("pass123");
        loginPage.loginButton.click();

    }
    @When("the captain navigates to the approve or deny team request page")
    public void the_captain_navigates_to_the_approve_or_deny_team_request_page() {
        // Write code here that turns the phrase above into concrete actions
        cptHomePage.adRequest.click();
    }

    @Then("a list of all players requesting to join the team should be displayed with their status reading pending")
    public void a_list_of_all_players_requesting_to_join_the_team_should_be_displayed_with_their_status_reading_pending() {
        // Write code here that turns the phrase above into concrete actions
        appDenyPage.requestList.isDisplayed();
        assertTrue(appDenyPage.requestList.getText().equals("pending"));
    }

    @Then("a list of all players requesting to join the team should be displayed")
    public void a_list_of_all_players_requesting_to_join_the_team_should_be_displayed() {
        // Write code here that turns the phrase above into concrete actions
        appDenyPage.requestList.isDisplayed();
    }

    @When("the captain clicks on see the player")
    public void the_captain_clicks_on_see_the_player() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("the details of the selected player should be displayed")
    public void the_details_of_the_selected_player_should_be_displayed() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("the captain clicks on the approve button next to a player's name")
    public void the_captain_clicks_on_the_approve_button_next_to_a_player_s_name() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("an alert says the approval has been successful")
    public void an_alert_says_the_approval_has_been_successful() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("the captain clicks OK")
    public void the_captain_clicks_ok() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("the request status changes to accepted")
    public void the_request_status_changes_to_accepted() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("the captain clicks on the deny button next to a player's name")
    public void the_captain_clicks_on_the_deny_button_next_to_a_player_s_name() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("an alert says the deny has been successful")
    public void an_alert_says_the_deny_has_been_successful() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("the request status changes to denied")
    public void the_request_status_changes_to_denied() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
}
