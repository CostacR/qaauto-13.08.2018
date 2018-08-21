import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static java.lang.Thread.sleep;

public class LinkedinLoginTest {

//    @Test
//    public void succesefullLoginTest() throws InterruptedException {
//        //navigate to linkedin.com
//        //Verify that login page is loade
//        //Enter user user email
//        //Enter user password
//        //click "Sing in' button
//        WebDriver driver = new ChromeDriver();
//        driver.get("https://www.linkedin.com/");
//        String titlePage = "Войти или зарегистрироваться";
//        String userEmail = "nsczxfxthntq@gmail.com";
//        String userPassword = "4838960q";
//        String userName = "Costa Jones";
//
//        Assert.assertEquals(driver.getCurrentUrl(), "https://www.linkedin.com/", "Page login URL is wrong!!!");
//        Assert.assertEquals(driver.getTitle(), "LinkedIn: Log In or Sign Up", "Login page Title is wrong");
//
//        WebElement userEmailField = driver.findElement(By.xpath("//input[@id='login-email']"));
//        WebElement userPasswordField =driver.findElement(By.xpath("//input[@id='login-password']"));
//        WebElement signInButton = driver.findElement(By.xpath("//input[@id='login-submit']"));
//
//        Assert.assertTrue(signInButton.isDisplayed(), "'Sign In' button is not displyed on Login Page(sting 35)");
//
//        userEmailField.sendKeys(userEmail);
//        userPasswordField.sendKeys(userPassword);
//        signInButton.click();
//
//        WebElement profileNavItem = driver.findElement(By.xpath("//li[@id='profile-nav-item']"));
//        Assert.assertTrue(profileNavItem.isDisplayed(), "'Profile-nav-item ' button is not displyed on Login Page(sting 46)");
//
//
//    Assert.assertEquals(driver.getCurrentUrl(), "https://www.linkedin.com/feed/", "Home page not loaded");
//    By userNameLocator = By.xpath("//a[@class='tap-target profile-rail-card__actor-link block link-without-hover-visited ember-view']/span");
//    WebElement userNameField = driver.findElement(userNameLocator);
//    Assert.assertEquals(userNameField.getText(), userName, "User name wrong");
//    }
//
//    @Test
//    public void negativeloginTest() throws InterruptedException {
//        WebDriver driver = new ChromeDriver();
//        driver.get("https://www.linkedin.com/");
//        String titlePage = "Войти или зарегист5рироваться";
//        String userEmailWrong = "aa@l.com";
//        String userPasswordWrong = "wrongPass";
//
//        Assert.assertEquals(driver.getCurrentUrl(), "https://www.linkedin.com/", "Page login URL is wrong!!!");
//        Assert.assertEquals(driver.getTitle(), "LinkedIn: Log In or Sign Up", "Login page Title is wrong");
//
//        WebElement userEmailField = driver.findElement(By.xpath("//input[@id='login-email']"));
//        WebElement userPasswordField =driver.findElement(By.xpath("//input[@id='login-password']"));
//        WebElement signInButton = driver.findElement(By.xpath("//input[@id='login-submit']"));
//
//        Assert.assertTrue(signInButton.isDisplayed(), "'Sign In' button is not displyed on Login Page(sting 35)");
//
//        userEmailField.sendKeys(userEmailWrong);
//        userPasswordField.sendKeys(userPasswordWrong);
//        signInButton.click();
//
//        try {
//            sleep(3000);
//        }catch (InterruptedException e){
//            e.printStackTrace();
//        }
//
//        WebElement alertMessage = driver.findElement(By.xpath("//div[@role='alert']"));
//        Assert.assertEquals(alertMessage.getText(), "There were one or more errors in your submission. Please correct the marked fields below.", "Alert not working");
//    }
//    @Test
//    public void negativeTestOneThousandSymbolsEmail(){
//        WebDriver driver = new ChromeDriver();
//        driver.get("https://www.linkedin.com/");
//        String titlePage = "Войти или зарегист5рироваться";
//        String userEmail = "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. Donec pede justo, fringilla vel, aliquet nec, vulputate eget, arcu. In enim justo, rhoncus ut, imperdiet a, venenatis vitae, justo. Nullam dictum felis eu pede mollis pretium. Integer tincidunt. Cras dapibus. Vivamus elementum semper nisi. Aenean vulputate eleifend tellus. Aenean leo ligula, porttitor eu, consequat vitae, eleifend ac, enim. Aliquam lorem ante, dapibus in, viverra quis, feugiat a, tellus. Phasellus viverra nulla ut metus varius laoreet. Quisque rutrum. Aenean imperdiet. Etiam ultricies nisi vel augue. Curabitur ullamcorper ultricies nisi. Nam eget dui. Etiam rhoncus. Maecenas tempus, tellus eget condimentum rhoncus, sem quam semper libero, sit amet adipiscing sem neque sed ipsum. N";
//        String userPassword = "wrongPass";
//        Assert.assertEquals(driver.getCurrentUrl(), "https://www.linkedin.com/", "Page login URL is wrong!!!");
//        Assert.assertEquals(driver.getTitle(), "LinkedIn: Log In or Sign Up", "Login page Title is wrong");
//
//        WebElement userEmailField = driver.findElement(By.xpath("//input[@id='login-email']"));
//        WebElement userPasswordField =driver.findElement(By.xpath("//input[@id='login-password']"));
//        WebElement signInButton = driver.findElement(By.xpath("//input[@id='login-submit']"));
//
//        Assert.assertTrue(signInButton.isDisplayed(), "'Sign In' button is not displyed on Login Page(sting 35)");
//
//        userEmailField.sendKeys(userEmail);
//        userPasswordField.sendKeys(userPassword);
//        signInButton.click();
//
//        try {
//            sleep(3000);
//        }catch (InterruptedException e){
//            e.printStackTrace();
//        }
//
//        WebElement alertMessage = driver.findElement(By.xpath("//div[@role='alert']"));
//        Assert.assertEquals(alertMessage.getText(), "There were one or more errors in your submission. Please correct the marked fields below.", "Alert not working");
//        WebElement alertLondLogin = driver.findElement(By.xpath("//*[@id='session_key-login-error']"));
//        Assert.assertEquals(alertLondLogin.getText(), "The text you provided is too long (the maximum length is 128 characters, your text contains 1,000 characters).", "Alert 'Long login not working");//проверка на максимальную длину логина
//    }

//    @Test
//    public void negativeTestOneThousandSymbolsPassword(){
//        WebDriver driver = new ChromeDriver();
//        driver.get("https://www.linkedin.com/");
//        String titlePage = "Войти или зарегист5рироваться";
//        String userEmail = "nsczxfxthntq@gmail.com";
//        String userPassword = "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. Donec pede justo, fringilla vel, aliquet nec, vulputate eget, arcu. In enim justo, rhoncus ut, imperdiet a, venenatis vitae, justo. Nullam dictum felis eu pede mollis pretium. Integer tincidunt. Cras dapibus. Vivamus elementum semper nisi. Aenean vulputate eleifend tellus. Aenean leo ligula, porttitor eu, consequat vitae, eleifend ac, enim. Aliquam lorem ante, dapibus in, viverra quis, feugiat a, tellus. Phasellus viverra nulla ut metus varius laoreet. Quisque rutrum. Aenean imperdiet. Etiam ultricies nisi vel augue. Curabitur ullamcorper ultricies nisi. Nam eget dui. Etiam rhoncus. Maecenas tempus, tellus eget condimentum rhoncus, sem quam semper libero, sit amet adipiscing sem neque sed ipsum. N";
//        Assert.assertEquals(driver.getCurrentUrl(), "https://www.linkedin.com/", "Page login URL is wrong!!!");
//        Assert.assertEquals(driver.getTitle(), "LinkedIn: Log In or Sign Up", "Login page Title is wrong");
//
//        WebElement userEmailField = driver.findElement(By.xpath("//input[@id='login-email']"));
//        WebElement userPasswordField =driver.findElement(By.xpath("//input[@id='login-password']"));
//        WebElement signInButton = driver.findElement(By.xpath("//input[@id='login-submit']"));
//
//        Assert.assertTrue(signInButton.isDisplayed(), "'Sign In' button is not displyed on Login Page(sting 35)");
//
//        userEmailField.sendKeys(userEmail);
//        userPasswordField.sendKeys(userPassword);
//        signInButton.click();
//
//        try {
//            sleep(3000);
//        }catch (InterruptedException e){
//            e.printStackTrace();
//        }
//
//        WebElement alertMessage = driver.findElement(By.xpath("//div[@role='alert']"));
//        Assert.assertEquals(alertMessage.getText(), "There were one or more errors in your submission. Please correct the marked fields below.", "Alert not working");
//        WebElement alertLondLogin = driver.findElement(By.xpath("//*[@id='session_password-login-error']"));
//        Assert.assertEquals(alertLondLogin.getText(), "The password you provided must have at most 400 characters.", "Alert 'Long login not working");//проверка на максимальную длину пароля
//    }
//    @Test
//    public void negativeTestNoEmail(){
//        WebDriver driver = new ChromeDriver();
//        driver.get("https://www.linkedin.com/");
//        String titlePage = "Войти или зарегист5рироваться";
//        String userEmail = "";
//        String userPassword = "4838960q";
//        Assert.assertEquals(driver.getCurrentUrl(), "https://www.linkedin.com/", "Page login URL is wrong!!!");
//        Assert.assertEquals(driver.getTitle(), "LinkedIn: Log In or Sign Up", "Login page Title is wrong");
//        WebElement userEmailField = driver.findElement(By.xpath("//input[@id='login-email']"));
//        WebElement userPasswordField =driver.findElement(By.xpath("//input[@id='login-password']"));
//        WebElement signInButton = driver.findElement(By.xpath("//input[@id='login-submit']"));
//        Assert.assertTrue(signInButton.isDisplayed(), "'Sign In' button is enabled");//кнопка не активна при отсутствии емейла
//        userEmailField.sendKeys(userEmail);
//        userPasswordField.sendKeys(userPassword);
//        signInButton.click();
//        try {
//            sleep(3000);
//        }catch (InterruptedException e){
//            e.printStackTrace();       }
//        WebElement alertMessage = driver.findElement(By.xpath("//div[@role='alert']"));
//        Assert.assertTrue(alertMessage.isEnabled(), "Alert message is visible. This is wrong!");
//    }


