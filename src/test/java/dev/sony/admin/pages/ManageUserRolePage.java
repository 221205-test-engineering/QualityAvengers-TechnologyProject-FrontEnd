package dev.sony.admin.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ManageUserRolePage {
    public WebDriver driver;
    public ManageUserRolePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//h1[text() = 'User Manager']")
    public WebElement rolePage;
    @FindBy(id = "userTableBody")
    public List<WebElement> userList;
    @FindBy(xpath = "//button[text() = 'Demote To Player']")
    public WebElement domoteToPlayer;
    @FindBy(xpath = "//button[text() = 'Promote To Admin']")
    public WebElement promoteToAdmin;
    @FindBy(xpath = "//button[text() = 'Promote To Referee']")
    public WebElement promoteToReferee;
    @FindBy(xpath = "//a[text() = 'Back']")
    public WebElement roleToAdminPage;
}
