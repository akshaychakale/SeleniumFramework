package main.java.pageEvents;

import main.java.pageObjects.LoginPageElements;
import main.java.utils.ElementFetch;

public class LoginPageEvents {

    public void login(){
        ElementFetch elementFetch=new ElementFetch();
        elementFetch.getWebElement("ID", LoginPageElements.signInLink).click();
        elementFetch.getWebElement("ID", LoginPageElements.emailField).sendKeys("akshaychakale@gmail.com");
        elementFetch.getWebElement("ID", LoginPageElements.continueButton).click();
        elementFetch.getWebElement("ID", LoginPageElements.passwordField).sendKeys("Demo@123");
        elementFetch.getWebElement("ID", LoginPageElements.signInButton).click();

    }
}
