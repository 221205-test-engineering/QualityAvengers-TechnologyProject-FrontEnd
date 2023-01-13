package com.revature.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OfficiateGamePage {

    public WebDriver driver;
    public OfficiateGamePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//*[@id=\"gameTableBody\"]/tr/td[8]/button")
    public WebElement updateScoreButton;

    @FindBy(xpath = "//*[@id=\"playerLists\"]")
    public WebElement scoreCard;
}
