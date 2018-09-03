import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static java.lang.Thread.sleep;

public class LinkedinTest {
    WebDriver driver;

    @BeforeMethod
    public void beforeMethod(){
        driver = new ChromeDriver();
        driver.get("https://www.linkedin.com/");
    }
    @AfterMethod
    public void afterMethod (){
      //  driver.quit();
    }
    @DataProvider
    public Object[][] validDataProvider() {
        return new Object[][]{
//              {"email", "password", "alertMessageEmail", "alertMessagePassword"}
                { "nsczxfxthntq@gmail.com", "4838960q", "", "" },
//                { "Nsczxfxthntq@gmail.com", "4838960q", "", "" },
//                { "nsczxfxthntq@gmail.COM", "4838960q", "", "" },
        };
    }
    @DataProvider
    public Object[][] emptyDataProvider() {
        return new Object[][]{
//              {"email", "password", "alertMessageEmail", "alertMessagePassword"}
                { "", "4838960q", "", "" },
                { "nsczxfxthntq@gmail.com", "", "", "" },
                { "", "", "", "" },
        };
    }
    @DataProvider
    public Object[][] wrongDataProvider() {
        return new Object[][]{
//              {"email", "password", "alertMessageEmail", "alertMessagePassword"}
                { "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. Donec pede justo, fringilla vel, aliquet nec, vulputate eget, arcu. In enim justo, rhoncus ut, imperdiet a, venenatis vitae, justo. Nullam dictum felis eu pede mollis pretium. Integer tincidunt. Cras dapibus. Vivamus elementum semper nisi. Aenean vulputate eleifend tellus. Aenean leo ligula, porttitor eu, consequat vitae, eleifend ac, enim. Aliquam lorem ante, dapibus in, viverra quis, feugiat a, tellus. Phasellus viverra nulla ut metus varius laoreet. Quisque rutrum. Aenean imperdiet. Etiam ultricies nisi vel augue. Curabitur ullamcorper ultricies nisi. Nam eget dui. Etiam rhoncus. Maecenas tempus, tellus eget condimentum rhoncus, sem quam semper libero, sit amet adipiscing sem neque sed ipsum. N", "wrongpassword", "The text you provided is too long (the maximum length is 128 characters, your text contains 1,000 characters).", "" },
                { "a@b.com", "wrongpassword", "Hmm, that's not the right password. Please try again or", "" },
                { "nsczxfxthntq@gmail.com", "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. Donec pede justo, fringilla vel, aliquet nec, vulputate eget, arcu. In enim justo, rhoncus ut, imperdiet a, venenatis vitae, justo. Nullam dictum felis eu pede mollis pretium. Integer tincidunt. Cras dapibus. Vivamus elementum semper nisi. Aenean vulputate eleifend tellus. Aenean leo ligula, porttitor eu, consequat vitae, eleifend ac, enim. Aliquam lorem ante, dapibus in, viverra quis, feugiat a, tellus. Phasellus viverra nulla ut metus varius laoreet. Quisque rutrum. Aenean imperdiet. Etiam ultricies nisi vel augue. Curabitur ullamcorper ultricies nisi. Nam eget dui. Etiam rhoncus. Maecenas tempus, tellus eget condimentum rhoncus, sem quam semper libero, sit amet adipiscing sem neque sed ipsum. N", "", "The password you provided must have at most 400 characters." },
                { "nsczxfxthntq@gmail.com", "short", "", "The password you provided must have at least 6 characters." },
                { "nsczxfxgmail.com", "short", "Please enter a valid email address.", "The password you provided must have at least 6 characters." },
                { "nsczxfxthntq@gmail.com", "wrongPassword", "", "Hmm, that's not the right password. Please try again or" },
                { "nsczxfxthntq10000000000@gmail.com", "4838960q", "", "Hmm, that's not the right password. Please try again or" },
                { "nsczxfxthntqgmailcom", "4838960q", "Please enter a valid email address.", "" },
                { "12 ^#%$^&%^&^%&*&*(*&* ^567567567567", "4838960q", "Be sure to include \"+\" and your country code.", "" },
        };
    }

