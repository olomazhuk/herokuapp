package com.herokuapp.theinternet.windowstests;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.NewWindowPageObject;
import com.herokuapp.theinternet.pages.WindowPageObject;
import com.herokuapp.theinternet.pages.WelcomePageObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WindowsTests extends TestUtilities {

    @Test
    public void newWindowTest() {
        log.info("Starting newWindowTest");

        /**Open Welcome page**/
        WelcomePageObject welcomePageObject = new WelcomePageObject(driver, log);
        welcomePageObject.openPage();

        /**Open MultipleWindows page**/
        WindowPageObject windowPageObject = welcomePageObject.clickMultipleWindowsLink();

        /**Open new window**/
        windowPageObject.openNewWindow();

        /**Find and switch to new window**/
        NewWindowPageObject newWindowPageObject = windowPageObject.switchToNewWindow();

        String pageSource = newWindowPageObject.getCurrentPageSource();

        /**Verifying that new page contains expected text in source**/
        Assert.assertTrue(pageSource.contains("New Window"), "New page source doesn't contain expected text");

    }


}
