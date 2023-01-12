package dev.sony.admin.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//THIS PAGE HAS BEEN INTERGRATED AND NEEDS TO BE DELETED.
//PLEASE USE THE NEW ONE AND THE WEB ELEMENTS IT REFERENCES

public class LoginPage {
    public WebDriver driver;
    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//a[text() = 'Login']")
    public WebElement login;
    @FindBy(name = "username")
    public WebElement username;
    @FindBy(name = "password")
    public WebElement password;
    @FindBy(xpath = "//button[text() = 'Login']")
    public WebElement mainLogin;
}
