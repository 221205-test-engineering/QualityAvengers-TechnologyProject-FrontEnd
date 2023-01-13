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

import static org.junit.Assert.assertTrue;

public class refereeSI {

    public WebDriver driver = IntramuralRunner.driver;
    public IndexPage indexPage = IntramuralRunner.indexPage;
    public LoginPage loginPage = IntramuralRunner.loginPage;
    public MainPage mainPage = IntramuralRunner.mainPage;
    public OfficiatingChoicePage officiatingChoicePage = IntramuralRunner.officiatingChoicePage;
    public OfficiateGamePage officiateGamePage = IntramuralRunner.officiateGamePage;


    @Given("the referee is logged in to the system")
    public void the_referee_is_logged_in_to_the_system() {
        // Write code here that turns the phrase above into concrete actions
        driver.get("http://127.0.0.1:5500/index.html");
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(indexPage.loginButton));
        indexPage.loginButton.click();
        loginPage.usernameField.sendKeys("cindy101");
        loginPage.passwordField.sendKeys("pass123");
        loginPage.loginButton.click();
    }

    @When("the referee click on the edit officiating choice button")
    public void the_referee_click_on_the_edit_officiating_choice_button() {
        // Write code here that turns the phrase above into concrete actions
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOf(mainPage.editOfficiateLink));
        mainPage.editOfficiateLink.click();
    }

    @Then("the referee should be on the officiating choice page")
    public void the_referee_should_be_on_the_officiating_choice_page() {
        // Write code here that turns the phrase above into concrete actions
        assertTrue(driver.getTitle().equals("Officiating Choice"));
    }

    @When("the referee input the id of the game he wants to officiate")
    public void the_referee_input_the_id_of_the_game_he_wants_to_officiate() {
        // Write code here that turns the phrase above into concrete actions
        officiatingChoicePage.registerGameField.sendKeys("9");
    }

    @When("click the submit button")
    public void click_the_submit_button() {
        // Write code here that turns the phrase above into concrete actions
        officiatingChoicePage.registerGameButton.click();
    }

    @When("the referee clicks on the officiate games button")
    public void the_referee_clicks_on_the_officiate_games_button() {
        // Write code here that turns the phrase above into concrete actions
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOf(mainPage.officiateGamesLink));
        mainPage.officiateGamesLink.click();
    }

    @Then("the referee should see a list of games they've chosen to officiate")
    public void the_referee_should_see_a_list_of_games_they_ve_chosen_to_officiate() {
        // Write code here that turns the phrase above into concrete actions
        WebElement teamTable = driver.findElement(By.id("gameTableBody"));
        List<WebElement> rows = teamTable.findElements(By.xpath(".//tr"));

        assertTrue(rows.size()>0);
    }

    @When("the referee clicks on the update scores button")
    public void the_referee_clicks_on_the_update_scores_button() {
        // Write code here that turns the phrase above into concrete actions
        officiateGamePage.updateScoreButton.click();
    }

    @Then("a modal should appear with a scorecard")
    public void a_modal_should_appear_with_a_scorecard() {
        // Write code here that turns the phrase above into concrete actions
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOf(officiateGamePage.scoreCard));
        assertTrue(officiateGamePage.scoreCard.isDisplayed());
    }

    @When("makes changes to the scorecard")
    public void makes_changes_to_the_scorecard() {
        // Write code here that turns the phrase above into concrete actions
        officiateGamePage.add1PtsHome.click();
    }

    @When("clicks the save button")
    public void clicks_the_save_button() {
        // Write code here that turns the phrase above into concrete actions
        officiateGamePage.saveButton.click();
    }

    @Then("an alert says the score has been updated successfully")
    public void an_alert_says_the_score_has_been_updated_successfully() {
        // Write code here that turns the phrase above into concrete actions
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
    }

    @Then("the scorecard for the game should be updated with the referee's changes")
    public void the_scorecard_for_the_game_should_be_updated_with_the_referee_s_changes() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

}