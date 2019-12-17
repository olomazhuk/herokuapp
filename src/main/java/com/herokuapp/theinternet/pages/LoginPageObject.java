package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPageObject extends BasePageObject {

    private By usernameLocator = By.id("username");
    private By passwordLocator = By.name("password");
    private By logInButtonLocator = By.tagName("button");
    private By message = By.id("flash");

    /**Constructor**/
    public LoginPageObject(WebDriver driver, Logger log) {
        super(driver, log);
    }

    /**Execute positive Log In**/
    public SecureAreaPageObject logIn(String username, String password) {
        log.info("Executing Log In with username [" + username + "] and password [" + password + "]");
        type(username, usernameLocator);
        type(password, passwordLocator);
        click(logInButtonLocator);
        return new SecureAreaPageObject(driver, log);
    }

    /**Execute negative Log In**/
    public void negativelogIn(String username, String password) {
        log.info("Executing Log In with username [" + username + "] and password [" + password + "]");
        type(username, usernameLocator);
        type(password, passwordLocator);
        click(logInButtonLocator);
    }

    /**Get error message text if visible**/
    public String getErrorMessageText() {
        waitForVisibilityOf(message, 5);
        return find(message).getText();
    }

}
