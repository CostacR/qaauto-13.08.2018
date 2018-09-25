package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.*;
import page.LinkedinLoginPage;

/**
 * Base test Page
 * Contains start and finish methods of testing
 * Initializes linkedinLoginPage and WebDriver
 */
public class LinkedinBaseTest {
    WebDriver driver;
    LinkedinLoginPage linkedinLoginPage;

//    String browserChrome = "chrome";
//    String browserFireFox = "firefox";
//    String browserIE = "IE";
//    String browserCurrent = browserChrome;

    @Parameters({"browserName", "urLink"})
    @BeforeMethod
    public void beforeMethod(@Optional("chrome") String browserName,
                            @Optional ("https://ua.linkedin.com/") String urLink) throws Exception {

        switch (browserName.toLowerCase()){
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            break;

            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            break;
            case "ie":
                WebDriverManager.iedriver().setup();
                driver = new InternetExplorerDriver();
            break;
            default:
                throw new Exception("browser "+browserName+" is not supported") ;
        }

        driver.get(urLink);
        linkedinLoginPage = new LinkedinLoginPage(driver);
    }

    @AfterMethod //(alwaysRun = true)
    public void afterMethod (){
//        driver.quit();
    }
}
