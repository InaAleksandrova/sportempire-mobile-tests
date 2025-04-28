package com.sportempire.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class LogoutPage extends BasePage {

    @AndroidFindBy(xpath = "//android.view.ViewGroup[contains(@content-desc, '\uE915,')]//android.widget.TextView[2]")
    private WebElement loginLinkWhenLoggedIn;

    @FindBy(id = "userMenuContent")
    private WebElement menuContent;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='LOGOUT']")
    private WebElement logoutButton;

    public LogoutPage(AppiumDriver driver) {
        super(driver);
    }

    public void navigateToLogOut() {
        tap(loginLinkWhenLoggedIn);
    }

    public void clickLogout() {
        waitUntilElementIsVisible(menuContent);
        if(!logoutButton.isDisplayed()) {
            scrollToAndroidElement("LOGOUT");
        }
        tap(logoutButton);
    }
}
