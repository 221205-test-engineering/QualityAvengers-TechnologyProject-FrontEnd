package dev.sony.admin.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//THIS PAGE HAS BEEN INTERGRATED AND NEEDS TO BE DELETED.
//PLEASE USE THE NEW ONE AND THE WEB ELEMENTS IT REFERENCES

public class EditUserProfilePage {
    public WebDriver driver;
    public EditUserProfilePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//h1[text() = 'Edit User Profile']")
    public WebElement editUserPage;
    @FindBy(name = "username")
    public WebElement editUsername;
    @FindBy(name = "password")
    public WebElement editPassword;
    @FindBy(name = "height")
    public WebElement editHeight;
    @FindBy(name = "weight")
    public WebElement editWeight;
    @FindBy(name = "picture")
    public WebElement editPicture;
    @FindBy(name = "biometrics")
    public WebElement checkBox;
    @FindBy(xpath = "//button[text() = 'Submit']")
    public WebElement editSubmit;
    @FindBy(xpath = "//a[text() = 'Back']")
    public WebElement editToAdminPage;
}
