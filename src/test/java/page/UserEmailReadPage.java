package page;

import static java.lang.Thread.sleep;

public class UserEmailReadPage extends LinkedinBasePage {


    public LinkedinNewPasswordPage recoveryLinkClick() {
        try {
            sleep(120000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new LinkedinNewPasswordPage(driver);
    }
}