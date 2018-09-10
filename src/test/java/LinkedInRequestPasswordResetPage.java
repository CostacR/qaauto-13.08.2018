import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static java.lang.Thread.sleep;

public class LinkedInRequestPasswordResetPage extends LinkedinBasePage{

    @FindBy (xpath = "//input[@id='username']")
    private WebElement userEmailField;

    @FindBy(xpath ="//a[@class='nav__button--signin']")
    private WebElement signInButton;

    public LinkedInRequestPasswordResetPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

        public boolean isPageLoaded() {
        return getCurrentUrl().contains("/request-password-reset")
                && getCurrentTitle().contains("LinkedIn")
                && signInButton.isDisplayed()
                ;}

    public LinkedinNewPasswordPage resetButton(String userEmail) {
        userEmailField.sendKeys(userEmail);
        userEmailField.sendKeys(Keys.ENTER);
        try {
            sleep(120000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new LinkedinNewPasswordPage(driver);
    }
}
