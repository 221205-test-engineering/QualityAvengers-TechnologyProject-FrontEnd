package dev.sony.admin.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//SONI CAN YOU MOVE YOUR FILES INTO THE SAME PACKAGES AS THE OTHERS?
//IT MAKES IT EASIER WHAT ALL EVERYONE HAS WORKED ON

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/dev/sony/admin/features", glue = "admin.steps")
public class AdminRunner {

        public static WebDriver driver;
        @BeforeClass
        public static void setup()
        {
            WebDriverManager.chromedriver().setup();  // Driver setup
            driver = new ChromeDriver();  // Instantiating chrome driver
        }

        @AfterClass
        public static void teardown()
        {
            driver.quit();
        }
}

