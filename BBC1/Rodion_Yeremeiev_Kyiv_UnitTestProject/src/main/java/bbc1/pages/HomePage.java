package bbc1.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    private static final String HEADER_NEWS_BUTTON = "//header[@id='orb-banner']//li[@class='orb-nav-newsdotcom']//a[text()='News']";

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void clickOnNewsButton() {
        driver.findElement(By.xpath(HEADER_NEWS_BUTTON)).click();
    }
}
