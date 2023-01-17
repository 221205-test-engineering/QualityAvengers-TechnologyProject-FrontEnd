package com.revature.admin.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminPage {
    public WebDriver driver;
    public AdminPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//h1[text() = 'Admin Page']")
    public WebElement adminPage;
    @FindBy(xpath  = "//a[contains(.,'Edit User Profile')]")
    public WebElement editUser;
    @FindBy(linkText = "Games")
    public WebElement games;
    @FindBy(xpath  = "//a[contains(.,'View Venues')]")
    public WebElement viewVenue;
    @FindBy(linkText = "View Seasons")
    public WebElement viewSeasons;
    @FindBy(linkText = "Add Season")
    public WebElement addSeason;
    @FindBy(linkText = "Manage User Roles")
    public WebElement manageRoles;
    @FindBy(linkText = "Schedule Game")
    public WebElement scheduleGame;
    @FindBy(xpath = "//button[text() = ''Logout]")
    public WebElement logout;

}
