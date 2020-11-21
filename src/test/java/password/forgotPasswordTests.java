package password;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.EmailSentPage;
import pages.ForgotPasswordPage;

import static org.testng.Assert.assertEquals;

// This is an exercise - implemented by me
public class forgotPasswordTests extends BaseTest {

    @Test
    public void testResetPassword() {
        ForgotPasswordPage forgotPasswordPage = homePage.clickForgotPassword();
        forgotPasswordPage.enterEmail("test@test.test");
        EmailSentPage emailSentPage = forgotPasswordPage.clickButton();
        assertEquals(emailSentPage.getContent(),
                "Your e-mail's been sent!",
                "Message is incorrect!");
    }
}
