package com.revature.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TeamApplicationPage
{
    public WebDriver driver;
    public TeamApplicationPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//*[@id=\"teamInfo\"]/tr[1]/td[5]/button")
    public WebElement seeCaptainButton;

    @FindBy(xpath = "/html/body/div/button")
    public WebElement applyButton;

    @FindBy(xpath = "/html/body/table")
    public WebElement teamList;

    @FindBy(xpath = "/html/body/section")
    public WebElement cptInfoSection;

    @FindBy(xpath = "/html/body/section/button")
    public WebElement closeCptSession;

    @FindBy(xpath = "//*[@id=\"teamInfo\"]/tr/td[4]")
    public  WebElement applicationStatus;

    @FindBy(xpath = "/html/body/div/select")
    public WebElement selectTeam;

    @FindBy(xpath = "/html/body/div/p")
    public WebElement alreadyInTeam;

}
