package page;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.GMailService;

/**
 * Class initialize gMailServise
 */
public class LinkedinBasePage {

    protected WebDriver driver;
    protected static GMailService gMailService = new GMailService();

    /**
     *  Methods for verifications URL loaded pages
     * @return
     */
    protected String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
    protected WebElement waitUntilElementVisible (WebElement webElement, int timeOutInSec){ //ожидает когда вебэлемент будет видимым, после этого возвращает элемент
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSec);
        return wait.until(ExpectedConditions.visibilityOf(webElement));

    }
    protected void assertElementIsVisible (WebElement webElement, int timeOutInSec, String message){
        try {
        waitUntilElementVisible(webElement, timeOutInSec);
        }catch (TimeoutException e){
            throw new AssertionError(message);
        }

    }

    protected boolean isUrlContains(String partiaUrl, int timeOutInSec){//ожидает когда Url будет совпадать с заданым, после этого True/false
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSec);
        try {
            return wait.until(ExpectedConditions.urlContains(partiaUrl));
        }catch (TimeoutException e){
            return false;
        }



    }

    /**
     *  Methods for verifications title loaded pages
     * @return
     */
    protected String getCurrentTitle() {
        return driver.getTitle();
    }

    /**
     * waitUntilVisible - method wait until WebElements will visible
     * @param webElement
     * @param timeOutInSec
     * @return
     */

}
