package bbc1.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

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
        getNewsPage().sendStory(TestData.formDataIncorrectEmail, true, true);
        getNewsPage().implicitWait(360);
        Assert.assertTrue(getNewsPage().getErrorMessage().getText().contains("Email address is invalid"));
    }

    @Test
    public void testFive() {
        getNewsPage().sendStory(TestData.formDataNoStory, true, true);
        getNewsPage().implicitWait(360);
        Assert.assertTrue(getNewsPage().getErrorMessage().getText().contains("can't be blank"));
    }

    @Test
    public void testSix() {
        getNewsPage().sendStory(TestData.formDataNoNameInput, true, true);
        getNewsPage().implicitWait(360);
        Assert.assertTrue(getNewsPage().getErrorMessage().getText().contains("can't be blank"));
    }

    @Test
    public void testSeven() {
        getNewsPage().sendStory(TestData.formDataCorrectInput, true, false);
        getNewsPage().implicitWait(360);
        getNewsPage().waitForVisibilityOfElement(60,getNewsPage().getErrorMessage());
        System.out.println(getNewsPage().getErrorMessage().getText());
        Assert.assertTrue(getNewsPage().getErrorMessage().getText().equals("must be accepted"));

    }
}
