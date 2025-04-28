package com.sportempire.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
@Slf4j
public class BurgerMenu extends BasePage {

    @AndroidFindBy(accessibility = "\uF19C")
    private WebElement burgerMenu;

    @AndroidFindBy(xpath = "//android.view.View[@text=\"Live\"]")
    private WebElement liveNavListTab;

    public BurgerMenu(AppiumDriver driver) {
        super(driver);
    }

    public void clickBurgerMenu() {
        tap(burgerMenu);
    }

    public void tapLiveFromBurgerMenu() {
        tap(liveNavListTab);
    }
}
