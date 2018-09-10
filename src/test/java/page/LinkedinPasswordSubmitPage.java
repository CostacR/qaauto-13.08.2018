package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LinkedinPasswordSubmitPage extends LinkedinBasePage{
    @FindBy(xpath = "//*[@id='reset-password-submit-button']")
    private WebElement submitButton;

    public LinkedinPasswordSubmitPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public LinkedinHomePage submitButtonClick() {
        submitButton.click();
        return new LinkedinHomePage(driver);
    }
}
