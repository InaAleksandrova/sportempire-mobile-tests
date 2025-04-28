package com.sportempire.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@Getter
@AllArgsConstructor
public class BasePage {

    private final AppiumDriver driver;
    private final WebDriverWait wait;

    public BasePage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(40));
    }

    public void waitUntilElementIsVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitUntilElementIsNotVisible(WebElement element) {
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    public void enterText(WebElement field, String text) {
        waitUntilElementIsVisible(field);
        field.clear();
        field.sendKeys(text);
    }

    public void tap(WebElement element) {
        waitUntilElementIsVisible(element);
        element.click();
    }

    public boolean isElementVisible(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isElementNotPresent(WebElement element) {
        return !element.isDisplayed();
    }

    public String getTextFromElement(WebElement element) {
        waitUntilElementIsVisible(element);
        return element.getText();
    }


    public WebElement scrollToAndroidElement(String elementText) {
        return driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true))"
                        + ".scrollIntoView(new UiSelector().text(\"" + elementText + "\"))"));
    }
}
