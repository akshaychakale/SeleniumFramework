package test.java;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import main.java.utils.Constants;
import org.apache.tools.ant.util.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.io.File;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    public static WebDriver driver;
    public ExtentHtmlReporter htmlReporter;
    public static ExtentReports extent;
    public static ExtentTest logger;

    @BeforeTest
    public void beforeTest() {
        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + File.separator + "reports" + File.separator + "AutocationReport.html");
        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setDocumentTitle("Automation Report");
        htmlReporter.config().setReportName("Automation Test Results");
        htmlReporter.config().setTheme(Theme.DARK);
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("Automation Tester", "COMPANY_NAME");
    }

    @BeforeMethod
    @Parameters(value = {"browserName"})
    public void beforeMethod(String browserName, Method testMethod) {
        logger = extent.createTest(testMethod.getName());
        setupDriver(browserName);
        driver.manage().window().maximize();
        driver.get(Constants.url);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }


    @AfterMethod
    public void afterMethod(ITestResult result) {
        if (result.getStatus() == ITestResult.SUCCESS) {
            String methodName = result.getMethod().getMethodName();
            String logText = "Test Case: " + methodName + " Passed";
            Markup markup = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
            logger.log(Status.PASS, markup);
        } else if (result.getStatus() == ITestResult.FAILURE) {
            String methodName = result.getMethod().getMethodName();
            String logText = "Test Case: " + methodName + " Failed";
            Markup markup = MarkupHelper.createLabel(logText, ExtentColor.RED);
            logger.log(Status.FAIL, markup);
            //driver.quit();
        }
    }

        @AfterTest
        public void afterTest () {
            extent.flush();
            driver.quit();
        }


        public void setupDriver (String browserName){

            if (browserName.equalsIgnoreCase("chrome")) {
                // System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + File.separator + "drivers" + File.separator + "chromedriver.exe");
                WebDriverManager.ChromeDriver.setup();
                driver = new ChromeDriver();

            } else if (browserName.equalsIgnoreCase("firefox")) {
                // System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + File.separator + "drivers" + File.separator + "geckodriver.exe");
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            } else {
                // System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + File.separator + "drivers" + File.separator + "chromedriver.exe");
                WebDriverManager.ChromeDriver.setup();
                driver = new ChromeDriver();
            }
        }
    }
