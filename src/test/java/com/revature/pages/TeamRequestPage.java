package com.revature.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TeamRequestPage
{
    public WebDriver driver;
    public TeamRequestPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//*[@id=\"teamRequests\"]/tr/td[4]/button")
    public WebElement approveButton;

    @FindBy(xpath = "//*[@id=\"teamRequests\"]/tr/td[5]/button")
    public WebElement denyButton;

    @FindBy(xpath = "//*[@id=\"teamRequests\"]/tr/td[last()]/button")
    public WebElement seePlayerButton;

    @FindBy(xpath = "//table/tbody/tr[last()]/td[3]")
    public WebElement requestList;

    @FindBy(xpath = "//body/section")
    public WebElement playerInfoSection;

    @FindBy(xpath = "//*[@id=\"teamRequests\"]/tr/td[3]")
    public WebElement requestStatus;
}
