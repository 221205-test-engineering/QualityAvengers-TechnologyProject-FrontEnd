package com.revature.admin.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AdminViewsGamePage {

    public WebDriver driver;
    public AdminViewsGamePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//thead/tr")
    public List<WebElement> gameHeaderList;
    @FindBy(id = "gameTableBody")
    public List<WebElement> gamesList;
    @FindBy(xpath = "//button[text() = 'Show Referees']")
    public WebElement referees;
    @FindBy(xpath = "//section[last()]/p")
    public List<WebElement> refereeDetails;
    @FindBy(xpath = "//button[text() = 'Close']")
    public WebElement refereeDisappears;
    @FindBy(xpath = "//a[text() = 'Back']")
    public WebElement gameToAdminPage;

}
