import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import static com.sun.corba.se.impl.util.Utility.printStackTrace;
import static java.lang.Thread.sleep;

public class LinkedInLoginPage {
    private WebDriver driver;
    private WebElement signInButton;
    private WebElement userEmailField;
    private WebElement userPasswordField;


    public LinkedInLoginPage(WebDriver driver){
        this.driver=driver;
        initElements();
    }

    private void initElements(){
        userEmailField = driver.findElement(By.xpath("//input[@id='login-email']"));
        userPasswordField = driver.findElement(By.xpath("//input[@id='login-password']"));
        signInButton = driver.findElement(By.xpath("//input[@id='login-submit']"));
    }

    public String getCurrentUrl(){

        return driver.getCurrentUrl();
    }

    public String getCurrentTitle(){
        return  driver.getTitle();
    }

    public boolean isPageLoaded(){
        return getCurrentUrl().equals("https://www.linkedin.com/")
                && getCurrentTitle().equals("LinkedIn: Log In or Sign Up")
                && signInButton.isDisplayed()
                ;
    }

    public void login(String userEmail, String userPassword){
        userEmailField.sendKeys(userEmail);
        userPasswordField.sendKeys(userPassword);
        signInButton.click();
        try {
            sleep(3000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
    public boolean isLoginCorrectEntered(String userEmail) {
        return  !userEmail.equals("");
    }
    public boolean isPasswordCorrectEntered(String userPassword) {

        return !userPassword.equals("");
    }
}
