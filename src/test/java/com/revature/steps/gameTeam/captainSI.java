package com.revature.steps.gameTeam;

import com.revature.pages.*;
import com.revature.runners.IntramuralRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class captainSI {

    public WebDriver driver = IntramuralRunner.driver;
    public IndexPage indexPage = IntramuralRunner.indexPage;
    public LoginPage loginPage = IntramuralRunner.loginPage;
    public MainPage mainPage = IntramuralRunner.mainPage;
    public TeamRequestPage teamRequestPage = IntramuralRunner.teamRequestPage;

    @Given("the captain is logged in to the system")
    public void the_captain_is_logged_in_to_the_system() {
        // Write code here that turns the phrase above into concrete actions
        driver.get("http://127.0.0.1:5500/index.html");
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(indexPage.loginButton));
        indexPage.loginButton.click();
        loginPage.usernameField.sendKeys("Jessika202");
        loginPage.passwordField.sendKeys("pass123");
        loginPage.loginButton.click();

    }
    @When("the captain navigates to the approve or deny team request page")
    public void the_captain_navigates_to_the_approve_or_deny_team_request_page() {
        // Write code here that turns the phrase above into concrete actions
        new WebDriverWait(driver, Duration.ofSeconds(9))
                .until(ExpectedConditions.elementToBeClickable(mainPage.teamRequestLink));
        mainPage.teamRequestLink.click();
    }

//    @Then("a list of all players requesting to join the team should be displayed with their status reading pending")
//    public void a_list_of_all_players_requesting_to_join_the_team_should_be_displayed_with_their_status_reading_pending() {
//        // Write code here that turns the phrase above into concrete actions
//        new WebDriverWait(driver, Duration.ofSeconds(5))
//                .until(ExpectedConditions.visibilityOf(teamRequestPage.requestList));
//        teamRequestPage.requestList.isDisplayed();
//        assertTrue(teamRequestPage.requestList.isDisplayed());
//                //.getText().equals("pending")); // need to add a pending compare when new request
//    }

    @Then("a list of all players requesting to join the team should be displayed")
    public void a_list_of_all_players_requesting_to_join_the_team_should_be_displayed() {
        // Write code here that turns the phrase above into concrete actions
        new WebDriverWait(driver, Duration.ofSeconds(9))
                .until(ExpectedConditions.visibilityOf(teamRequestPage.requestList));
        teamRequestPage.requestList.isDisplayed();
        assertTrue(teamRequestPage.requestList.isDisplayed());
    }

    @When("the captain clicks on see the player")
    public void the_captain_clicks_on_see_the_player() {
        // Write code here that turns the phrase above into concrete actions
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(teamRequestPage.seePlayerButton));
        teamRequestPage.seePlayerButton.click();
    }

    @Then("the details of the selected player should be displayed")
    public void the_details_of_the_selected_player_should_be_displayed() {
        // Write code here that turns the phrase above into concrete actions
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOf(teamRequestPage.playerInfoSection));
        assertTrue(teamRequestPage.playerInfoSection.isDisplayed());
        // need to match player id to requester id field
    }

    @When("the captain clicks on the approve button next to a player's name")
    public void the_captain_clicks_on_the_approve_button_next_to_a_player_s_name() {

        // Get a reference to the table
        WebElement table = driver.findElement(By.xpath("//table"));

        // Get all of the td elements in the table
        List<WebElement> tdElements = table.findElements(By.tagName("td"));

        // Iterate through the td elements
        for (WebElement td : tdElements) {
            // check if the status is pending
            if(td.getText().equals("pending")){
                System.out.println(td.getText());
                List<WebElement> approveButton = td.findElements(By.xpath("./following-sibling::td/button"));
                if(approveButton.size() > 0) {
                    approveButton.get(0).click();
                } else {
                    System.out.println("The approve button is not present");
                }
            }
        }
    }

    @Then("an alert says the approval has been successful")
    public void an_alert_says_the_approval_has_been_successful() {
        // Write code here that turns the phrase above into concrete actions
        String statusCondition = teamRequestPage.requestStatus.getText();
        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if(statusCondition.equals("pending")) {
            assertEquals("successful", driver.switchTo().alert().getText().contains("successful"));
        }
    }

    @When("the captain clicks OK")
    public void the_captain_clicks_ok() {
        // Write code here that turns the phrase above into concrete actions

        String statusCondition = teamRequestPage.requestStatus.getText();

        if(statusCondition.equals("pending")) {
            driver.switchTo().alert().accept();
        }
    }

    @Then("the request status changes to accepted")
    public void the_request_status_changes_to_accepted() {
        // Write code here that turns the phrase above into concrete actions
        assertEquals("accepted",teamRequestPage.requestStatus.getText());
    }

    @When("the captain clicks on the deny button next to a player's name")
    public void the_captain_clicks_on_the_deny_button_next_to_a_player_s_name() {
        // Write code here that turns the phrase above into concrete actions
        WebElement table = driver.findElement(By.xpath("//table"));

        // Get all of the td elements in the table
        List<WebElement> tdElements = table.findElements(By.tagName("td"));

        // Iterate through the td elements
        for (WebElement td : tdElements) {
            // check if the status is pending
            if(td.getText().equals("pending")){
                System.out.println(td.getText());
                List<WebElement> denyButton = td.findElements(By.xpath("./following-sibling::td[2]/button"));
                if(denyButton.size() > 0) {
                    denyButton.get(0).click();
                } else {
                    System.out.println("The approve button is not present");
                }
            }
        }
    }

    @Then("an alert says the deny has been successful")
    public void an_alert_says_the_deny_has_been_successful() {
        // Write code here that turns the phrase above into concrete actions
        String statusCondition = teamRequestPage.requestStatus.getText();

        if(statusCondition.equals("pending")) {
            assertEquals("successful", driver.switchTo().alert().getText().contains("successful"));
        }        // need to custom app and deny message
    }

    @Then("the request status changes to denied")
    public void the_request_status_changes_to_denied() {
        // Write code here that turns the phrase above into concrete actions
        assertEquals("denied",teamRequestPage.requestStatus.getText());
    }
}