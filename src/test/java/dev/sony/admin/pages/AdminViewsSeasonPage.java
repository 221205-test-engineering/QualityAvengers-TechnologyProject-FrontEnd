package dev.sony.admin.pages;

import java.util.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminViewsSeasonPage {
    public WebDriver driver;
    public AdminViewsSeasonPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//thead/tr/th[text()='Season Name']")
    public WebElement seasonName;
    @FindBy(id = "seasonTableBody")
    public List<WebElement> seasonList;
    @FindBy(xpath = "//a[text() = 'Back']")
    public WebElement seasonToAdminPage;
}
