import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class LinkedSearchTest extends LinkedinBasePage{
    WebDriver driver;
    LinkedinLoginPage linkedinLoginPage;
    @BeforeMethod
    public void beforeMethod() {
        driver = new ChromeDriver();
        driver.get("https://www.linkedin.com/");
        linkedinLoginPage = new LinkedinLoginPage(driver);
    }
    @AfterMethod
    public void afterMethod (){
        driver.quit();
    }
    @Test
    public void basicSearchTest(){
        String userEmail = "nsczxfxthntq@gmail.com";
        String userPassword = "4838960q";
        String serchTerm = "hr";

        Assert.assertTrue(linkedinLoginPage.isPageLoaded(), "Login page is not loaded.");
        LinkedinHomePage linkedinHomePage = linkedinLoginPage.login(userEmail, userPassword);
        Assert.assertTrue(linkedinHomePage.isPageLoaded(), "Login page is not loaded.");

         LinkedinSearchPage linkedinSearchPage =  linkedinHomePage.search(serchTerm);
        Assert.assertTrue(linkedinSearchPage.isPageLoaded());
        Assert.assertEquals(linkedinSearchPage.searchSizeResult(), 10, "Wrong number search results on SearchPage");
        List<String>searchResultList = linkedinSearchPage.getSearchResultList();

           int i=1;
           for (String searchResult : searchResultList){

                Assert.assertTrue(searchResult.toLowerCase().contains(serchTerm.toLowerCase()),
                        "("+i+")SearchTerm "+serchTerm+ " not found in \n"+searchResult);
                i++;
            }
    }
}

//Задание
//Написать тест Сброса пароля и заменить его