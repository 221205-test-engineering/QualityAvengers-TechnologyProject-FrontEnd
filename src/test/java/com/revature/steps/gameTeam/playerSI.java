package com.revature.steps.gameTeam;

import com.revature.pages.IndexPage;
import com.revature.pages.LoginPage;
import com.revature.pages.MainPage;
import com.revature.pages.TeamApplicationPage;
import com.revature.runners.IntramuralRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.junit.Assert.*;

public class playerSI {

    public WebDriver driver = IntramuralRunner.driver;
    public IndexPage indexPage = IntramuralRunner.indexPage;
    public LoginPage loginPage = IntramuralRunner.loginPage;
    public MainPage mainPage = IntramuralRunner.mainPage;
    public TeamApplicationPage teamApplicationPage = IntramuralRunner.teamApplicationPage;


    @Given("the player is logged in to the system")
    public void the_player_is_logged_in_to_the_system() {
        // Write code here that turns the phrase above into concrete actions
        driver.get("http://127.0.0.1:5500/index.html");
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(indexPage.loginButton));
        indexPage.loginButton.click();
        loginPage.usernameField.sendKeys("wpaumierh");
        loginPage.passwordField.sendKeys("a9myRNBCGR");
        loginPage.loginButton.click();
    }

    @Given("the player is on the team application page")
    public void the_player_is_on_the_team_application_page() {
        // Write code here that turns the phrase above into concrete actions
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOf(mainPage.teamApplicationLink));
        mainPage.teamApplicationLink.click();
    }

    @Given("the player is not in a team")
    public void the_player_is_not_in_a_team() {
        // Write code here that turns the phrase above into concrete actions
        new WebDriverWait(driver,Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOf(teamApplicationPage.applicationStatus));
        String notInTeam = teamApplicationPage.applicationStatus.getText();
        assertEquals("not applied", notInTeam);
    }

    @Then("the player is on the player page")
    public void the_player_is_on_the_player_page() {
        // Write code here that turns the phrase above into concrete actions

        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOf(mainPage.role));
        assertTrue(mainPage.role.isDisplayed());
    }

    @When("the player clicks on the team application button")
    public void the_player_clicks_on_the_team_application_button() {
        // Write code here that turns the phrase above into concrete actions
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOf(mainPage.teamApplicationLink));
        mainPage.teamApplicationLink.click();
    }

    @Then("a list of teams should be displayed")
    public void a_list_of_teams_should_be_displayed() {
        // Write code here that turns the phrase above into concrete actions
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOf(teamApplicationPage.teamList));

        WebElement teamTable = teamApplicationPage.teamList;
        List<WebElement> rows = teamTable.findElements(By.xpath(".//tr"));

        assertTrue(rows.size()>0);
    }

    @When("the player clicks on see the captain")
    public void the_player_clicks_on_see_the_captain() {
        // Write code here that turns the phrase above into concrete actions
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOf(teamApplicationPage.seeCaptainButton));
        teamApplicationPage.seeCaptainButton.click();
    }

    @Then("the team's captain information should be displayed in a section")
    public void the_team_s_captain_information_should_be_displayed_in_a_section() {
        // Write code here that turns the phrase above into concrete actions
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(teamApplicationPage.cptInfoSection));
        assertTrue(teamApplicationPage.cptInfoSection.isDisplayed());
    }

    @When("the player clicks on the close button")
    public void the_player_clicks_on_the_close_button() {
        // Write code here that turns the phrase above into concrete actions
        teamApplicationPage.closeCptSession.click();
    }

    @Then("the section disappear")
    public void the_section_disappear() {
        // Write code here that turns the phrase above into concrete actions

        try{
            teamApplicationPage.cptInfoSection.isDisplayed();
            fail();
        } catch(NoSuchElementException e){ assertTrue(true);}
    }


    @Then("a list of teams should be displayed with their name sport team status and application status stating not applied")
    public void a_list_of_teams_should_be_displayed_with_their_name_sport_team_status_and_application_status_stating_not_applied() {
        // Write code here that turns the phrase above into concrete actions
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOf(teamApplicationPage.teamList));

        WebElement teamTable = teamApplicationPage.teamList;
        List<WebElement> rows = teamTable.findElements(By.xpath(".//tr"));

        assertTrue(rows.size()>0);

        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOf(teamApplicationPage.applicationStatus));

        assertEquals("not applied", teamApplicationPage.applicationStatus.getText());

    }

    @When("the player select a team from the dropdown menu")
    public void the_player_select_a_team_from_the_dropdown_menu() {
        // Write code here that turns the phrase above into concrete actions
//        new WebDriverWait(driver, Duration.ofSeconds(10))
//                .until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("/html/body/div"))));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        try {
            if (!teamApplicationPage.alreadyInTeam.isDisplayed()) {
                Select select = new Select(teamApplicationPage.selectTeam);
                select.selectByIndex(0);
            }
        } catch (NoSuchElementException e) {
            System.out.println("Element not found");
        }


//        if(teamApplicationPage.applicationStatus.getText().equals("not applied")){
//
//        } else {System.out.println(teamApplicationPage.alreadyInTeam.getText());}

    }

    @When("clicks apply")
    public void clicks_apply() {
        // Write code here that turns the phrase above into concrete actions
        try {
            teamApplicationPage.applyButton.click();
        } catch (NoSuchElementException e){
            System.out.println("Element not found");
            e.printStackTrace();
        }

    }

    @Then("an alert says the application has been successful")
    public void an_alert_says_the_application_has_been_successful() {
        // Write code here that turns the phrase above into concrete actions

        try {
            new WebDriverWait(driver, Duration.ofSeconds(5))
                    .until(ExpectedConditions.alertIsPresent());
            assertTrue(driver.switchTo().alert().getText().contains("Successful"));
            driver.switchTo().alert().accept();
        } catch (NoAlertPresentException e){e.printStackTrace();}
    }

    @Then("the application status changes to pending")
    public void the_application_status_changes_to_pending() {
        // Write code here that turns the phrase above into concrete actions
        assertTrue(teamApplicationPage.applicationStatus.getText().equals("pending"));
    }
}
