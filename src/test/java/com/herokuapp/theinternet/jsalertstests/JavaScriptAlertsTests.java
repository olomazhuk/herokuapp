package com.herokuapp.theinternet.jsalertstests;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.JavaScriptAlertsPageObject;
import com.herokuapp.theinternet.pages.WelcomePageObject;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class JavaScriptAlertsTests extends TestUtilities {

    @Test
    public void jsAlertTest() {
        SoftAssert softAssert = new SoftAssert();

        /**Open Welcome page**/
        WelcomePageObject welcomePageObject = new WelcomePageObject(driver, log);
        welcomePageObject.openPage();

        /**Open JavaScript Alerts page**/
        JavaScriptAlertsPageObject javaScriptAlertsPageObject = welcomePageObject.clickJavaScriptAlertsLink();

        /**Open JS Alert**/
        javaScriptAlertsPageObject.openJSAlert();

        /**Get alert text**/
        String alertMessage = javaScriptAlertsPageObject.getAlertText();

        /**Click OK button**/
        javaScriptAlertsPageObject.acceptAlert();

        /**Get Results text**/
        String result = javaScriptAlertsPageObject.getResultText();

        /**Verifications
         *  1 - Alert text is expected
         */
        softAssert.assertTrue(alertMessage.equals("I am a JS Alert"),
                "Alert message is not expected. \nShould be 'I am a JS Alert', but it is '" + alertMessage + "'");

        /**2 - Result text is expected**/
        softAssert.assertTrue(result.equals("You successfuly clicked an alert"),
                "result is not expected. \nShould be 'You successfuly clicked an alert', but it is '" + result + "'");
        softAssert.assertAll();
    }

    @Test
    public void jsDismissTest() {
        SoftAssert softAssert = new SoftAssert();

        /**Open Welcome page**/
        WelcomePageObject welcomePageObject = new WelcomePageObject(driver, log);
        welcomePageObject.openPage();

        /**Open JavaScript Alerts page**/
        JavaScriptAlertsPageObject javaScriptAlertsPageObject = welcomePageObject.clickJavaScriptAlertsLink();

        /**Click JS Confirm button**/
        javaScriptAlertsPageObject.openJSConfirm();

        /**Get alert text**/
        String alertMessage = javaScriptAlertsPageObject.getAlertText();

        /**Click Cancel button**/
        javaScriptAlertsPageObject.dismissAlert();

        /**Get Results text**/
        String result = javaScriptAlertsPageObject.getResultText();

        /**Verifications
         *  1 - Alert text is expected
         */
        softAssert.assertTrue(alertMessage.equals("I am a JS Confirm"),
                "Alert message is not expected. \nShould be 'I am a JS Confirm', but it is '" + alertMessage + "'");

        /**2 - Result text is expected**/
        softAssert.assertTrue(result.equals("You clicked: Cancel"),
                "result is not expected. \nShould be 'You clicked: Cancel', but it is '" + result + "'");
        softAssert.assertAll();
    }

    @Test
    public void jsPromptTest() {
        SoftAssert softAssert = new SoftAssert();

        /**Open Welcome page**/
        WelcomePageObject welcomePageObject = new WelcomePageObject(driver, log);
        welcomePageObject.openPage();

        /**Open JavaScript Alerts page**/
        JavaScriptAlertsPageObject javaScriptAlertsPageObject = welcomePageObject.clickJavaScriptAlertsLink();

        /**Click JS Prompt button**/
        javaScriptAlertsPageObject.openJSPrompt();

        /**Get alert text**/
        String alertMessage = javaScriptAlertsPageObject.getAlertText();

        /**Type text into alert**/
        javaScriptAlertsPageObject.typeTextIntoAlert("Hello Alert, it's Dmitry here");

        /**Get Results text**/
        String result = javaScriptAlertsPageObject.getResultText();

        /**Verifications
         *  1 - Alert text is expected
         */
        softAssert.assertTrue(alertMessage.equals("I am a JS prompt"),
                "Alert message is not expected. \nShould be 'I am a JS prompt', but it is '" + alertMessage + "'");

        /**2 - Result text is expected**/
        softAssert.assertTrue(result.equals("You entered: Hello Alert, it's Dmitry here"),
                "result is not expected. \nShould be 'You entered: Hello Alert, its Dmitry here', but it is '" + result
                        + "'");
        softAssert.assertAll();
    }

}
