package com.sportempire.mobile.stepdefinition;

import com.sportempire.mobile.hooks.Hooks;
import com.sportempire.pages.LoginPage;
import com.sportempire.util.PropertiesHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.testng.Assert;

public class LoginStepDefinitions {

    private PropertiesHelper propertiesHelper = new PropertiesHelper("login.properties");
    public String validUsername = propertiesHelper.getProperty("valid_username");
    public String validPassword = propertiesHelper.getProperty("valid_password");
    private LoginPage loginPage = new LoginPage(Hooks.driver);

    @Given("I am successfully logged in with valid username and password")
    public void enterValidUsernameAndPassword() {
        loginPage.clickLoginLink();
        loginPage.enterUsername(validUsername);
        loginPage.enterPassword(validPassword);
        loginPage.clickLoginButton();
        Assert.assertNotEquals(loginPage.getLoginText(), "Login", "User is not successfully logged in");
    }


}
