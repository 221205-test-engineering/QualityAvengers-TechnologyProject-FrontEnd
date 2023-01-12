package dev.sony.admin.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//THIS PAGE HAS BEEN INTERGRATED AND NEEDS TO BE DELETED.
//PLEASE USE THE NEW ONE AND THE WEB ELEMENTS IT REFERENCES

public class AdminPage {
    public WebDriver driver;
    public AdminPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//h1[text() = 'Admin Page']")
    public WebElement adminPage;
    @FindBy(xpath = "//a[text() = 'Edit User Profile']")
    public WebElement editUser;
    @FindBy(xpath = "//a[text() = 'Games']")
    public WebElement games;
    @FindBy(xpath = "//a[text() = 'View Venues']")
    public WebElement viewVenue;
    @FindBy(xpath = "//a[text() = 'View Seasons']")
    public WebElement viewSeasons;
    @FindBy(xpath = "//a[text() = 'Add Season']")
    public WebElement addSeason;
    @FindBy(xpath = "//a[text() = 'Manage User Roles']")
    public WebElement manageRoles;
    @FindBy(xpath = "//a[text() = 'Schedule Game']")
    public WebElement scheduleGame;
    @FindBy(xpath = "//button[text() = ''Logout]")
    public WebElement logout;

}
