package com.revature.admin.steps;

import com.revature.admin.pages.AdminPage;
import com.revature.admin.pages.EditUserProfilePage;
import com.revature.admin.runner.AdminRunner;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import static org.junit.jupiter.api.Assertions.*;

public class AdminEditUserProfileImpn {
    public static WebDriver driver = AdminRunner.driver;
    AdminPage admin = new AdminPage(driver);
    EditUserProfilePage editProfile = new EditUserProfilePage(driver);

    @When("Admin clicks edit user profile")
    public void admin_clicks_edit_user_profile(){
        admin.editUser.click();
    }
    @Then("Admin is on the edit user profile page")
    public void admin_is_on_the_edit_user_profile_page(){
        assertTrue(editProfile.editUserPage.getText().contains("Edit User Profile"));
    }
    @When("Admin change password")
    public void admin_change_password() {
        editProfile.editPassword.clear();
        editProfile.editPassword.sendKeys("Welcome2023");
    }
    @When("Admin change his own height in inches")
    public void admin_change_his_own_height_inches() {
        editProfile.editHeight.clear();
        editProfile.editHeight.sendKeys("70");
    }
    @When("Admin change his own weight in lbs")
    public void admin_change_his_own_weight_lbs() {
        editProfile.editWeight.clear();
        editProfile.editWeight.sendKeys("200");
    }
    @When("Admin inputs url of his profile picture")
    public void admin_inputs_url_of_his_profile_picture(String docString) {
        editProfile.editPicture.clear();
        editProfile.editPicture.sendKeys(docString);
    }
    @When("Admin checks checkbox")
    public void admin_checks_checkbox() {
        editProfile.checkBox.click();
    }
    @When("Admin clicks edit profile submit button")
    public void admin_clicks_edit_profile_submit_button() {
        editProfile.editSubmit.click();
    }
    @Then("A message should appear for verification")
    public void a_message_should_appear_for_verification() {
        assertTrue(driver.switchTo().alert().getText().contains("Are you sure you want to edit your user profile?"));
    }
    @When("Admin verifies profile editing")
    public void admin_verifies_profile_editing() throws InterruptedException {
        driver.switchTo().alert().accept();
        Thread.sleep(3000);
    }
    @Then("An message should appear for the successful profile update")
    public void an_message_should_appear_for_the_successful_profile_update() {
        assertTrue(driver.switchTo().alert().getText().contains("Update successful!"));
        driver.switchTo().alert().accept();
    }

    @When("Admin clicks username input form")
    public void admin_clicks_username_input_form() {
        editProfile.editUsername.clear();
        editProfile.editUsername.sendKeys("Mohan");
    }
    @Then("A message should appear that username cannot be changed")
    public void a_message_should_appear_that_username_cannot_be_changed() {
        try {
            assertNull(driver.switchTo().alert());
        }catch(NoAlertPresentException e){
            e.printStackTrace();
            System.out.println("No alert present username cannot be changed");
        }
    }
    @When("Admin unchecked display biometrics checkbox")
    public void admin_unchecked_display_biometrics_checkbox() {
        editProfile.checkBox.click();
    }
    @When("Admin update his own height in inches")
    public void admin_update_his_own_height_in_inches(String docString){
        editProfile.editHeight.clear();
        editProfile.editHeight.sendKeys(docString);
    }
    @When("Admin update his own weight in lbs")
    public void admin_update_his_own_weight_in_lbs(String docString){
        editProfile.editWeight.clear();
        editProfile.editWeight.sendKeys(docString);
    }

    @When("Admin cancelled the profile edit")
    public void admin_cancelled_the_profile_edit(){
        driver.switchTo().alert().dismiss();
    }
    @Then("It should clear edited values")
    public void it_should_clear_edited_values(){
        assertEquals(editProfile.editHeight.getText(), "");
        assertEquals(editProfile.editWeight.getText(), "");
    }
}
