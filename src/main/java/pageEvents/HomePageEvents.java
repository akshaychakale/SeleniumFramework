package main.java.pageEvents;

import main.java.pageObjects.LoginPageElements;
import main.java.utils.ElementFetch;

public class HomePageEvents {

    public void searchProduct(String product){
        ElementFetch elementFetch=new ElementFetch();
        elementFetch.getWebElement("CSS", LoginPageElements.searchBar).sendKeys(product);
        elementFetch.getWebElement("ID", LoginPageElements.searchButton).click();
    }


}
