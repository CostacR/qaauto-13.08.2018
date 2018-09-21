package page;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * LinkedinLogin Page Object class.
 *
 */
public class LinkedinLoginPage extends LinkedinBasePage{

    @FindBy(xpath = "//input[@id='login-email']")//аннотация заменяет initElements
    private WebElement userEmailField;

    @FindBy(xpath = "//input[@id='login-password']")
    private WebElement userPasswordField;

    @FindBy(xpath ="//input[@id='login-submit']")
    private WebElement signInButton;

    @FindBy (xpath = "//a[@class='link-forgot-password']")
    private WebElement fogotPasswordLink;

    /**
     * Constructor for LinkedinLoginPage.
     *
     * @param driver - driver instance from tests.
     */
    public LinkedinLoginPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
//        assertElementIsVisible(signInButton, 5, "Login page is not loaded.");
    //this - текущий. Вычитать локаторы из елементов FindBy
//        PageFactory.initElements(driver, page.LinkedinHomePage.class);                                     //вичитывает аннотации из LoginHomePage
    }                                                                                                   //таблица соответствий (название / тип локатора/ локатор)

    public boolean isPageLoaded() {
         return getCurrentUrl().equals("https://www.linkedin.com/")
                && getCurrentTitle().contains("LinkedIn: Log In or Sign Up")
                && signInButton.isDisplayed()
                ;}

    /**
     * User login by username/password.
     * @param userEmail - String with userEmail. (user email (login) for enter to Linkedin.com)
     * @param userPassword - String with password. (user password for enter to Linkedin.com)
     * @param <T> generic type to return different PageObjects.
     * @return - on of corresponding PageObjects LinkedinHomePage/LinkedinLoginSubmitPage/LinkedinLoginPage
     */
    public <T> T login(String userEmail, String userPassword) {
        userEmailField.sendKeys(userEmail);
        userPasswordField.sendKeys(userPassword);
        signInButton.click();

        if (isUrlContains("/feed", 5)) {
            return (T) new LinkedinHomePage(driver);
        }

        if (isUrlContains("/login-submit",5)) {
            return (T) new LinkedinLoginSubmitPage(driver);
        }
        else {
            return (T) new LinkedinLoginPage(driver);
//            return (T) this                                                           //другие варианеты записи
//            return (T) PageFactory.initElements(driver, page.LinkedinLoginPage.class);     //другие варианеты записи
        }
    }

    public LinkedInRequestPasswordResetPage resetLinkClick() {
        fogotPasswordLink.click();
        return new LinkedInRequestPasswordResetPage(driver);
    }
}
