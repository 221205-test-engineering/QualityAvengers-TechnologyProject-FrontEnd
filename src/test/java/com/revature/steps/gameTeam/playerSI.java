package com.revature.steps.gameTeam;

import com.revature.pages.IndexPage;
import com.revature.pages.LoginPage;
import com.revature.pages.MainPage;
import com.revature.pages.TeamApplicationPage;
import com.revature.runners.IntramuralRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Random;

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
        loginPage.usernameField.sendKeys("slafoy1");
        loginPage.passwordField.sendKeys("3hOS1nh");
        loginPage.loginButton.click();
    }

    @Given("the player is logged in to the system by using their {string} and {string}")
    public void the_player_is_logged_in_to_the_system_by_using_their_and(String username, String password) {
        // Write code here that turns the phrase above into concrete actions
        driver.get("http://127.0.0.1:5500/index.html");
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(indexPage.loginButton));
        indexPage.loginButton.click();
        loginPage.usernameField.sendKeys(username);
        loginPage.passwordField.sendKeys(password);
        loginPage.loginButton.click();
    }

    @Given("the player is on the team application page")
    public void the_player_is_on_the_team_application_page() {
        // Write code here that turns the phrase above into concrete actions
        new WebDriverWait(driver, Duration.ofSeconds(9))
                .until(ExpectedConditions.visibilityOf(mainPage.teamApplicationLink));
        mainPage.teamApplicationLink.click();
    }

    @Given("the player is not in a team")
    public void the_player_is_not_in_a_team() {
        // Write code here that turns the phrase above into concrete actions
        try
        {
            new WebDriverWait(driver, Duration.ofSeconds(9))
                    .until(ExpectedConditions.elementToBeClickable(teamApplicationPage.selectTeam));
            assertTrue(teamApplicationPage.selectTeam.isDisplayed());
        } catch (TimeoutException t){
            Assert.fail();}
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


    @When("the player select a team from the dropdown menu")
    public void the_player_select_a_team_from_the_dropdown_menu() {
        // Write code here that turns the phrase above into concrete actions

//        new WebDriverWait(driver, Duration.ofSeconds(10))
//                .until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//table"))));
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        try
        {
            new WebDriverWait(driver, Duration.ofSeconds(9))
                    .until(ExpectedConditions.elementToBeClickable(teamApplicationPage.selectTeam));
            Select select = new Select(teamApplicationPage.selectTeam);
            List<WebElement> teamOptions = select.getOptions();
                Random random = new Random();
                int randomTeam = random.nextInt(teamOptions.size());
                    select.selectByIndex(randomTeam);
        } catch (TimeoutException t){
            Assert.fail();}




        // Get a reference to the table
//        WebElement table = driver.findElement(By.xpath("//table"));
//
//        // Get all of the td elements in the table
//        List<WebElement> tdElements = table.findElements(By.tagName("td"));
//
//        // Iterate through the td elements
//        for (WebElement td : tdElements) {
//
//            if(td.getText().equals("pending"))
//            {
//                System.out.println("request is pending");
//            }
//            else if(td.getText().equals("accepted"))
//            {
//                System.out.println("in team already");
//            }
//            // check if the status is not applied
//              else{
//                  try{Select select = new Select(teamApplicationPage.selectTeam);
//                  List<WebElement> teamOptions = select.getOptions();
//                Random random = new Random();
//                int randomTeam = random.nextInt(teamOptions.size());
//                    select.selectByIndex(randomTeam);
//                  } catch (NoSuchElementException e){e.printStackTrace();}
//
//            }
//        }
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

//    @Then("the application status changes to pending")
//    public void the_application_status_changes_to_pending() {
//        // Write code here that turns the phrase above into concrete actions
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        assertTrue(teamApplicationPage.applicationStatus.getText().equals("pending"));
//    }
}

