package page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static java.lang.Thread.sleep;

/**
 *
 */
public class LinkedinHomePage extends LinkedinBasePage{

    @FindBy (xpath = "//li[@id='profile-nav-item']")
    private WebElement profileNavItem;

    @FindBy (xpath = "//input[@id='login-submit']")
    private WebElement signInButton;

    @FindBy (xpath = "//button[@id='nav-settings__dropdown-trigger']")
    private WebElement buttonNavProfile;

    @FindBy (xpath = "//a[@href='/m/logout/']")
    private WebElement buttonLogOut;

    @FindBy (xpath = "//input[@placeholder and @role='combobox']")
    private WebElement searchField;

    public LinkedinHomePage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isPageLoaded() {
        return getCurrentUrl().equals("https://www.linkedin.com/feed/")
                && getCurrentTitle().contains("LinkedIn")
                && profileNavItem.isDisplayed();
    }

    public boolean isLogOutButtonAble() {//проверка кнопки LogOut
        buttonNavProfile.click();

        return buttonLogOut.isDisplayed();
    }

    public LinkedinLoginPage isLogOutButtonClick() {//проверка кнопки LogOut
        buttonNavProfile.click();
         buttonLogOut.click();
         return new LinkedinLoginPage(driver);
    }

    public LinkedinSearchPage search(String searchItem)   {
        searchField.sendKeys(searchItem);
        searchField.sendKeys(Keys.ENTER);


        try {
            sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new LinkedinSearchPage(driver);
    }

}
