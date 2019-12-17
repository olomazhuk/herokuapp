package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SecureAreaPageObject extends BasePageObject {

    private String pageUrl = "http://the-internet.herokuapp.com/secure";

    private By logOutButton = By.xpath("//a[@class='button secondary radius']");
    private By message = By.id("flash");

    /**Constructor**/
    public SecureAreaPageObject(WebDriver driver, Logger log) {
        super(driver, log);
    }

    /**Get url variable from PageObject**/
    public String getPageUrl() {
        return pageUrl;
    }

    /**Check if LogOut button is visible**/
    public boolean isLogOutButtonVisible() {
        return find(logOutButton).isDisplayed();
    }

    /**Get success message text**/
    public String getSuccessMessageText() {
        return find(message).getText();
    }

}
