package com.sportempire.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Getter
@Slf4j
public class LivePage extends BasePage {

    @AndroidFindBy(xpath = "//android.view.View[@resource-id='liveNavList']/android.view.View/android.widget.TextView[2]")
    private List<WebElement> liveNavNumbers;

    @AndroidFindBy(xpath = "//android.view.View[@resource-id='appComponents']//android.view.View[contains(@text, '.')]")
    private List<WebElement> oddValues;

    @AndroidFindBy(xpath = "//android.view.View[@resource-id=\"navigation-bottom\"]/android.view.View[3]/android.view.View[1]")
    private WebElement betSlipValue;

    public LivePage(AppiumDriver driver) {
        super(driver);
    }

    public void chooseSportWithMoreThan5Events() {
        log.info("Logging" + liveNavNumbers.size());
        List<WebElement> filtered = liveNavNumbers.stream()
                .filter(el -> {
                    try {
                        int value = Integer.parseInt(el.getText().trim());
                        return value > 5;
                    } catch (NumberFormatException e) {
                        return false;
                    }
                })
                .collect(Collectors.toList());


        isListEmpty(filtered);
        clickOnRandomElement(filtered);
    }

    public String getBetSlipValue() {
        waitUntilElementIsVisible(betSlipValue);
        return betSlipValue.getText();
    }

    public void clickRandomNumberBetweenNumbers(double number1, double number2) {
        waitUntilElementIsVisible(oddValues.get(0));
        log.info("Random value" + oddValues.size());
        List<WebElement> filtered = oddValues.stream()
                .filter(element -> {
                    try {
                        double value = Double.parseDouble(element.getText().trim());
                        return value >= number1 && value <= number2;
                    } catch (NumberFormatException e) {
                        return false; // Not a number
                    }
                })
                .collect(Collectors.toList());

        isListEmpty(filtered);
        clickOnRandomElement(filtered);
    }

    private void clickOnRandomElement(List<WebElement> elements) {
        Random random = new Random();
        WebElement randomElement = elements.get(random.nextInt(elements.size()));
        log.info("Clicking on element with value: " + randomElement.getText());
        randomElement.click();
    }

    private boolean isListEmpty(List<WebElement> elements) {
        if (elements.isEmpty()) {
            log.info("No elements found.");
            return true;
        }
        return false;
    }
}
