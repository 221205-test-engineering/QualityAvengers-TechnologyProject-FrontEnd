package dev.sony.admin.runner;


import dev.sony.admin.pages.*;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;

import java.time.Duration;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/dev/sony/admin/features/adminViews.feature", glue = "dev.sony.admin.steps")
public class AdminRunner {

        public static WebDriver driver;
        public static LoginPage login;
        public static AdminPage admin;
        public static AdminViewsGamePage viewGames;
        public static AdminViewsVenuePage venues;
        public static AdminViewsSeasonPage seasons;
        public static EditUserProfilePage editProfile;
        public static ManageUserRolePage userRoles;
        public static AddSeasonPage addSeason;
        public static AdminScheduleGamesPage scheduleGames;
        @BeforeClass
        public static void setup(){
            WebDriverManager.chromedriver().setup();  // Driver setup
            driver = new ChromeDriver();  // Instantiating chrome driver
            login = new LoginPage(driver);
            admin = new AdminPage(driver);
            viewGames = new AdminViewsGamePage(driver);
            venues = new AdminViewsVenuePage(driver);
            seasons = new AdminViewsSeasonPage(driver);
            editProfile = new EditUserProfilePage(driver);
            userRoles = new ManageUserRolePage(driver);
            addSeason = new AddSeasonPage(driver);
            scheduleGames = new AdminScheduleGamesPage(driver);
        }

        @AfterClass
        public static void teardown()
        {
            driver.quit();
        }
}

