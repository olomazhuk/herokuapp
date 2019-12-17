package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WelcomePageObject extends BasePageObject {

    private String pageUrl = "http://the-internet.herokuapp.com/";

    private By formAuthenticationLinkLocator = By.linkText("Form Authentication");
    private By formCheckboxesLinkLocator = By.linkText("Checkboxes");
    private By formDropdownLinkLocator = By.linkText("Dropdown");
    private By formJavaScriptAlertsLinkLocator = By.linkText("JavaScript Alerts");
    private By formMultipleWindowsLinkLocator = By.linkText("Multiple Windows");
    private By formEditorPageLinkLocator = By.linkText("WYSIWYG Editor");

    /**Constructor**/
    public WelcomePageObject(WebDriver driver, Logger log) {
        super(driver, log);
    }

    /**Open Welcome page with it's url**/
    public void openPage() {
        log.info("Opening page " + pageUrl);
        openUrl(pageUrl);
        log.info("Page opened!");
    }

    /**Open Login Page by clicking on Form Authentication link**/
    public LoginPageObject clickFormAuthenticationLink() {
        log.info("Clicking Form Authentication link on Welcome Page");
        click(formAuthenticationLinkLocator);
        return new LoginPageObject(driver, log);
    }

    /**Open Checkboxes page by clicking on Checkboxes link**/
    public CheckboxesPageObject clickCheckboxesLink() {
        log.info("Clicking Checkboxes link on Welcome Page");
        click(formCheckboxesLinkLocator);
        return new CheckboxesPageObject(driver, log);
    }

    /**Open Dropdown page by clicking on Checkboxes link**/
    public DropdownPageObject clickDropdownLink() {
        log.info("Clicking Dropdown link on Welcome Page");
        click(formDropdownLinkLocator);
        return new DropdownPageObject(driver, log);
    }

    /**Open JavaScriptAlerts page by clicking on Checkboxes link**/
    public JavaScriptAlertsPageObject clickJavaScriptAlertsLink() {
        log.info("Clicking JavaScriptAlerts link on Welcome Page");
        click(formJavaScriptAlertsLinkLocator);
        return new JavaScriptAlertsPageObject(driver, log);
    }

    /**Open Multiple Windows page by clicking on Checkboxes link**/
    public WindowPageObject clickMultipleWindowsLink() {
        log.info("Clicking Multiple Windows link on Welcome Page");
        click(formMultipleWindowsLinkLocator);
        return new WindowPageObject(driver, log);
    }

    /**Open Editor page by clicking on Checkboxes link**/
    public EditorPageObject clickEditorPageLink() {
        log.info("Clicking EditorPage link on Welcome Page");
        click(formEditorPageLinkLocator);
        return new EditorPageObject(driver, log);
    }

}
