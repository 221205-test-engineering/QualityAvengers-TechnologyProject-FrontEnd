package com.revature.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ManageUserRolePage {
    public WebDriver driver;
    public ManageUserRolePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//h1[text() = 'User Manager']")
    public WebElement rolePage;

    @FindBy(xpath = "//*[@id='userTableBody']/tr[5]/td[5]/button")
    public WebElement promReferee;

    @FindBy(xpath = "//*[@id='userTableBody']/tr[5]/td[4]/button")
    public WebElement changeRole1;

    @FindBy(xpath = "//*[@id='userTableBody']/tr[5]/td[3]")
    public WebElement role5;

    @FindBy(xpath = "//*[@id='userTableBody']/tr[8]/td[4]/button")
    public WebElement changeRole2;

    @FindBy(xpath = "//*[@id='userTableBody']/tr[8]/td[3]")
    public WebElement role8;

    @FindBy(xpath = "//*[@id='userTableBody']/tr")
    public List<WebElement> listOfUsers;

    @FindBy(xpath = "//a[text() = 'Back']")
    public WebElement roleToAdminPage;
}
