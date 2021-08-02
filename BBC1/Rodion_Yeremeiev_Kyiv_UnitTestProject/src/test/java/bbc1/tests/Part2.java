package bbc1.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import bbc1.pages.StorySubmitFrom;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;

public class Part2 extends BaseTest {
    private static final String BBC_URL = "https://www.bbc.com/";

    private static final String HEADER_NEWS_BUTTON =
        "//header[@id='header-content']//li[contains(@class,'GlobalNavigationProduct')]/a[text()='News']";

    private static final String CORONA_VIRUS_BUTTON = "//nav[@class='nw-c-nav__wide']//span[text()='Coronavirus']";

    private static final String YOUR_CORONA_VIRUS_STORIES =
        "//nav[@class='nw-c-nav__wide-secondary']//span[text()='Your Coronavirus Stories']";

    private static final String CONTACT_BBC_BUTTON = "//div[@id='services-bar']//span[text()='Contact BBC News']";

    private static final String SEND_US_STORY_LINK = "//a[text()='send us a story']";

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

    private static final String FORM_INPUT_INVALID_EMAIL_MESSAGE = "//div[text()='Email address is invalid']";

    private static final String FORM_INPUT_NAME_EMPTY_MESSAGE = "//div[text()='Name can't be blank']";

    private static final String FORM_INPUT_STORY_EMPTY_MESSAGE = "//div[text()=' t be blank']";

    private static final String FORM_INPUT_UNCHECKED_ACCEPT_CHECKBOX_MESSAGE = "//div[text()=' must be accepted']";

    private WebDriver driver;

    private static final String FORM_CONTACT_INFO_INPUT = "//input[@placeholder='";

    Map<String, String> values = Stream.of(
        new String[][]{{"Name", "Bob"},
                       {"Email address", "invalidAdress"},
                       {"Contact number", "555-3258-11"},
                       {"Location", "Tokyo"}}).collect(Collectors.toMap(p -> p[0], p -> p[1]));
//    @BeforeTest
//    public void profileSetUp() {
//        chromedriver().setup();
//    }
//
//    @BeforeMethod
//    public void testsSetUp() {
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.get(BBC_URL);
//        driver.findElement(By.xpath(HEADER_NEWS_BUTTON)).click();
//    }
//
//    @AfterMethod
//    public void tearDown() {
//        driver.close();
//    }

    @Test
    public void testFour() {
        getNewsPage().sendStory(values);
        getNewsPage().implicitWait(360);
        Assert.assertTrue(getNewsPage().getErrorMessage().getText().contains("Email address is invalid"));
    }

    @Test
    public void testFive() {
        driver.findElement(By.xpath(CORONA_VIRUS_BUTTON)).click();
        driver.findElement(By.xpath(YOUR_CORONA_VIRUS_STORIES)).click();
        driver.findElement(By.xpath(CONTACT_BBC_BUTTON)).click();
        driver.findElement(By.xpath(SEND_US_STORY_LINK)).click();

        driver.findElement(By.xpath(FORM_INPUT_NAME)).clear();
        driver.findElement(By.xpath(FORM_INPUT_NAME)).sendKeys("Bob");

        driver.findElement(By.xpath(FORM_INPUT_EMAIL)).clear();
        driver.findElement(By.xpath(FORM_INPUT_EMAIL)).sendKeys("adress@mail.com");

        driver.findElement(By.xpath(FORM_INPUT_CONTACT_NUMBER)).clear();
        driver.findElement(By.xpath(FORM_INPUT_CONTACT_NUMBER)).sendKeys("555-3258-11");

        driver.findElement(By.xpath(FORM_INPUT_LOCATION)).clear();
        driver.findElement(By.xpath(FORM_INPUT_LOCATION)).sendKeys("Tokyo");

        driver.findElement(By.xpath(FORM_DONT_PUBLISH_CHECKBOX)).click();
        driver.findElement(By.xpath(FORM_ACCEPT_TERMS_CHECKBOX)).click();

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

//        driver.findElement(By.xpath(MODAL_POP_UP_CLOSE_BUTTON)).click();
//
        driver.findElement(By.xpath(FORM_SUBMIT_BUTTON)).click();

        Assert.assertTrue(driver.findElement(By.xpath(FORM_ERROR_MESSAGE)).isDisplayed());
    }

