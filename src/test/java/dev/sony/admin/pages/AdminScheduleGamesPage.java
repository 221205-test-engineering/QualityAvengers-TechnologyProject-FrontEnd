package dev.sony.admin.pages;

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
    @FindBy(id = "venueOptions")
    public List<WebElement> venueList;
    @FindBy(xpath = "//input[@name = 'time']")
    public WebElement time;
    @FindBy(id = "seasonOptions")
    public List<WebElement> seasonOptions;
    @FindBy(name = "sport")
    public List<WebElement> sportList;
    @FindBy(id = "homeOptions")
    public List<WebElement> homeTeamList;
    @FindBy(id = "awayOptions")
    public List<WebElement> awayTeamList;
    @FindBy(xpath = "//button[text() = 'Schedule']")
    public WebElement schedule;
    @FindBy(xpath = "//a[text() = 'Back']")
    public WebElement scheduleToAdminPage;
}
