package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropdownPageObject extends BasePageObject {

    private By dropdown = By.id("dropdown");

    public DropdownPageObject(WebDriver driver, Logger log) {
        super(driver, log);
    }

    /**Select option by given option number**/
    public void selectOption(int option) {
        log.info("Selecting option " + option);
        WebElement dropdownElement = find(dropdown);
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByValue("" + option);
    }

    /**Get selected option*/
    public String getSelectedOption() {
        WebElement dropdownElement = find(dropdown);
        Select dropdown = new Select(dropdownElement);
        String selectedOption = dropdown.getFirstSelectedOption().getText();
        log.info("Selected option is " + selectedOption);
        return selectedOption;
    }

}