    @Test
    public void testSix() {
        driver.findElement(By.xpath(CORONA_VIRUS_BUTTON)).click();
        driver.findElement(By.xpath(YOUR_CORONA_VIRUS_STORIES)).click();
        driver.findElement(By.xpath(CONTACT_BBC_BUTTON)).click();
        driver.findElement(By.xpath(SEND_US_STORY_LINK)).click();

        driver.findElement(By.xpath(FORM_INPUT_STORY)).clear();
        driver.findElement(By.xpath(FORM_INPUT_STORY)).sendKeys("some hard-coded character sequence");

        driver.findElement(By.xpath(FORM_INPUT_EMAIL)).clear();
        driver.findElement(By.xpath(FORM_INPUT_EMAIL)).sendKeys("adress@mail.com");

        driver.findElement(By.xpath(FORM_INPUT_CONTACT_NUMBER)).clear();
        driver.findElement(By.xpath(FORM_INPUT_CONTACT_NUMBER)).sendKeys("555-3258-11");

        driver.findElement(By.xpath(FORM_INPUT_LOCATION)).clear();
        driver.findElement(By.xpath(FORM_INPUT_LOCATION)).sendKeys("Tokyo");

        driver.findElement(By.xpath(FORM_DONT_PUBLISH_CHECKBOX)).click();
        driver.findElement(By.xpath(FORM_ACCEPT_TERMS_CHECKBOX)).click();

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.findElement(By.xpath(MODAL_POP_UP_CLOSE_BUTTON)).click();

        driver.findElement(By.xpath(FORM_SUBMIT_BUTTON)).click();

        Assert.assertTrue(driver.findElement(By.xpath(FORM_ERROR_MESSAGE)).isDisplayed());
    }

    @Test
    public void testSeven() {
        driver.findElement(By.xpath(CORONA_VIRUS_BUTTON)).click();
        driver.findElement(By.xpath(YOUR_CORONA_VIRUS_STORIES)).click();
        driver.findElement(By.xpath(CONTACT_BBC_BUTTON)).click();
        driver.findElement(By.xpath(SEND_US_STORY_LINK)).click();

        driver.findElement(By.xpath(FORM_INPUT_STORY)).clear();
        driver.findElement(By.xpath(FORM_INPUT_STORY)).sendKeys("some hard-coded character sequence");

        driver.findElement(By.xpath(FORM_INPUT_NAME)).clear();
        driver.findElement(By.xpath(FORM_INPUT_NAME)).sendKeys("Bob");

        driver.findElement(By.xpath(FORM_INPUT_EMAIL)).clear();
        driver.findElement(By.xpath(FORM_INPUT_EMAIL)).sendKeys("adress@mail.com");

        driver.findElement(By.xpath(FORM_INPUT_CONTACT_NUMBER)).clear();
        driver.findElement(By.xpath(FORM_INPUT_CONTACT_NUMBER)).sendKeys("555-3258-11");

        driver.findElement(By.xpath(FORM_INPUT_LOCATION)).clear();
        driver.findElement(By.xpath(FORM_INPUT_LOCATION)).sendKeys("Tokyo");

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.findElement(By.xpath(MODAL_POP_UP_CLOSE_BUTTON)).click();

        driver.findElement(By.xpath(FORM_DONT_PUBLISH_CHECKBOX)).click();

        driver.findElement(By.xpath(FORM_SUBMIT_BUTTON)).click();

        Assert.assertTrue(driver.findElement(By.xpath(FORM_ERROR_MESSAGE)).isDisplayed());
    }
}
