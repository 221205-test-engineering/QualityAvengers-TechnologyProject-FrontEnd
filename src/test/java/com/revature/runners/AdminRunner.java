package com.revature.runners;



import com.revature.pages.AdminAddSeasonPage;
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
@CucumberOptions(features = "src/test/java/com/revature/admin/features", glue = "com.revature.admin.steps")
public class AdminRunner {

        public static WebDriver driver;
        public static AdminLoginPage login;

        public static AdminPage admin;
        public static AdminViewsGamePage viewGames;
        public static AdminViewsVenuePage venues;
        public static AdminViewsSeasonPage seasons;
        public static EditUserProfilePage editProfile;
        public static ManageUserRolePage userRoles;
        public static AdminAddSeasonPage addSeason;
        public static AdminScheduleGamesPage scheduleGames;
        @BeforeClass
        public static void setup(){
            WebDriverManager.chromedriver().setup();  // Driver setup
            driver = new ChromeDriver();  // Instantiating chrome driver
            login = new AdminLoginPage(driver);
            admin = new AdminPage(driver);
            viewGames = new AdminViewsGamePage(driver);
            venues = new AdminViewsVenuePage(driver);
            seasons = new AdminViewsSeasonPage(driver);
            editProfile = new EditUserProfilePage(driver);
            userRoles = new ManageUserRolePage(driver);
            addSeason = new AdminAddSeasonPage(driver);
            scheduleGames = new AdminScheduleGamesPage(driver);
        }

        @AfterClass
        public static void teardown()
        {
            driver.quit();
        }
}

