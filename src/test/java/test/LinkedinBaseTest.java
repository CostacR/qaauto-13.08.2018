package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import page.LinkedinLoginPage;

/**
 * Base test Page
 * Contains start and finish methods of testing
 * Initializes linkedinLoginPage and WebDriver
 */
public class LinkedinBaseTest {

    WebDriver driver;
    LinkedinLoginPage linkedinLoginPage;

    @BeforeMethod
    public void beforeMethod() {
        driver = new ChromeDriver();
        driver.get("https://www.linkedin.com/");
        linkedinLoginPage = new LinkedinLoginPage(driver);
    }

    @AfterMethod
    public void afterMethod (){
//        driver.quit();
    }
}
