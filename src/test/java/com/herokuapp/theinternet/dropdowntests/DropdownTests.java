package com.herokuapp.theinternet.dropdowntests;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.DropdownPageObject;
import com.herokuapp.theinternet.pages.WelcomePageObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DropdownTests extends TestUtilities {

    @Test
    public void selectOptionTwoTests() {
        log.info("Starting selectOptionTests");

        /**Open Welcome page**/
        WelcomePageObject welcomePageObject = new WelcomePageObject(driver, log);
        welcomePageObject.openPage();

        /**Open Dropdown page**/
        DropdownPageObject dropdownPageObject = welcomePageObject.clickDropdownLink();

        /**Select option 2**/
        dropdownPageObject.selectOption(2);

        /**Verify option 2 is selected**/
        String selectedOption = dropdownPageObject.getSelectedOption();
        Assert.assertTrue(selectedOption.equals("Option 2"),
                "Option 2 is not selected. Instead selected " + selectedOption);

    }


}
