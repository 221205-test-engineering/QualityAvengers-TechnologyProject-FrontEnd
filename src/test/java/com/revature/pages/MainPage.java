package com.revature.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage
{
    public WebDriver driver;
    public MainPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "/html/body/a[2]")
    public WebElement gameLink;

    @FindBy(xpath = "/html/body/a[4]")
    public WebElement seasonLink;

    @FindBy(xpath = "/html/body/a[3]")
    public WebElement venueLink;

    @FindBy(xpath = "/html/body/a[1]")
    public WebElement editProfileLink;

    @FindBy(xpath = "/html/body/a[5]")
    public WebElement teamRequestLink;

    @FindBy(xpath = "/html/body/a[6]")
    public WebElement viewTeamLink;

    @FindBy(xpath = "/html/body/a[5]")
    public WebElement editOfficiateLink;

    @FindBy(xpath = "/html/body/a[6]")
    public WebElement officiateGamesLink;

    @FindBy(xpath = "/html/body/a[5]")
    public WebElement addSeasonLink;

    @FindBy(xpath = "/html/body/a[6]")
    public WebElement manageUserRolesLink;

    @FindBy(xpath = "/html/body/a[7]")
    public WebElement scheduleGameLink;

    @FindBy(xpath = "/html/body/a[5]")
    public WebElement teamApplicationLink;

    @FindBy(xpath = "/html/body/h1")
    public WebElement role;

    @FindBy(xpath = "//*[@id=\"teamInfo\"]/tr/td[4]")
    public  WebElement applicationStatus;
}
