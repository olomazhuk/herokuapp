package com.herokuapp.theinternet.checkboxestests;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.CheckboxesPageObject;
import com.herokuapp.theinternet.pages.WelcomePageObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckboxesTests extends TestUtilities {

    @Test
    public void selectTwoCheckboxesTests() {
        log.info("Starting selectTwoCheckboxesTests");

        /**Open Welcome page**/
        WelcomePageObject welcomePageObject = new WelcomePageObject(driver, log);
        welcomePageObject.openPage();

        /**Open Checkboxes page**/
        CheckboxesPageObject checkboxesPageObject = welcomePageObject.clickCheckboxesLink();

        /**Click two checkboxes**/
        checkboxesPageObject.selectAllCheckboxes();

        /**Verify all checkboxes are checked**/
        Assert.assertTrue(checkboxesPageObject.areAllCheckboxesChecked(), "Not all checkboxes are checked!");

    }


}
