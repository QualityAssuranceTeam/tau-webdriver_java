package alerts;

import base.BaseTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class FileUploadTests extends BaseTest {

    @Test
    public void testFileUpload() {
        var uploadPage = homePage.clickFileUpload();
        uploadPage.uploadFile("resources/test_file_upload.txt");
        assertEquals(uploadPage.getUploadedFiles(),
                "test_file_upload.txt",
                "Uploaded file is not correct!");
    }
}
