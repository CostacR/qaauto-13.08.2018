import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LinkedinHomePage {
    private WebDriver driver;
    @FindBy (xpath = "//li[@id='profile-nav-item']")
    private WebElement profileNavItem;

    @FindBy (xpath = "//input[@id='login-submit']")
    private WebElement signInButton;

    @FindBy (xpath = "//button[@id='nav-settings__dropdown-trigger']")
    WebElement buttonNavProfile;

    @FindBy (xpath = "//a[@href='/m/logout/']")
    WebElement buttonLogOut;

    public LinkedinHomePage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    //добавить проверку вызова кнопки "Log Out"
    public String getCurrentUrl(){

        return driver.getCurrentUrl();
    }

    public String getCurrentTitle(){
        return  driver.getTitle();
    }

    public boolean isPageLoaded(){
        return getCurrentUrl().equals("https://www.linkedin.com/feed/")
                && getCurrentTitle().equals("LinkedIn")
//                && signInButton.isDisplayed()
                ;
    }

    public boolean isLogOutButtonAble() {
        buttonNavProfile.click();
        return buttonLogOut.isDisplayed();
    }

}
