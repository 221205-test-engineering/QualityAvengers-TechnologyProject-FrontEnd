package com.revature.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SchedulerPage
{
    public WebDriver driver;
    public SchedulerPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "venueOptions")
    public WebElement venueOptions;

    @FindBy(name = "time")
    public WebElement timeAndDate;

    @FindBy(name = "season")
    public WebElement chooseSeason;

    @FindBy(name = "sport")
    public WebElement chooseSport;

    @FindBy(name = "home")
    public WebElement homeTeam;

    @FindBy(name = "away")
    public WebElement awayTeam;

    @FindBy(xpath = "/html/body/form/button")
    public WebElement scheduleButton;
}
