package com.revature.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//THIS PAGE HAS BEEN INTERGRATED AND NEEDS TO BE DELETED.
//PLEASE USE THE NEW ONE AND THE WEB ELEMENTS IT REFERENCES

public class CptHomePage {

    public WebDriver driver;
    public CptHomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "/html/body/a[5]")
    public WebElement adRequest;
}
