import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LinkedinHomePage extends LinkedinBasePage{
    private WebDriver driver;

    @FindBy (xpath = "//li[@id='profile-nav-item']")
    private WebElement profileNavItem;

    @FindBy (xpath = "//input[@id='login-submit']")
    private WebElement signInButton;

    @FindBy (xpath = "//button[@id='nav-settings__dropdown-trigger']")
    private WebElement buttonNavProfile;

    @FindBy (xpath = "//a[@href='/m/logout/']")
    private WebElement buttonLogOut;

    @FindBy (xpath = "//input[@role='combobox']")
    private WebElement searchTextField;

    public LinkedinHomePage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isPageLoaded(){
        return getCurrentUrl().equals("https://www.linkedin.com/feed/")
                && getCurrentTitle().equals("LinkedIn")
//                && signInButton.isDisplayed()
                ;
    }

    public boolean isLogOutButtonAble() {//проверка кнопки LogOut
        buttonNavProfile.click();

        return buttonLogOut.isDisplayed();
    }

    public LinkedinSearchPage searchAndClick(String searchItem) {
        searchTextField.click();
        searchTextField.sendKeys(searchItem);
        searchTextField.sendKeys(Keys.ENTER);
        return new LinkedinSearchPage(driver);
    }

}