    @Test (dataProvider ="validDataProvider")
    public void successefulLoginTest(String userEmail, String userPassword, String alertMessageEmail, String alertMessagePassword) {
        LinkedInLoginPage linkedInLoginPage = new LinkedInLoginPage(driver);
        Assert.assertTrue(linkedInLoginPage.isPageLoaded(), "Login page is not loaded");
        linkedInLoginPage.login(userEmail, userPassword);

        LinkedinHomePage linkedinHomePage = new LinkedinHomePage(driver);
        Assert.assertTrue(linkedinHomePage.isLogOutButtonAble(),"'Log Out' button disable"); //проверка кнопки LogOut

    }

    @Test (dataProvider ="emptyDataProvider")
    public void emptyLoginPasswordTest(String userEmail, String userPassword, String alertMessageEmail, String alertMessagePassword){

        LinkedInLoginPage linkedInLoginPage = new LinkedInLoginPage(driver);
        Assert.assertTrue(linkedInLoginPage.isPageLoaded(), "Login page is not loaded");

        linkedInLoginPage  = linkedInLoginPage.login(userEmail, userPassword);
        Assert.assertTrue(linkedInLoginPage.isPageLoaded(), "Home page is not loaded");
    }
//method returns different Page Objects поискать в гугле

    @Test(dataProvider ="wrongDataProvider")
    public void negativeloginTest(String userEmail, String userPassword, String alertMessageEmail, String alertMessagePassword)   {
        LinkedInLoginPage linkedInLoginPage = new LinkedInLoginPage(driver);
        Assert.assertTrue(linkedInLoginPage.isPageLoaded(), "Login page is not loaded");
        linkedInLoginPage.login(userEmail, userPassword);

        LinkedinAlertPage linkedinAlertPage = new LinkedinAlertPage(driver);

        linkedinAlertPage.isAlertMessageEmailVisible(alertMessageEmail);
        linkedinAlertPage.isAlertMessagePasswordVisible(alertMessagePassword);
    }


    @Test(enabled = false)
    public void negativeNotValidEmailSpecialSymbolsWithAtTest(){
//        String userEmail = "12 ^#%$^&%^@&^%&*&*(*&* ^567567567567";
        String userEmail = "dasdasd@gmail.com";
//        String userEmail = "ЯЯЯ<a>ЯЯЯ";
        String userPassword = "dasdasd@gmail.com></form><script>alert();</script>";
        String alertMessage = "Sorry, we need you to reset your password as a security precaution.";

        LinkedInLoginPage linkedInLoginPage = new LinkedInLoginPage(driver);
        Assert.assertTrue(linkedInLoginPage.isPageLoaded(), "Login page is not loaded");

        linkedInLoginPage.login(userEmail, userPassword);

        LinkedinAlertPage linkedinAlertPage = new LinkedinAlertPage(driver);
        WebElement alertMessageLocator = driver.findElement(By.xpath("//*[@id='app__container']/div[1]/header"));
        Assert.assertEquals(alertMessageLocator.getText(), alertMessage, "XO-XO!!");
        System.out.println(alertMessageLocator.getText());
    }

    @Test (enabled = false)//повторная регистрация по
    public void repeatedRegistration()   {

        String userFirstName = "Costa";
        String userSecondName = "Jones";
        String userEmail = "nsczxfxthntq@gmail.com";
        String userPassword = "4838960q";

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.linkedin.com/", "Page login URL is wrong!!!");
        Assert.assertEquals(driver.getTitle(), "LinkedIn: Log In or Sign Up", "Login page Title is wrong");

        WebElement firstNameLocator = driver.findElement(By.xpath("//input[@id='reg-firstname']"));
        WebElement secondNameLocator = driver.findElement(By.xpath("//input[@id='reg-lastname']"));
        WebElement userEmailLocator = driver.findElement(By.xpath("//input[@id='reg-email']"));
        WebElement userPasswordLocator = driver.findElement(By.xpath("//input[@id='reg-password']"));
        WebElement registryButtonLoator = driver.findElement(By.xpath("//input[@id='registration-submit']"));

        firstNameLocator.sendKeys(userFirstName);
        secondNameLocator.sendKeys(userSecondName);
        userEmailLocator.sendKeys(userEmail);
        userPasswordLocator.sendKeys(userPassword);
        registryButtonLoator.click();

        try {
            sleep(3000);
        }catch (InterruptedException e){
            e.printStackTrace();       }

        WebElement alertSecondRegistryLocator = driver.findElement(By.className("hopscotch-content"));
        Assert.assertEquals(alertSecondRegistryLocator.getText(),"Someone's already using that email. If that’s you, enter your Email and password here to sign in.", "Second regisrty Alert not work");
        }


 }