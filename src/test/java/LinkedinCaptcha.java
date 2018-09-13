import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.LinkedinBasePage;
import page.UserEmailReadPage;

import static java.lang.Thread.sleep;

public class LinkedinCaptcha extends LinkedinBasePage {

    @FindBy (xpath = "//*[@id='recaptcha-anchor']/div[5]")
    //div[@class='recaptcha-checkbox-checkmark']
    WebElement captcha;


    public UserEmailReadPage captchaClick() {
        try {
            sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //  captcha.click();

        return new UserEmailReadPage();
    }
}