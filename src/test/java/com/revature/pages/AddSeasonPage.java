package com.revature.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddSeasonPage
{
    public WebDriver driver;
    public AddSeasonPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(name = "season")
    public WebElement seasonNameField;

    @FindBy(xpath = "/html/body/form/button")
    public WebElement submitButton;
}
