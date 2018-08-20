import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class BadCodeExample {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        String searchItem = "selenium";

            WebElement searchField = driver.findElement(By.xpath("//input[@id='lst-ib']"));
            searchField.click();
            searchField.clear();
            searchField.sendKeys(searchItem);
            searchField.sendKeys(Keys.ENTER);

        List<WebElement> searchResults = driver.findElements(By.xpath("//div[@class='srg']//div[@class='g']"));
        int searchResultCount = searchResults.size();
        if (searchResultCount==10){
            System.out.println("Size array OK");
        }else {
            System.out.println("Size array Faied");
        }
        System.out.println("Search result count "+searchResults.size());

        for (WebElement searchResult: searchResults){
            String searchResultText = searchResult.getText();
            if (searchResultText.toLowerCase().contains(searchItem)==true){
                System.out.println("Found "+ searchItem);
            }else {
                System.out.println(searchItem+" not found");
            }
            System.out.println(searchResultText);
            System.out.println(" ");
        }

        }

   }
