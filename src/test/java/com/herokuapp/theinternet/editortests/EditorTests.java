package com.herokuapp.theinternet.editortests;

import com.herokuapp.theinternet.pages.EditorPageObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.WelcomePageObject;

public class EditorTests extends TestUtilities {

    @Test
    public void defaultEditorValueTest() {
        log.info("Starting defaultEditorValueTest");

        // open main page
        WelcomePageObject welcomePage = new WelcomePageObject(driver, log);
        welcomePage.openPage();

        // Click on WYSIWYG Editor link
        EditorPageObject editorPageObject = welcomePage.clickEditorPageLink();

        // Get default editor text
        String editorText = editorPageObject.getEditorText();

        // Verification that new page contains expected text in source
        Assert.assertTrue(editorText.equals("Your content goes here."),
                "Editor default text is not expected. It is: " + editorText);
    }
}