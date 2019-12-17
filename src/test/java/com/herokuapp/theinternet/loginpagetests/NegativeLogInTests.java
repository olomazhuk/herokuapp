package com.herokuapp.theinternet.loginpagetests;

import com.herokuapp.theinternet.base.CsvDataProviders;
import com.herokuapp.theinternet.pages.LoginPageObject;
import com.herokuapp.theinternet.pages.WelcomePageObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.TestUtilities;

import java.util.Map;

public class NegativeLogInTests extends TestUtilities {

    @Test(priority = 1, dataProvider = "csvReader", dataProviderClass = CsvDataProviders.class)
    public void negativeLogInTest(Map<String, String> testData) {
        // Data
        String no = testData.get("no");
        String username  = testData.get("username");
        String password = testData.get("password");
        String expectedErrorMessage = testData.get("expectedErrorMessage");
        String description = testData.get("description");

        log.info("Starting negativeLoginTest with №" + no + " for " + description);

        /**Open Welcome page**/
        WelcomePageObject welcomePageObject = new WelcomePageObject(driver, log);
        welcomePageObject.openPage();

        /**Click on Form Authentication link**/
        LoginPageObject loginPageObject = welcomePageObject.clickFormAuthenticationLink();

        /**Log in**/
        loginPageObject.negativelogIn(username, password);

        /**Verification that error message is expected**/
        String actualErrorMessage = loginPageObject.getErrorMessageText();
        Assert.assertTrue(actualErrorMessage.contains(expectedErrorMessage),
                "actualErrorMessage does not contain expectedErrorMessage\nexpectedErrorMessage: "
                        + expectedErrorMessage + "\nactualErrorMessage: " + actualErrorMessage);
    }
}