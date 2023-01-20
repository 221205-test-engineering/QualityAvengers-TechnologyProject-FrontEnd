package com.revature.runners;


import com.revature.pages.IndexPage;
import com.revature.pages.LoginPage;
import com.revature.pages.RegisterPage;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/com/revature/features/login_update_register",
                 glue = "com.revature.steps.khavvia")
public class LoginUpdateRegisterRunner {
    public static WebDriver driver;
    public static IndexPage indexPage1;
    public static LoginPage loginPage1;
    public static RegisterPage registerPage1;

    @BeforeClass
    public static void setup(){
        driver = new ChromeDriver();
    }

    public static void teardown(){
        driver.quit();
    }
}
