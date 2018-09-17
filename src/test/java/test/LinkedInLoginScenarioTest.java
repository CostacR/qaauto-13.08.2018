package test;

import org.testng.Assert;
import org.testng.annotations.*;
import page.LinkedinHomePage;
import page.LinkedinSearchPage;

public class LinkedInLoginScenarioTest extends LinkedinBaseTest {

    @DataProvider
    public Object[][] validDataProvider() {
        return new Object[][]{
//              {"email", "password", "searchItem"}
                { "nsczxfxthntq@gmail.com", "4838960w", "hr"},
        };
    }

    /**
     * Search Test scenario
     *
     * @param userEmail
     * @param userPassword
     * @param searchItem
     *
     * Open login page
     * Verify login page is loaded
     * Login with valid userEmail and userPassword
     * Verify home page is loaded
     * Search Searchterm which contains for 'hr'
     * Verify Search page is loaded
     * Verify 10 results displayed on search page
     * Verify each result item contains searchTerm
     *
     */
    @Test (dataProvider ="validDataProvider")
    public void scenarioTest(String userEmail, String userPassword, String searchItem)  {

        Assert.assertTrue(linkedinLoginPage.isPageLoaded(), "Login page is not loaded.");
        LinkedinHomePage linkedinHomePage = linkedinLoginPage.login(userEmail, userPassword);

        Assert.assertTrue(linkedinHomePage.isLogOutButtonAble(),"'Log Out' button disable"); //проверка кнопки LogOut

        LinkedinSearchPage linkedinSearchPage = linkedinHomePage.search(searchItem);
        Assert.assertTrue(linkedinSearchPage.isPageLoaded(), "Search page is not loaded");

        Assert.assertEquals(linkedinSearchPage.searchSizeResult(), 10, "Wrong number search results on SearchPage");

        driver.manage().window().maximize();
        linkedinSearchPage.scrollDownPage();

        int count = linkedinSearchPage.searchSizeResult();
        linkedinSearchPage.searchItemContainTest();
        Assert.assertTrue(linkedinSearchPage.isPageLoaded(), "Search title is wrong");
    }
}
