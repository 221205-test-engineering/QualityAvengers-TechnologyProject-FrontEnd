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

    @FindBy(xpath = "/html/body/div/select")
    public WebElement selectTeam;

    @FindBy(xpath = "/html/body/div/button")
    public WebElement applyButton;

}
