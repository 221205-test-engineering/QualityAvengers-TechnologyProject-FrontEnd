package com.revature.runners;

import com.revature.pages.AppDenyPage;
import com.revature.pages.CptHomePage;
import com.revature.pages.IndexPage;
import com.revature.pages.LoginPage;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/com/revature/features", glue = "com/revature/steps")

public class IntramuralRunner {
    public static WebDriver driver;
    public static IndexPage indexPage;
    public static LoginPage loginPage;
    public static CptHomePage cptHomePage;
    public static com.revature.pages.AppDenyPage AppDenyPage;

    @BeforeClass
    public static void setup(){
        driver = new ChromeDriver();
    }

    public static void teardown(){driver.quit();}
}
