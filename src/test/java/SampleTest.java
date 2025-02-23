package test.java;

import io.github.bonigarcia.wdm.WebDriverManager;
import main.java.pageEvents.HomePageEvents;
import main.java.pageEvents.LoginPageEvents;
import main.java.pageObjects.LoginPageElements;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SampleTest extends BaseTest{

// Sample test to check framework
    @Test
    public void amazonTest(){
        HomePageEvents homePageEvents=new HomePageEvents();
        LoginPageEvents loginPageEvents=new LoginPageEvents();
        loginPageEvents.login();
        homePageEvents.searchProduct("harry potter");
    }

    }
