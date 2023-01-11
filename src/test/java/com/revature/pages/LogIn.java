package com.revature.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogIn
{
    public WebDriver driver;
    public LogIn(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "/html/body/a[1]")
    public WebElement logInLink;

    @FindBy(xpath = "/html/body/form/input[1]")
    public WebElement usernameInput;

    @FindBy(xpath = "/html/body/form/input[2]")
    public WebElement passwordInput;

    @FindBy(xpath = "/html/body/form/button")
    public WebElement logInButton;
}
