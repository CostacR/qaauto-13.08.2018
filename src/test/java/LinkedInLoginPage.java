import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static java.lang.Thread.sleep;

public class LinkedInLoginPage {

    private WebDriver driver;

    @FindBy(xpath = "//input[@id='login-email']")//аннотация заменяет initElements
    private WebElement userEmailField;

    @FindBy(xpath = "//input[@id='login-password']")
    private WebElement userPasswordField;

    @FindBy(xpath ="//input[@id='login-submit']")
    private WebElement signInButton;


    public LinkedInLoginPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);//this - текущий. Вічитать локаторі из елементов ФиндБай
        //таблица соответствий (название / тип локатора/ локатор)
//        PageFactory.initElements(driver, LinkedinHomePage.class);//вичитывает аннотации из LoginHomePage
//        initElements();
    }

//    private void initElements(){
//        userEmailField = driver.findElement(By.xpath("//input[@id='login-email']"));
//        userPasswordField = driver.findElement(By.xpath("//input[@id='login-password']"));
//        signInButton = driver.findElement(By.xpath("//input[@id='login-submit']"));
//    }

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

    public <T> T login(String userEmail, String userPassword) {
        userEmailField.sendKeys(userEmail);
        userPasswordField.sendKeys(userPassword);
        signInButton.click();
        try {
            sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (getCurrentUrl().contains("/feed")) {
            return (T) new LinkedinHomePage(driver);
        }

        if (getCurrentUrl().contains("/login-submit")) {
            return (T) new LinkedinAlertPage(driver);
        }
        else {
            return (T) new LinkedInLoginPage(driver);
//            return (T) this                                                           //другие варианеты записи
//            return (T) PageFactory.initElements(driver, LinkedInLoginPage.class);     //другие варианеты записи
//


        }
    }



    public boolean isLoginCorrectEntered(String userEmail) {
        return  !userEmail.equals("");
    }

    public boolean isPasswordCorrectEntered(String userPassword) {

        return !userPassword.equals("");
    }
}
