package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WindowPageObject extends BasePageObject {

    private By openNewWindowButtonLocator = By.linkText("Click Here");;

    public WindowPageObject(WebDriver driver, Logger log) {
        super(driver, log);
    }

    /**Open new window**/
    public void openNewWindow() {
        log.info("Opening new window");
        click(openNewWindowButtonLocator);
    }

    /**Find page with title and switch to it*/
    public NewWindowPageObject switchToNewWindow() {
        log.info("Looking for new window page");
        switchToWindowWithTitle("New Window");
        return new NewWindowPageObject(driver, log);
    }

}
