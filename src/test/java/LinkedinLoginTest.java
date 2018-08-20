import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static java.lang.Thread.sleep;

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
        String titlePage = "Войти или зарегистрироваться";
        String userEmail = "nsczxfxthntq@gmail.com";
        String userPassword = "4838960q";
        String userName = "Costa Jones";

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.linkedin.com/", "Page login URL is wrong!!!");
        Assert.assertEquals(driver.getTitle(), "LinkedIn: Log In or Sign Up", "Login page Title is wrong");

        WebElement userEmailField = driver.findElement(By.xpath("//input[@id='login-email']"));
        WebElement userPasswordField =driver.findElement(By.xpath("//input[@id='login-password']"));
        WebElement signInButton = driver.findElement(By.xpath("//input[@id='login-submit']"));

        Assert.assertTrue(signInButton.isDisplayed(), "'Sign In' button is not displyed on Login Page(sting 35)");

        userEmailField.sendKeys(userEmail);
        userPasswordField.sendKeys(userPassword);
        signInButton.click();

        WebElement profileNavItem = driver.findElement(By.xpath("//li[@id='profile-nav-item']"));
        Assert.assertTrue(profileNavItem.isDisplayed(), "'Profile-nav-item ' button is not displyed on Login Page(sting 46)");


    Assert.assertEquals(driver.getCurrentUrl(), "https://www.linkedin.com/feed/", "Home page not loaded");
    By userNameLocator = By.xpath("//a[@class='tap-target profile-rail-card__actor-link block link-without-hover-visited ember-view']/span");
    WebElement userNameField = driver.findElement(userNameLocator);
    Assert.assertEquals(userNameField.getText(), userName, "User name wrong");
    }

    @Test
    public void negativeloginTest() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.linkedin.com/");
        String titlePage = "Войти или зарегист5рироваться";
        String userEmailWrong = "aa@l.com";
        String userPasswordWrong = "wrongPass";

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.linkedin.com/", "Page login URL is wrong!!!");
        Assert.assertEquals(driver.getTitle(), "LinkedIn: Log In or Sign Up", "Login page Title is wrong");

        WebElement userEmailField = driver.findElement(By.xpath("//input[@id='login-email']"));
        WebElement userPasswordField =driver.findElement(By.xpath("//input[@id='login-password']"));
        WebElement signInButton = driver.findElement(By.xpath("//input[@id='login-submit']"));

        Assert.assertTrue(signInButton.isDisplayed(), "'Sign In' button is not displyed on Login Page(sting 35)");

        userEmailField.sendKeys(userEmailWrong);
        userPasswordField.sendKeys(userPasswordWrong);
        signInButton.click();

        try {
            sleep(3000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        WebElement alertMessage = driver.findElement(By.xpath("//div[@role='alert']"));
        Assert.assertEquals(alertMessage.getText(), "There were one or more errors in your submission. Please correct the marked fields below.", "Alert not working");

    }
 }