import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LinkedInPasswordResetTest extends LinkedinBasePage{
    WebDriver driver;
    LinkedinLoginPage linkedinLoginPage;
    @BeforeMethod
    public void beforeMethod() {
        driver = new ChromeDriver();
        driver.get("https://www.linkedin.com/");
        linkedinLoginPage = new LinkedinLoginPage(driver);
    }
    @AfterMethod
    public void afterMethod() {
     //   driver.quit();
    }



    @Test
    public void passwordResetTest() {
        String userEmail = "nsczxfxthntq@gmail.com";
        String userNewPassword = "4838960w";

        Assert.assertTrue(linkedinLoginPage.isPageLoaded(), "Login page is not loaded.");
        LinkedInRequestPasswordResetPage linkedInResetPasswordFindAccountPage = linkedinLoginPage.resetLinkClick();

        Assert.assertTrue(linkedInResetPasswordFindAccountPage.isPageLoaded(), "Reset page is not loaded.");
        LinkedinNewPasswordPage linkedinNewPasswordPage = linkedInResetPasswordFindAccountPage.resetButton(userEmail);

        LinkedinPasswordSubmitPage linkedinPasswordSubmitPage = linkedinNewPasswordPage.newPassword(userNewPassword);
        Assert.assertTrue(linkedinNewPasswordPage.isPageLoaded(), "Choose new password page is not loaded.");
        LinkedinHomePage linkedinHomePage = linkedinPasswordSubmitPage.submitButtonClick();
        Assert.assertTrue(linkedinHomePage.isPageLoaded(),"Home page is not loaded.");


    }
}
