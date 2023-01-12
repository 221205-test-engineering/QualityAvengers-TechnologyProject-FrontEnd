package dev.sony.admin.pages;

import java.util.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//THIS PAGE HAS BEEN INTERGRATED AND NEEDS TO BE DELETED.
//PLEASE USE THE NEW ONE AND THE WEB ELEMENTS IT REFERENCES

public class AdminViewsSeasonPage {
    public WebDriver driver;
    public AdminViewsSeasonPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//th[text()='Season Name'")
    public WebElement seasonName;
    @FindBy(id = "seasonTableBody")
    public List<WebElement> seasonList;
    @FindBy(xpath = "//a[text() = 'Back']")
    public WebElement seasonToAdminPage;
}
