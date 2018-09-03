import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

    public class LinkedinLoginSubmitPage extends LinkedinBasePage{
        @FindBy (xpath = "//*[@id=\"control_gen_1\"]")
        private WebElement alertMessage;

        @FindBy (xpath = "//span[@id='session_key-login-error']")
        private WebElement userEmailAlert;

        @FindBy (xpath = "//span[@id='session_password-login-error']")
        private WebElement userPasswordAlert;

        public LinkedinLoginSubmitPage (WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

        public boolean isAlertMessageEmailVisible(String alertMessageEmail){
        return getCurrentUrl().equals("https://www.linkedin.com/uas/login-submit")
                    && getCurrentTitle().equals("Sign In to LinkedIn")
                    && userEmailAlert.equals(alertMessageEmail);
                        }
        public boolean isAlertMessagePasswordVisible(String alertMessagePassword){
            return getCurrentUrl().equals("https://www.linkedin.com/uas/login-submit")
                    && getCurrentTitle().equals("Sign In to LinkedIn")
                    && userPasswordAlert.equals(alertMessagePassword);
        }

        public String getAlertMessageText() {
            return alertMessage.getText();
        }

        public String getUserEmailAlertMessageText() {
            return userEmailAlert.getText();
        }

        public String getUserPasswordAlertMessageText() {
            return userPasswordAlert.getText();        }
    }
