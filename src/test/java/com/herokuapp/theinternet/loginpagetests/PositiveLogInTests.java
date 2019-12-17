package com.herokuapp.theinternet.loginpagetests;

import com.herokuapp.theinternet.pages.LoginPageObject;
import com.herokuapp.theinternet.pages.SecureAreaPageObject;
import com.herokuapp.theinternet.pages.WelcomePageObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.TestUtilities;

public class PositiveLogInTests extends TestUtilities {

    @Test
    public void logInTest() {
        log.info("Starting logInTest");

        /**Open Welcome page**/
        WelcomePageObject welcomePageObject = new WelcomePageObject(driver, log);
        welcomePageObject.openPage();
        takeScreenshot("WelcomePage opened");

        /**Click on Form Authentication link**/
        LoginPageObject loginPageObject = welcomePageObject.clickFormAuthenticationLink();
        takeScreenshot("LoginPage opened");

        /**Log in**/
        SecureAreaPageObject secureAreaPageObject = loginPageObject.logIn("tomsmith", "SuperSecretPassword!");
        takeScreenshot("SecureAreaPage opened");

        /**Verifications:
         * New page url is expected
         * **/
        Assert.assertEquals(secureAreaPageObject.getCurrentUrl(), secureAreaPageObject.getPageUrl());

        /** log out button is visible **/
        Assert.assertTrue(secureAreaPageObject.isLogOutButtonVisible(), "logOutButton is not visible.");

        /**Successful log in message is expected**/
        String expectedSuccessMessage = "You logged into a secure area!";
        String actualSuccessMessage = secureAreaPageObject.getSuccessMessageText();
        Assert.assertTrue(actualSuccessMessage.contains(expectedSuccessMessage),
                "actualSuccessMessage does not contain expectedSuccessMessage\nexpectedSuccessMessage: "
                        + expectedSuccessMessage + "\nactualSuccessMessage: " + actualSuccessMessage);
    }
}