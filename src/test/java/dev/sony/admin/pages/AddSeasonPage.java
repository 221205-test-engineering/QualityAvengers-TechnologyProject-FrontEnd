package dev.sony.admin.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AddSeasonPage {
    public WebDriver driver;
    public AddSeasonPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h1[text() = 'Season Scheduler']")
    public WebElement titleAddSeasonPage;
    @FindBy(id = "seasonTableBody")
    public List<WebElement> listOfSeasons;
    @FindBy(xpath = "//input[@name = 'season']")
    public WebElement addNewSeason;
    @FindBy(xpath = "//button[text() = 'Submit']")
    public WebElement newSeasonSubmit;
    @FindBy(xpath = "//a[text() = 'Back']")
    public WebElement addSeasonToAdminPage;

}