    @Test
    public void negativeTestNoPassword(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.linkedin.com/");
        String userEmail = "nsczxfxthntq@gmail.com";
        String userPassword = "";
            Assert.assertEquals(driver.getCurrentUrl(), "https://www.linkedin.com/", "Page login URL is wrong!!!");
            Assert.assertEquals(driver.getTitle(), "LinkedIn: Log In or Sign Up", "Login page Title is wrong");
        WebElement userEmailField = driver.findElement(By.xpath("//input[@id='login-email']"));
        WebElement userPasswordField =driver.findElement(By.xpath("//input[@id='login-password']"));
        WebElement signInButton = driver.findElement(By.xpath("//input[@id='login-submit']"));
            Assert.assertTrue(signInButton.isDisplayed(), "'Sign In' button is enabled");//кнопка не активна при отсутствии емейла
            userEmailField.sendKeys(userEmail);
            userPasswordField.sendKeys(userPassword);
            signInButton.click();
            try {
            sleep(3000);
        }catch (InterruptedException e){
            e.printStackTrace();       }
        WebElement alertMessage = driver.findElement(By.xpath("//div[@role='alert']"));
            Assert.assertTrue(alertMessage.isEnabled(), "Alert message is visible. This is wrong!");
    }
//    @Test
//    public void negativeTest(){
//
//    }

 }