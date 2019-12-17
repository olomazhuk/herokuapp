package com.herokuapp.theinternet.uploadtests;

import com.herokuapp.theinternet.pages.FileUploaderPageObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.TestUtilities;

public class UploadTests extends TestUtilities {

    @Test(dataProvider = "files")
    public void fileUploadTest(int number, String fileName) {
        log.info("Starting fileUploadTest №" + number);

        // open File Uploader Page
        FileUploaderPageObject fileUploaderPageObject = new FileUploaderPageObject(driver, log);
        fileUploaderPageObject.openPage();

        // Select file
        fileUploaderPageObject.selectFile(fileName);

        // Push upload button
        fileUploaderPageObject.pushUploadButton();

        // Get uploaded files
        String fileNames = fileUploaderPageObject.getUploadedFilesNames();

        // Verify selected file uploaded
        Assert.assertTrue(fileNames.contains(fileName),
                "Our file (" + fileName + ") is not one of the uploaded (" + fileNames + ")");
    }
}