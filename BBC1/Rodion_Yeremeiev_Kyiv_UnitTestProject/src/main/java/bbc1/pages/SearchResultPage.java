package bbc1.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchResultPage extends BasePage {
    private static final String ARTICLES_IN_CATEGORY_TO_CHECK = "//p[contains(@class,'PromoHeadline')]/span";


    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> getArticles() {
        return driver.findElements(By.xpath(ARTICLES_IN_CATEGORY_TO_CHECK));
    }
}
