import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import static com.sun.corba.se.impl.util.Utility.printStackTrace;
import static java.lang.Thread.sleep;

    public class LinkedinAlertPage {
        private WebDriver driver;
        public String alertMessage;
        private WebElement alertMessageText;

    public LinkedinAlertPage (WebDriver driver){
        this.driver=driver;
    }
        public String getCurrentUrl(){

            return driver.getCurrentUrl();
        }

        public String getCurrentTitle(){
            return  driver.getTitle();
        }

    public boolean isAlertMessageVisible(String alertMessage){
        alertMessageText = driver.findElement(By.xpath("//span[@id='session_password-login-error']"));
        return getCurrentUrl().equals("https://www.linkedin.com/uas/login-submit")
                    && getCurrentTitle().equals("Sign In to LinkedIn")
                    && alertMessageText.equals(alertMessage);
                        }

}
