package com.revature.runners;


import com.revature.pages.*;
import io.cucumber.java.sl.In;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@RunWith(Cucumber.class)

// UNCOMMENT THIS!!
/*
@CucumberOptions(features = "src/test/java/com/revature/features/login_update_register",
                 glue = "com.revature.steps.khavvia")
*/

@CucumberOptions(features = "src/test/java/com/revature/features/login_update_register/update_positive.feature",
        glue = "com.revature.steps.khavvia")

public class LoginUpdateRegisterRunner {
    public static WebDriver driver1;
    public static IndexPage indexPage1;
    public static LoginPage loginPage1;
    public static RegisterPage registerPage1;
    public static MainPage mainPage1;


    @BeforeClass
    public static void setup(){
        driver1 = new ChromeDriver();
        indexPage1 = new IndexPage(driver1);
        loginPage1 = new LoginPage(driver1);
        registerPage1 = new RegisterPage(driver1);
        mainPage1 = new MainPage(driver1);
    }

    public static void teardown(){
        driver1.quit();
    }
}
