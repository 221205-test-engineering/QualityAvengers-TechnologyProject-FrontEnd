package com.revature.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//THIS POM CAN ALSO BE USED FOR EDITING A USER PROFILE
public class RegisterPage
{
    public WebDriver driver;
    public RegisterPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(name = "username")
    public WebElement usernameField;

    @FindBy(name = "password")
    public WebElement passwordField;

    @FindBy(name = "height")
    public WebElement heightField;

    @FindBy(name = "weight")
    public WebElement weightField;

    @FindBy(name = "picture")
    public WebElement profilePictureField;

    @FindBy(name = "biometrics")
    public WebElement biometricsField;

    @FindBy(xpath = "/html/body/form/button")
    public WebElement submitButton;

    @FindBy(xpath = "/html/body/a")
    public WebElement backButton;
}
