package com.revature.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class AdminScheduleGamesPage {
    public WebDriver driver;
    public AdminScheduleGamesPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//*[@id=\"venueOptions\"]/option[2]")
    public WebElement venueList;
    @FindBy(xpath = "//input[@name = 'time']")
    public WebElement time;
    @FindBy(name = "season")
    public WebElement seasonOptions;
    @FindBy(name = "sport")
    public WebElement sportList;
    @FindBy(xpath = "//*[@id=\"homeOptions\"]")
    public WebElement homeTeamList;
    @FindBy(id = "awayOptions")
    public WebElement awayTeamList;
    @FindBy(xpath = "//button[text() = 'Schedule']")
    public WebElement schedule;
    @FindBy(xpath = "//a[text() = 'Back']")
    public WebElement scheduleToAdminPage;
}
