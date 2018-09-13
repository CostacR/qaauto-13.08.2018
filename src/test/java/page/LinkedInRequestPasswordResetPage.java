package page;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.GMailService;

import static java.lang.Thread.sleep;

public class LinkedInRequestPasswordResetPage extends LinkedinBasePage {

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
//    public boolean isMessageContainsLink(String message, String correctLink) {
//        return  message.contains(correctLink)
//                && correctLink.contains("security_password_reset_checkpoint")
//                ;
//    }

    public LinkedinNewPasswordPage navigateToLinkFromEmail(String userEmail) {
        //
        gMailService.connect();

        userEmailField.sendKeys(userEmail);
        userEmailField.sendKeys(Keys.ENTER);
                String messageSubject = "данное сообщение содержит ссылку для изменения пароля";
        String messageTo = "nsczxfxthntq@gmail.com";
        String messageFrom = "security-noreply@linkedin.com";

                String message = gMailService.waitMessage(messageSubject, messageTo, messageFrom, 120);

                String resetPasswordLink=
                        StringUtils.substringBetween(message,
                        "Чтобы изменить пароль в LinkedIn, нажмите, click <a href=\"",
                        "\" style").replace("amp", "");
        messageSearchResetLink(message);



//
//        String message = gMailService.waitMessage(messageSubject, messageTo, messageFrom, 120);
////        System.out.println("Content: " + message);
////        System.out.println(" ");
////        System.out.println("Link: "+messageSearchResetLink(message));
//
//        try {
//            sleep(20000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        return new LinkedinNewPasswordPage(driver);
    }
    public String messageSearchResetLink(String message){

        String correctLink;
        String correctLinkStartPoint;
        String correctLinkEndPoint;

        int startPoint = message.indexOf("Чтобы изменить пароль в LinkedIn, нажмите")+51;
        System.out.println(startPoint);
        correctLinkStartPoint = message.substring(startPoint, message.length());
        int endPoint = correctLinkStartPoint.indexOf(" style=")-1;
        correctLinkEndPoint = message.substring(startPoint, startPoint+endPoint);
        correctLink = correctLinkEndPoint.replace("&amp;","&");
        System.out.println("Message lenth "+message.length());

        System.out.println("Start point "+startPoint);
        System.out.println("End point "+endPoint);


        try {
            sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.get(correctLink);

        try {
            sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return correctLink;
    }



}
