package dev.sony.admin.steps;

import dev.sony.admin.pages.AdminPage;
import dev.sony.admin.pages.AdminViewsGamePage;
import dev.sony.admin.pages.LoginPage;
import dev.sony.admin.runner.AdminRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AdminViewsStepImpn {
    public static WebDriver driver = AdminRunner.driver;

    LoginPage login = new LoginPage(driver);

    AdminPage admin = new AdminPage(driver);
    AdminViewsGamePage viewGames = new AdminViewsGamePage(driver);
    @Given("User logged in as Admin")
    public void user_logged_in_as_admin(){
        driver.get("http://127.0.0.1:5500/index.html");
        login.login.click();
        login.username.sendKeys("Mohan");
        login.password.sendKeys("Welcom2023");
        login.mainLogin.click();
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
    public void admin_is_on_admin_page(){
        assertEquals(admin.adminPage.getText(),"Admin Page");
    }
}
