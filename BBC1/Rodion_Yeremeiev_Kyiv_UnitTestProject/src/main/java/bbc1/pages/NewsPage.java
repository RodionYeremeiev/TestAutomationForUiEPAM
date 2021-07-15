package bbc1.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class NewsPage extends BasePage {
    private static final String HEADLINE_ARTICLE = "//div[@data-entityid='container-top-stories#1']";
    private static final String MOST_WATCHED_ARTICLES = "//ol[contains(@class,'gel-layout--no-flex')]//span[contains(@class,'promo-heading__title')]";
    private static final String HEADLINE_ARTICLE_CATEGORY = "//div[@data-entityid='container-top-stories#1']//li[@class='nw-c-promo-meta']/a/span";
    private static final String SEARCH_INPUT = "//form[@role='search']//input[@placeholder='Search']";

    private static final String CONTACT_BBC_BUTTON = "//div[@id='services-bar']//span[text()='Contact BBC News']";
    private static final String SEND_US_STORY_LINK = "//a[text()='send us a story']";

    private static final String CORONA_VIRUS_BUTTON = "//nav[@class='nw-c-nav__wide']//span[text()='Coronavirus']";
    private static final String YOUR_CORONA_VIRUS_STORIES = "//nav[@class='nw-c-nav__wide-secondary']//span[text()='Your Coronavirus Stories']";


    public NewsPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getHeadLineArticle() {
        return driver.findElement(By.xpath(HEADLINE_ARTICLE));
    }

    public String getHeadLineArticleText() {
        return getHeadLineArticle().getText();
    }

    public List<WebElement> getMostWatchedArticlesList() {
        return driver.findElements(By.xpath(MOST_WATCHED_ARTICLES));
    }

    public WebElement getHeadlineArticleCategory() {
        return driver.findElement(By.xpath(HEADLINE_ARTICLE_CATEGORY));
    }

    public void searchByHeadlineCategory() {
        driver.findElement(By.xpath(SEARCH_INPUT)).clear();
        driver.findElement(By.xpath(SEARCH_INPUT)).sendKeys(getHeadlineArticleCategory().getText(), Keys.ENTER);
    }

    public void sendStory(){
        driver.findElement(By.xpath(CORONA_VIRUS_BUTTON)).click();
        driver.findElement(By.xpath(YOUR_CORONA_VIRUS_STORIES)).click();
        driver.findElement(By.xpath(CONTACT_BBC_BUTTON)).click();
        driver.findElement(By.xpath(SEND_US_STORY_LINK)).click();
    }
}
