package test;


import org.testng.Assert;

import org.testng.annotations.Test;
import page.*;

public class LinkedInPasswordResetTest extends  LinkedinBaseTest{

    @Test
    public void passwordResetTest() {
        String userEmail = "nsczxfxthntq@gmail.com";
//        String userEmail = "tim.banxy@gmail.com";
        String userNewPassword = "4838960w";


        Assert.assertTrue(linkedinLoginPage.isPageLoaded(), "Login page is not loaded.");

        LinkedInRequestPasswordResetPage linkedInRequestPasswordResetPage = linkedinLoginPage.resetLinkClick();
        Assert.assertTrue(linkedInRequestPasswordResetPage.isPageLoaded(), "Reset page is not loaded.");

        LinkedinNewPasswordPage linkedinNewPasswordPage = linkedInRequestPasswordResetPage.resetButton(userEmail);
        LinkedinPasswordSubmitPage linkedinPasswordSubmitPage = linkedinNewPasswordPage.newPassword(userNewPassword);
        Assert.assertTrue(linkedinNewPasswordPage.isPageLoaded(), "Choose new password page is not loaded.");

        LinkedinHomePage linkedinHomePage = linkedinPasswordSubmitPage.submitButtonClick();
        Assert.assertTrue(linkedinHomePage.isPageLoaded(),"Home page is not loaded.");
        Assert.assertTrue(linkedinHomePage.isLogOutButtonAble(), "LogOut not working");

        LinkedinLoginPage linkedinLoginPage = linkedinHomePage.isLogOutButtonClick();
        linkedinLoginPage.login(userEmail,userNewPassword);
        Assert.assertTrue(linkedinHomePage.isPageLoaded(),"Home page is not loaded.");
        Assert.assertTrue(linkedinHomePage.isLogOutButtonAble(), "LogOut not working");

    }
}
