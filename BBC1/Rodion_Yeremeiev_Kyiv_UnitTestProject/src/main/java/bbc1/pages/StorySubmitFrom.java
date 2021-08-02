package bbc1.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Map;


public class StorySubmitFrom  {
    private static WebDriver driver;

    public StorySubmitFrom(WebDriver driver) {
        this.driver = driver;
    }



    private static final String FORM_INPUT_STORY = "//textarea[@placeholder='Tell us your story. ']";

//    private static final String FORM_INPUT_NAME = "//input[@placeholder='Name']";
//
//    private static final String FORM_INPUT_EMAIL = "//input[@placeholder='Email address']";
//
//    private static final String FORM_INPUT_CONTACT_NUMBER = "//input[@placeholder='Contact number ']";
//
//    private static final String FORM_INPUT_LOCATION = "//input[@placeholder='Location ']";
//
    private static final String FORM_SUBMIT_BUTTON = "//button[text()='Submit']";

    private static final String FORM_DONT_PUBLISH_CHECKBOX = "//p[contains(text(),'publish my name')]";

    private static final String FORM_ACCEPT_TERMS_CHECKBOX = "//p[text()='I accept the ']";

//    private static final String MODAL_POP_UP_CLOSE_BUTTON = "//div[@class='tp-modal']//button";
//
//    private static final String FORM_ERROR_MESSAGE = "//div[@class='input-error-message']";
//
//    private static final String FORM_INPUT_INVALID_EMAIL_MESSAGE = "//div[text()='Email address is invalid']";
//
//    private static final String FORM_INPUT_NAME_EMPTY_MESSAGE = "//div[text()='Name can't be blank']";
//
//    private static final String FORM_INPUT_STORY_EMPTY_MESSAGE = "//div[text()=' t be blank']";
//
//    private static final String FORM_INPUT_UNCHECKED_ACCEPT_CHECKBOX_MESSAGE = "//div[text()=' must be accepted']";

    private static final String FORM_CONTACT_INFO_INPUT = "//input[contains(@placeholder,";


    public void formInputByName(String name, Map<String, String> values) {
        driver.findElement(By.xpath(FORM_CONTACT_INFO_INPUT + "'" + name + "')]")).clear();
        driver.findElement(By.xpath(FORM_CONTACT_INFO_INPUT + "'" + name + "')]")).sendKeys(values.get(name));
    }


    public void fillForm(Map<String, String> values, boolean isDoNotPublishChecked, boolean isAcceptTermsChecked) {
        driver.findElement(By.xpath(FORM_INPUT_STORY)).clear();
        driver.findElement(By.xpath(FORM_INPUT_STORY)).sendKeys(values.get("Story"));

//        formInputByName("Name");
        driver.findElement(By.xpath(FORM_CONTACT_INFO_INPUT + "'" + "Name" + "')]")).clear();
        driver.findElement(By.xpath(FORM_CONTACT_INFO_INPUT + "'" + "Name" + "')]")).sendKeys(values.get("Name"));
//        formInputByName("Email address");

        System.out.println(values.toString());
        driver.findElement(By.xpath(FORM_CONTACT_INFO_INPUT + "'" + "Email address" + "')]")).clear();
        driver.findElement(By.xpath(FORM_CONTACT_INFO_INPUT + "'" + "Email address" + "')]")).sendKeys(values.get("Email address"));
//        formInputByName("Contact number");
        driver.findElement(By.xpath(FORM_CONTACT_INFO_INPUT + "'" + "Contact number" + "')]")).clear();
        driver.findElement(By.xpath(FORM_CONTACT_INFO_INPUT + "'" + "Contact number" + "')]")).sendKeys(values.get("Contact number"));
//        formInputByName("Location");
        driver.findElement(By.xpath(FORM_CONTACT_INFO_INPUT + "'" + "Location" + "')]")).clear();
        driver.findElement(By.xpath(FORM_CONTACT_INFO_INPUT + "'" + "Location" + "')]")).sendKeys(values.get("Location"));

        if(isDoNotPublishChecked) {
            driver.findElement(By.xpath(FORM_DONT_PUBLISH_CHECKBOX)).click();
        }

        if(isAcceptTermsChecked) {
            driver.findElement(By.xpath(FORM_ACCEPT_TERMS_CHECKBOX)).click();
        }
        driver.findElement(By.xpath(FORM_SUBMIT_BUTTON)).click();

    }
}
