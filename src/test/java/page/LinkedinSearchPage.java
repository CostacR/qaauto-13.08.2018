package page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class LinkedinSearchPage extends LinkedinBasePage{
//    private WebDriver driver;

    @FindBy (xpath = "//h3[contains(@class, 'search-results__total')]")
    WebElement searchResultTotal;

//    @FindAll({
//            @FindBy(xpath = "//li[@class='search-result search-result__occluded-item ember-view']"),
//            @FindBy(xpath = "//li[@class='search-result search-result__occluded-item search-result__occlusion-hint ember-view']")
//    })
//    private List<WebElement> searchResults;

    @FindBy (xpath = "//li[contains(@class, 'search-result search-result__occluded-item')]")
    private List<WebElement> searchResults;

    @FindBy (xpath = "//span[@class='search-filters-bar__top-filter-text Sans-13px-black-55% flex-shrink-zero ml4']")
    public WebElement searchFiltersField;

    public LinkedinSearchPage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver, this);
        waitUntilElementVisible(searchResultTotal, 10);
        }

    public String getCurrentUrl(){

        return driver.getCurrentUrl();
    }
    public String getCurrentTitle(){
        return  driver.getTitle();
    }

    public boolean isPageLoaded(){
        return getCurrentUrl().contains("/search/results/")
                && getCurrentTitle().contains("Поиск")
                && searchResultTotal.isDisplayed()
                ;
    }

    public void scrollDownPage(){
        searchFiltersField.click();
        searchFiltersField.sendKeys(Keys.PAGE_DOWN);
        searchFiltersField.sendKeys(Keys.PAGE_DOWN);
        searchFiltersField.sendKeys(Keys.PAGE_DOWN);
    }

    public int searchSizeResult()  {
        System.out.println(searchResults.size());
        return searchResults.size();
    }

    public String searchItemContainTest() {
        int index = 1;
        String stringTextResult="";

            for (WebElement searchResult : searchResults) {
                stringTextResult = stringTextResult+index+" "+searchResult.getText().toLowerCase().contains("hr")+"\n";
                index++;
                }
            System.out.println(stringTextResult);
            return stringTextResult;
    }

    public List<String> getSearchResultList(){
        List<String> searchResultList = new ArrayList<String>();
        for (WebElement searchResult: searchResults) {
            ((JavascriptExecutor)driver).executeScript(
                    "arguments[0].scrollIntoView();", searchResult);
            searchResultList.add(searchResult.getText());
            }
        return searchResultList;}
}


//    public int[] getSearchResultsNumber() {
//        return i;
//    }

