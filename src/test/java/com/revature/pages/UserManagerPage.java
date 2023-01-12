package com.revature.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserManagerPage
{
    public WebDriver driver;
    public UserManagerPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//*[@id=\"userTableBody\"]/tr[1]/td[4]/button")
    public WebElement demoteToPlayerButton;

    @FindBy(xpath = "//*[@id=\"userTableBody\"]/tr[9]/td[4]/button")
    public WebElement promoteToAdminButton;

    @FindBy(xpath = "//*[@id=\"userTableBody\"]/tr[10]/td[5]/button")
    public WebElement promoteToRefereeButton;
}
