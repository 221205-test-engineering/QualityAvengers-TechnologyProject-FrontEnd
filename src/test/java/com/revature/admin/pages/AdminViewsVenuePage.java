package com.revature.admin.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AdminViewsVenuePage {
    public WebDriver driver;
    public AdminViewsVenuePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath= "//th[text() = 'Venue Name']")
    public WebElement venueName;
    @FindBy(id = "venueTableBody")
    public List<WebElement> venueList;
    @FindBy(xpath = "//a[text() = 'Back']")
    public WebElement venueToAdminPage;
}
