package dev.sony.admin.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
//THIS PAGE HAS BEEN INTERGRATED AND NEEDS TO BE DELETED.
//PLEASE USE THE NEW ONE AND THE WEB ELEMENTS IT REFERENCES

public class AdminScheduleGames {
    public WebDriver driver;
    public AdminScheduleGames(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(id = "venueOptions")
    public List<WebElement> venueList;
    @FindBy(name = "time")
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
