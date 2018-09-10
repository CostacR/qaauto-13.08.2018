import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static java.lang.Thread.sleep;

public class LinkedinLoginPage extends LinkedinBasePage{

    @FindBy(xpath = "//input[@id='login-email']")//аннотация заменяет initElements
    private WebElement userEmailField;

    @FindBy(xpath = "//input[@id='login-password']")
    private WebElement userPasswordField;

    @FindBy(xpath ="//input[@id='login-submit']")
    private WebElement signInButton;

    @FindBy (xpath = "//a[@class='link-forgot-password']")
    private WebElement fogotPasswordLink;

    public LinkedinLoginPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);                                                   //this - текущий. Вычитать локаторы из елементов FindBy
//        PageFactory.initElements(driver, LinkedinHomePage.class);                                     //вичитывает аннотации из LoginHomePage
    }                                                                                                   //таблица соответствий (название / тип локатора/ локатор)

    public boolean isPageLoaded() {
         return getCurrentUrl().equals("https://www.linkedin.com/")
                && getCurrentTitle().contains("LinkedIn: Log In or Sign Up")
                && signInButton.isDisplayed()
                ;}

    public <T> T login(String userEmail, String userPassword) {
        userEmailField.sendKeys(userEmail);
        userPasswordField.sendKeys(userPassword);
        signInButton.click();
        try {
            sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (getCurrentUrl().contains("/feed")) {
            return (T) new LinkedinHomePage(driver);
        }

        if (getCurrentUrl().contains("/login-submit")) {
            return (T) new LinkedinLoginSubmitPage(driver);
        }
        else {
            return (T) new LinkedinLoginPage(driver);
//            return (T) this                                                           //другие варианеты записи
//            return (T) PageFactory.initElements(driver, LinkedinLoginPage.class);     //другие варианеты записи
        }
    }

    public boolean isLoginCorrectEntered(String userEmail) {
        return  !userEmail.equals("");
    }
    public boolean isPasswordCorrectEntered(String userPassword) {

        return !userPassword.equals("");
    }

    public LinkedInRequestPasswordResetPage resetLinkClick() {
        fogotPasswordLink.click();
        return new LinkedInRequestPasswordResetPage(driver);
    }
}
