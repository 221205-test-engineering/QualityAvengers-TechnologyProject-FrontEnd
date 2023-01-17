package com.revature.admin.runner;



import com.revature.admin.pages.*;
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

