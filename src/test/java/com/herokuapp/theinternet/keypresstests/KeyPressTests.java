package com.herokuapp.theinternet.keypresstests;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.KeyPressPageObject;

public class KeyPressTests extends TestUtilities {

    @Test
    public void pressKeyTest() {
        log.info("Starting pressKeyTest");

        // open KeyPressesPage
        KeyPressPageObject keyPressPageObject = new KeyPressPageObject(driver, log);
        keyPressPageObject.openPage();

        // Push keyboard key
        keyPressPageObject.pressKey(Keys.ENTER);

        // Get Results text
        String result = keyPressPageObject.getResultText();

        // Verify Result text is expected
        Assert.assertTrue(result.equals("You entered: ENTER"),
                "result is not expected. \nShould be 'You entered: ENTER', but it is '" + result + "'");
    }

    @Test
    public void pressKeyWithActionsTest() {
        log.info("Starting pressKeyWithActionsTest");

        // open KeyPressesPage
        KeyPressPageObject keyPressPageObject = new KeyPressPageObject(driver, log);
        keyPressPageObject.openPage();

        // Push keyboard key
        keyPressPageObject.pressKeyWithActions(Keys.SPACE);

        // Get Results text
        String result = keyPressPageObject.getResultText();

        // Verify Result text is expected
        Assert.assertTrue(result.equals("You entered: SPACE"),
                "result is not expected. \nShould be 'You entered: ENTER', but it is '" + result + "'");
    }
}