package com.revature.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class OfficiateGamePage
{
    public WebDriver driver;
    public OfficiateGamePage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//*[@id=\"gameTableBody\"]/tr/td[8]/button")
    public WebElement updateScoreButton;

    @FindBy(xpath = "//*[@id=\"playerLists\"]")
    public WebElement scoreCard;

    @FindBy(xpath = "//*[@id=\"homeTeam\"]/dl[1]/dd[1]/button[1]") // needs to be changed HC
    public WebElement add1PtsHome;

    @FindBy(xpath = "//*[@id=\"playerLists\"]/button[2]")
    public WebElement saveButton;
}
