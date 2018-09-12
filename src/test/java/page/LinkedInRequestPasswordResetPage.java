package page;

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

    public LinkedinNewPasswordPage resetButton(String userEmail) {
        GMailService gMailService = new GMailService();
        gMailService.connect();

        userEmailField.sendKeys(userEmail);
        userEmailField.sendKeys(Keys.ENTER);

        String messageSubject = "данное сообщение содержит ссылку для изменения пароля";
        String messageTo = "nsczxfxthntq@gmail.com";
        String messageFrom = "security-noreply@linkedin.com";


        String message = gMailService.waitMessage(messageSubject, messageTo, messageFrom, 120);
        System.out.println("Content: " + message);
        System.out.println(" ");
        System.out.println("Link: "+messageSearchResetLink(message));
        messageSearchResetLink(message);
        driver.get(messageSearchResetLink(message));

        try {
            sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new LinkedinNewPasswordPage(driver);
    }
    public String messageSearchResetLink(String message){

        String correctLink;
        String correctLinkStartPoint;
        String correctLinkEndPoint;

        int startPoint = message.indexOf("Чтобы изменить пароль в LinkedIn, нажмите")+51;
        correctLinkStartPoint = message.substring(startPoint, startPoint+700);
        int endPoint = correctLinkStartPoint.indexOf("style=");
        correctLinkEndPoint = message.substring(startPoint, startPoint+endPoint);
        correctLink = correctLinkEndPoint;

        return correctLink;


    }
}
