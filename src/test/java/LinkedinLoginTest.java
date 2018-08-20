import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class LinkedinLoginTest {

    @Test
    public void succesefullLoginTest() throws InterruptedException {
        //navigate to linkedin.com
        //Verify that login page is loade
        //Enter user user email
        //Enter user password
        //click "Sing in' button
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.linkedin.com/");
        String titlePage = "Войти или зарегист5рироваться";

        String userEmail = "nsczxfxthntq@gmail.com";
        String userPassword = "4838960q";
        String userName = "Costa Jo2nes";


        Assert.assertEquals(driver.getCurrentUrl(), "https://www.linkedin.com/", "Page login URL is wrong!!!");

        By titlePageLocator = By.xpath("//title[contains(text(),'LinkedIn: Войти или зарегистрироваться')]");
        By singInButtonLocator = By.xpath("//input[@id='login-submit']");
        By userEmailLocator = By.xpath("//*[@id='login-email']");
        By userPasswordLocator = By.xpath("//*[@id='login-password']");



        String titlePageText = titlePageLocator.toString();
        if (titlePageText.toLowerCase().contains(titlePage.toLowerCase()) == true) {
            System.out.println("Title page is correct");
        }else {
            System.out.println("Page Title is not correct!!!");
        }
        List<WebElement> listSingInButton = driver.findElements(singInButtonLocator);
        if (listSingInButton.size()==0){
            System.out.println("'Sing In' button is not found!!!");
        }
        else {
            WebElement singInButton = driver.findElement(singInButtonLocator);
            System.out.println("'Sing In' button is found");
            singInButton.click();
            }


    WebElement userEmailField = driver.findElement(userEmailLocator);
        userEmailField.click();
        userEmailField.clear();
        userEmailField.sendKeys(userEmail);

        WebElement userPasswordField = driver.findElement(userPasswordLocator);
        userPasswordField.click();
        userPasswordField.clear();
        userPasswordField.sendKeys(userPassword);

        WebElement singInButton = driver.findElement(singInButtonLocator);
        singInButton.click();

        driver.manage().window().maximize();
        Thread.sleep(5000);

//        By userNameLocator = By.xpath("//*[@id='ember2089']/span");
//        WebElement userName = driver.findElement(userNameLocator);
//        System.out.println(driver.findElement(userNameLocator).getText());
    Assert.assertEquals(driver.getCurrentUrl(), "https://www.linkedin.com/feed/", "Home page not loaded");
    By userNameLocator = By.xpath("//a[@class='tap-target profile-rail-card__actor-link block link-without-hover-visited ember-view']/span");
    WebElement userNameField = driver.findElement(userNameLocator);
    Assert.assertEquals(userNameField.getText(), userName, "User name wrong");
    }
 }