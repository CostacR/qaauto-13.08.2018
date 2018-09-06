import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class LinkedInLoginScenarioTest extends LinkedinBasePage{
    WebDriver driver;
    LinkedinLoginPage linkedinLoginPage;

    @BeforeMethod
    public void beforeMethod(){
        driver = new ChromeDriver();
        driver.get("https://www.linkedin.com/");
        linkedinLoginPage = new LinkedinLoginPage(driver);
    }
    @AfterMethod
    public void afterMethod(){
//        driver.quit();
    }
    @DataProvider
    public Object[][] validDataProvider() {
        return new Object[][]{
//              {"email", "password", "searchItem"}
                { "nsczxfxthntq@gmail.com", "4838960q", "hr"},
        };
    }

    @Test (dataProvider ="validDataProvider")
    public void scenarioTest(String userEmail, String userPassword, String searchItem) throws InterruptedException {

        Assert.assertTrue(linkedinLoginPage.isPageLoaded(), "Login page is not loaded.");
        LinkedinHomePage linkedinHomePage = linkedinLoginPage.login(userEmail, userPassword);
        Assert.assertTrue(linkedinHomePage.isLogOutButtonAble(),"'Log Out' button disable"); //проверка кнопки LogOut

        LinkedinSearchPage linkedinSearchPage = linkedinHomePage.search(searchItem);
        Assert.assertTrue(linkedinSearchPage.isPageLoaded(), "Search page is not loaded");

//        Assert.assertEquals(linkedinSearchPage.getSearchResultsNumber(), 10, "Wrong number search results on SearchPage");
        Assert.assertEquals(linkedinSearchPage.searchSizeResult(), 10, "Wrong number search results on SearchPage");


        driver.manage().window().maximize();
        linkedinSearchPage.scrollDownPage();

        int count = linkedinSearchPage.searchSizeResult();
//        Assert.assertTrue(count==10,"Size numbers results is false");
        linkedinSearchPage.searchItemContainTest();
        Assert.assertTrue(linkedinSearchPage.isPageLoaded(), "Search title is wrong");
    }
}
