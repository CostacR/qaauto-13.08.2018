import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class LinkedinPasswordSubmitPage extends LinkedinBasePage{
    public LinkedinPasswordSubmitPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public LinkedinHomePage submitButtonClick() {

        return new LinkedinHomePage(driver);
    }
}
