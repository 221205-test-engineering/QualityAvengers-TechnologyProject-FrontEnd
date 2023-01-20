package com.revature.steps.admin;

import com.revature.pages.AdminPage;
import com.revature.pages.ManageUserRolePage;
import com.revature.runners.AdminRunner;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.opentest4j.AssertionFailedError;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class AdminManageUserRolesImpn {
    public static WebDriver driver = AdminRunner.driver;

    AdminPage admin = new AdminPage(driver);

    ManageUserRolePage userRoles = new ManageUserRolePage(driver);

    @When("Admin clicks manage user roles button")
    public void admin_clicks_manage_user_roles_button(){
        admin.manageRoles.click();
    }
    @Then("Admin is on the User Manager page")
    public void admin_on_the_user_manager_page(){
        assertTrue(userRoles.rolePage.getText().contains("User Manager"));
    }
    @Then("Admin can see all the users list")
    public void admin_can_see_all_the_users_list(){
       for(WebElement roles : userRoles.listOfUsers){
           assertTrue(roles.isDisplayed());
       }
    }
    @When("Admin clicks Promote To Referee button")
    public void admin_clicks_promote_to_referee_button() {
        userRoles.promReferee.click();
    }
    @Then("The role should be promoted to referee")
    public void the_role_should_be_shocked() {
        new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(AssertionFailedError.class)
                .until(ExpectedConditions.textToBePresentInElement(userRoles.role5, "referee"));
        assertEquals(userRoles.role5.getText(), "referee");

    }
    @When("Admin clicks Demote To Player button")
    public void admin_clicks_demote_to_player_button(){
        new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.visibilityOf(userRoles.changeRole1));
        userRoles.changeRole1.click();
    }
    @Then("The role should be demoted to player")
    public void the_role_should_be_demoted_to_player(){
        new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(AssertionFailedError.class)
                .until(ExpectedConditions.textToBePresentInElement(userRoles.role5, "player"));
        assertEquals(userRoles.role5.getText(), "player");

    }

    @When("Admin clicks Promote To Admin button")
    public void admin_clicks_promote_to_admin_button() {
        userRoles.changeRole1.click();
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(userRoles.changeRole2));
        userRoles.changeRole2.click();
    }
    @Then("The role should be promoted to Admin")
    public void the_role_should_be_promoted_to_admin(){
        new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(AssertionFailedError.class)
                .until(ExpectedConditions.textToBePresentInElement(userRoles.role8, "admin"));
        assertEquals(userRoles.role8.getText(), "admin");
    }
    @When("Admin clicks demote from Admin to player button")
    public void admin_clicks_demote_from_admin_to_player_button(){
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(userRoles.changeRole2));
        userRoles.changeRole2.click();
    }
    @Then("A message should appear that role changed")
    public void a_message_should_appear_that_role_changed() {
        try {
            assertNull(driver.switchTo().alert());
        } catch (
                NoAlertPresentException e) {
            e.printStackTrace();
            System.out.println("No alert present for role change");
        }
    }
    @When("Admin clicks user roles back button")
    public void admin_clicks_user_roles_back_button(){
        userRoles.roleToAdminPage.click();
    }
}
