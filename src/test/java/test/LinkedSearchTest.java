package test;


import org.testng.Assert;
import org.testng.annotations.Test;
import page.LinkedinHomePage;
import page.LinkedinSearchPage;
import java.util.List;

public class LinkedSearchTest extends LinkedinBaseTest {

    @Test
    public void basicSearchTest(){
        String userEmail = "nsczxfxthntq@gmail.com";
        String userPassword = "4838960w";
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