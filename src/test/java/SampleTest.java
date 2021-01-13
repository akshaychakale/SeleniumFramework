package test.java;

import main.java.pageEvents.HomePageEvents;
import main.java.pageEvents.LoginPageEvents;
import main.java.pageObjects.LoginPageElements;
import org.testng.annotations.Test;

public class SampleTest extends BaseTest{

    @Test
    public void amazonTest(){
        HomePageEvents homePageEvents=new HomePageEvents();
        LoginPageEvents loginPageEvents=new LoginPageEvents();
        loginPageEvents.login();
        homePageEvents.searchProduct("harry potter");
    }
}
