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
//    Write a Selenium script to test the login and logout and Add to cart functionality of the Amazon website using Java and Selenium WebDriver. The script should:

    @Test(enabled = false)
    public void demoTest(){
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver,15);
        driver.get("https://www.amazon.in/");
        WebElement signInLink = driver.findElement(By.xpath("//a[@id='nav-link-accountList']"));
        signInLink.click();

        WebElement email=driver.findElement(By.xpath("//input[@id='ap_email']"));




        email.sendKeys("8983669632");
        WebElement continueButton=driver.findElement(By.xpath("//span[@id=\"continue\"]"));
        continueButton.click();
        WebElement password = driver.findElement(By.xpath("//input[@id='ap_password']"));
        password.sendKeys("**********");
        WebElement signInButton =driver.findElement(By.xpath("//input[@id=\"signInSubmit\"]"));
        signInButton.click();
        WebElement searchBar = driver.findElement(By.xpath("//input[@id=\"twotabsearchtextbox\"]"));
        searchBar.sendKeys("iphone 12");
        searchBar.sendKeys(Keys.ENTER);
        WebElement firstProduct = driver.findElement(By.xpath("(//span[@class=\"a-size-medium a-color-base a-text-normal\"])[1]"));
        firstProduct.click();
        WebElement addToCart = driver.findElement(By.xpath("//input[@id=\"add-to-cart-button\"]"));
        addToCart.click();
        WebElement verifiyCart= driver.findElement(By.xpath("(//div[@class=\"a-row a-spacing-top-small\"]//following::input)[1]"));
        Assert.assertTrue(verifiyCart.isDisplayed());
        Actions actions = new Actions(driver);
        actions.moveToElement(signInLink);
        WebElement singOut= driver.findElement(By.xpath("//a[@id=\"nav-item-signout\"]"));
        singOut.click();
        driver.quit();


    }
}
