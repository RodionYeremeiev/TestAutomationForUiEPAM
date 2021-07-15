package bbc1.pages;

import org.openqa.selenium.By;

import java.util.Dictionary;

public class StorySubmitFrom {
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

    public void FillForm(Dictionary<String, String> values){
        values.put("Name","bob");

    }

}
