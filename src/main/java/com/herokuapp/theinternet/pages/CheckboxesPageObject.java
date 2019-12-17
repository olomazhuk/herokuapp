package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CheckboxesPageObject extends BasePageObject {

    private By checkboxElement = By.xpath("//input[@type='checkbox']");

    public CheckboxesPageObject(WebDriver driver, Logger log) {
        super(driver, log);
    }

    /**Get list of all checkboxes and check if unchecked**/
    public void selectAllCheckboxes() {
        log.info("Selecting all checkboxes if unchecked");
        List<WebElement> checkboxes = findAll(checkboxElement);
        for (WebElement checkbox : checkboxes) {
            if (!checkbox.isSelected()) {
                checkbox.click();
            }
        }
    }

    /**Verify all available checkboxes are checked**/
    public boolean areAllCheckboxesChecked() {
        log.info("Verifying that all checkboxes are checked");
        List<WebElement> checkboxes = findAll(checkboxElement);
        for (WebElement checkbox : checkboxes) {
            if (!checkbox.isSelected()) {
                return false;
            }
        }
        return true;
    }

}
