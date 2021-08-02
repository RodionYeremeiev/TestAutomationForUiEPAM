package bbc1.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class NewsPage extends BasePage {
    private static final String HEADLINE_ARTICLE = "//div[@data-entityid='container-top-stories#1']";

    private static final String MOST_WATCHED_ARTICLES =
        "//ol[contains(@class,'gel-layout--no-flex')]//span[contains(@class,'promo-heading__title')]";

    private static final String HEADLINE_ARTICLE_CATEGORY =
        "//div[@data-entityid='container-top-stories#1']//li[@class='nw-c-promo-meta']/a/span";

    private static final String SEARCH_INPUT = "//form[@role='search']//input[@placeholder='Search']";

    private static final String CONTACT_BBC_BUTTON = "//div[@id='services-bar']//span[text()='Contact BBC News']";

    private static final String SEND_US_STORY_LINK = "//a[text()='send us a story']";

    private static final String CORONA_VIRUS_BUTTON = "//nav[@class='nw-c-nav__wide']//span[text()='Coronavirus']";

    private static final String YOUR_CORONA_VIRUS_STORIES =
        "//nav[@class='nw-c-nav__wide-secondary']//span[text()='Your Coronavirus Stories']";

    private static final String FORM_INPUT_STORY = "//textarea[@placeholder='Tell us your story. ']";

    private static final String FORM_INPUT_NAME = "//input[@placeholder='Name']";

    private static final String FORM_INPUT_EMAIL = "//input[@placeholder='Email address']";

    private static final String FORM_INPUT_CONTACT_NUMBER = "//input[@placeholder='Contact number ']";

    private static final String FORM_INPUT_LOCATION = "//input[@placeholder='Location ']";

    private static final String FORM_SUBMIT_BUTTON = "//button[text()='Submit']";

    private static final String FORM_DONT_PUBLISH_CHECKBOX = "//p[contains(text(),'publish my name')]";

    private static final String FORM_ACCEPT_TERMS_CHECKBOX = "//p[text()='I accept the ']";

    private static final String MODAL_POP_UP_CLOSE_BUTTON = "//div[@class='tp-modal']//button";

    private static final String FORM_ERROR_MESSAGE = "//div[@class='input-error-message']";

    //    private static final String FORM_CONTACT_INFO_INPUT = "//input[@placeholder='";
    private static final String FORM_CONTACT_INFO_INPUT = "//input[contains(@placeholder,";


    //    private static final String FORM_INPUT_INVALID_EMAIL_MESSAGE = "//div[text()='Email address is invalid']";
    private StorySubmitFrom form = new StorySubmitFrom(this.driver);

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

//    public void formInputByName(String name) {
//        driver.findElement(By.xpath(FORM_CONTACT_INFO_INPUT + "'" + name + "')]")).clear();
//        driver.findElement(By.xpath(FORM_CONTACT_INFO_INPUT + "'" + name + "')]")).sendKeys(values.get(name));
//    }

    public void sendStory(Map<String, String> values) {
        driver.findElement(By.xpath(CORONA_VIRUS_BUTTON)).click();
        driver.findElement(By.xpath(YOUR_CORONA_VIRUS_STORIES)).click();
        driver.findElement(By.xpath(CONTACT_BBC_BUTTON)).click();
        driver.findElement(By.xpath(SEND_US_STORY_LINK)).click();

        form.fillForm(values);
//        driver.findElement(By.xpath(FORM_INPUT_STORY)).clear();
//        driver.findElement(By.xpath(FORM_INPUT_STORY)).sendKeys("some hard-coded character sequence");
//
//        formInputByName("Name");
//        formInputByName("Email address");
//        formInputByName("Contact number");
//        formInputByName("Location");
//
//        driver.findElement(By.xpath(FORM_DONT_PUBLISH_CHECKBOX)).click();
//        driver.findElement(By.xpath(FORM_ACCEPT_TERMS_CHECKBOX)).click();
//        driver.findElement(By.xpath(FORM_SUBMIT_BUTTON)).click();
    }

    public WebElement getErrorMessage() {
        return driver.findElement(By.xpath(FORM_ERROR_MESSAGE));
    }
}
