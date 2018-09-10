import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LinkedinNewPasswordPage extends LinkedinBasePage {

    @FindBy (xpath = "//input[@id='newPassword']")
    private WebElement newPasswordField;
    @FindBy (xpath = "//input[@id='confirmPassword']")
    private WebElement confirmNewPassword;
    @FindBy (xpath = "//*[@id='app__container']/div[1]/header")
    private WebElement chooseNewPasswordText;

    public LinkedinNewPasswordPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public LinkedinPasswordSubmitPage newPassword(String userNewPassword) {
        newPasswordField.sendKeys(userNewPassword);
        confirmNewPassword.sendKeys(userNewPassword);
        confirmNewPassword.sendKeys(Keys.ENTER);

        return new LinkedinPasswordSubmitPage(driver);
    }


    public boolean isPageLoaded() {
        return getCurrentUrl().contains("reset/")
                && getCurrentTitle().contains("LinkedIn")
                && chooseNewPasswordText.getText().equals("Finally, choose a new password.");
    }

}
