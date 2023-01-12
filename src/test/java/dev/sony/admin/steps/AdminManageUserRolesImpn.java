package dev.sony.admin.steps;

import dev.sony.admin.pages.AdminPage;
import dev.sony.admin.pages.LoginPage;
import dev.sony.admin.pages.ManageUserRolePage;
import dev.sony.admin.runner.AdminRunner;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AdminManageUserRolesImpn {
    public static WebDriver driver = AdminRunner.driver;

    LoginPage login = new LoginPage(driver);

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
    @When("Admin clicks Demote To Player button")
    public void admin_clicks_demote_to_player_button(){
        for(WebElement row : userRoles.listOfUsers){
            List<WebElement> Cells = row.findElements(By.tagName("td[4]"));
            for(WebElement cell : Cells) {
                if (cell.getText().equals("Demote To Player")) {
                    cell.click();
                    break;
                }
            }
        }
    }
    @Then("The role should be demoted to player")
    public void the_role_should_be_demoted_to_player(){


    }
    @When("Admin clicks Promote To Referee button")
    public void admin_clicks_promote_to_referee_button() {
    for(WebElement row : userRoles.listOfUsers){
        List<WebElement> Cells = row.findElements(By.tagName("td[4]"));
        for(WebElement cell : Cells) {
            if (cell.getText().equals("Promote To Referee")) {
                cell.click();
                break;
                }
            }
        }
    }
    @Then("The role should be promoted to referee")
    public void the_role_should_be_shocked(){

    }
    @When("Admin clicks Promote To Admin button")
    public void admin_clicks_promote_to_admin_button(){
        for(WebElement row : userRoles.listOfUsers){
            List<WebElement> Cells = row.findElements(By.tagName("td[4]"));
            for(WebElement cell : Cells) {
                if (cell.getText().equals("Promote To Admin")) {
                    cell.click();
                    break;
                }
            }
        }
    }
    @Then("The role should be promoted to Admin")
    public void the_role_should_be_promoted_to_admin(){

    }
    @When("Admin clicks Demote To Referee button")
    public void admin_clicks_demote_to_referee_button(){
        for(WebElement row : userRoles.listOfUsers){
            List<WebElement> Cells = row.findElements(By.tagName("td[4]"));
            for(WebElement cell : Cells) {
                if (cell.getText().equals("Demote To Referee")) {
                    cell.click();
                    break;
                }
            }
        }
    }
    @Then("The role should be demoted to referee")
    public void the_role_should_be_demoted_to_referee(){

    }
    @When("Admin clicks user roles back button")
    public void admin_clicks_user_roles_back_button(){
        userRoles.roleToAdminPage.click();
    }
}
