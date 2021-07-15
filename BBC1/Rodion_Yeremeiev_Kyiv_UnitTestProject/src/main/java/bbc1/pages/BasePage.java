package bbc1.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class BasePage {
    WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void implicitWait(long timeout) {
        driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
    }

    public void waitForPageLoadingComplete(long timeout) {
        new WebDriverWait(driver, timeout).until(
                webDriver -> ((JavascriptExecutor) webDriver)
                        .executeScript("return document.readyState")
                        .equals("complete")
        );
    }

    public void waitForVisibilityOfElement(long timeout, WebElement element) {
        new WebDriverWait(driver, timeout)
                .until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForAllElementsPresent(long timeout, List<WebElement> webElements) {
        new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOfAllElements(webElements));
    }
}
