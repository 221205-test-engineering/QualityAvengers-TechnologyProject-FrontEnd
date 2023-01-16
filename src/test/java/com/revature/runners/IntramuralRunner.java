package com.revature.runners;

import com.revature.pages.*;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/com/revature/features/gameTeam/player.feature", glue = "com/revature/steps/gameTeam")

public class IntramuralRunner {
    public static WebDriver driver;
    public static IndexPage indexPage;
    public static LoginPage loginPage;
    public static TeamApplicationPage teamApplicationPage;
    public static TeamRequestPage teamRequestPage;
    public static MainPage mainPage;
    public static OfficiatingChoicePage officiatingChoicePage;
    public static OfficiateGamePage officiateGamePage;

    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        indexPage = new IndexPage(driver);
        loginPage = new LoginPage(driver);
        teamApplicationPage = new TeamApplicationPage(driver);
        teamRequestPage = new TeamRequestPage(driver);
        mainPage = new MainPage(driver);
        officiatingChoicePage = new OfficiatingChoicePage(driver);
        officiateGamePage = new OfficiateGamePage(driver);

    }

    @AfterClass
    public static void teardown(){
        driver.quit();
    }
}
