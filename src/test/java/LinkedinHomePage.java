import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LinkedinHomePage {
    private WebDriver driver;
    private WebElement profileNavItem;
    private WebElement signInButton;



    public LinkedinHomePage(WebDriver driver) {
        this.driver=driver;
        initElements();
    }

    //добавить проверку вызова кнопки "Log Out"
    //применить метод Page Factory
    private void initElements(){
         profileNavItem = driver.findElement(By.xpath("//li[@id='profile-nav-item']"));
//        signInButton = driver.findElement(By.xpath("//input[@id='login-submit']"));


    }
    public String getCurrentUrl(){

        return driver.getCurrentUrl();
    }

    public String getCurrentTitle(){
        return  driver.getTitle();
    }

    public boolean isPageLoaded(){
        return getCurrentUrl().equals("https://www.linkedin.com/feed/")
                && getCurrentTitle().equals("LinkedIn")
//                && signInButton.isDisplayed()
                ;
    }

}
