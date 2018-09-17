package page;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Page Object class for LinkedInRequestPasswordResetPage, verify user email and seeking a letter from LinkedIn with reset link
 */
public class LinkedInRequestPasswordResetPage extends LinkedinBasePage {

    @FindBy (xpath = "//input[@id='username']")
    private WebElement userEmailField;

    @FindBy(xpath ="//a[@class='nav__button--signin']")
    private WebElement signInButton;

    /**
     * Method verify is Page loaded (true/false)
     * @param driver
     */
    public LinkedInRequestPasswordResetPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

        public boolean isPageLoaded() {
        return getCurrentUrl().contains("/request-password-reset")
                && getCurrentTitle().contains("LinkedIn")
                && signInButton.isDisplayed()
                ;}

    /**
     * Method receives the contents of the letter from the user email
     * Find in letter reset link
     * @param userEmail
     * @return new PasswordPage
     */
    public LinkedinNewPasswordPage navigateToLinkFromEmail(String userEmail) {
        //
        gMailService.connect();

        userEmailField.sendKeys(userEmail);
        userEmailField.sendKeys(Keys.ENTER);
                String messageSubject = "данное сообщение содержит ссылку для изменения пароля";
                String messageTo = "nsczxfxthntq@gmail.com";
                String messageFrom = "security-noreply@linkedin.com";

                String message = gMailService.waitMessage(messageSubject, messageTo, messageFrom, 120);
                System.out.println("Content: " + message);
                System.out.println(" ");

                String resetPasswordLink=
                        StringUtils.substringBetween(message,
                        "Чтобы изменить пароль в LinkedIn, нажмите, click <a href=\"",
                        "\" style").replace("amp", "");
                System.out.println(resetPasswordLink);
                driver.get(resetPasswordLink);

        return new LinkedinNewPasswordPage(driver);
    }
    }
