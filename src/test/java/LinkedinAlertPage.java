import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

    public class LinkedinAlertPage {
        private WebDriver driver;
        @FindBy (xpath = "//span[@id='session_key-login-error']")
        private WebElement alertMessageLoginText;

        @FindBy (xpath = "//span[@id='session_password-login-error']")
        private WebElement alertMessagePasswordText;

    public LinkedinAlertPage (WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }
        public String getCurrentUrl(){

            return driver.getCurrentUrl();
        }

        public String getCurrentTitle(){
            return  driver.getTitle();
        }

    public boolean isAlertMessageEmailVisible(String alertMessageEmail){
        return getCurrentUrl().equals("https://www.linkedin.com/uas/login-submit")
                    && getCurrentTitle().equals("Sign In to LinkedIn")
                    && alertMessageLoginText.equals(alertMessageEmail);
                        }
        public boolean isAlertMessagePasswordVisible(String alertMessagePassword){
            return getCurrentUrl().equals("https://www.linkedin.com/uas/login-submit")
                    && getCurrentTitle().equals("Sign In to LinkedIn")
                    && alertMessagePasswordText.equals(alertMessagePassword);
        }
}
