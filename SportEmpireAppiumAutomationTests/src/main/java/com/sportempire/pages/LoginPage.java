package com.sportempire.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebElement;

@Getter
@Slf4j
public class LoginPage extends BasePage {

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"\uE915, Login\"]")
    private WebElement loginLinkWhenNotLoggedIn;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[contains(@content-desc, '\uE915,')]//android.widget.TextView[2]")
    private WebElement loginLinkWhenLoggedIn;

    @AndroidFindBy(xpath = "//android.widget.EditText[@text='Email or username']")
    private WebElement usernameField;

    @AndroidFindBy(xpath = "//android.widget.EditText[@text='Password']")
    private WebElement passwordField;

    @AndroidFindBy(accessibility = "Login")
    private WebElement loginButton;

    public LoginPage(AppiumDriver driver) {
        super(driver);
    }

    public void clickLoginLink() {
        tap(loginLinkWhenNotLoggedIn);
    }

    public String getLoginText() {
        return getTextFromElement(loginLinkWhenLoggedIn);
    }

    public void enterUsername(String text) {
        enterText(usernameField, text);
    }

    public void enterPassword(String text) {
        enterText(passwordField, text);
    }

    public void clickLoginButton() {
        tap(loginButton);
        waitUntilElementIsNotVisible(loginButton);
    }
}
