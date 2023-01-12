package com.revature.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OfficiatingChoicePage
{
    public WebDriver driver;
    public OfficiatingChoicePage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(name = "registerGameId")
    public WebElement registerGameField;

    @FindBy(xpath = "/html/body/form[1]/button")
    public WebElement registerGameButton;

    @FindBy(name = "removeGameId")
    public WebElement removeGameField;

    @FindBy(xpath = "/html/body/form[2]/button")
    public WebElement removeGameButton;
}
