package com.sportempire.mobile.stepdefinition;

import com.sportempire.mobile.hooks.Hooks;
import com.sportempire.pages.LogoutPage;
import io.cucumber.java.en.And;

public class LogoutStepDefinitions {

    LogoutPage logoutPage = new LogoutPage(Hooks.driver);

    @And("I am successfully logged out")
    public void verifySuccessfulLogOut() {
        logoutPage.navigateToLogOut();
        logoutPage.clickLogout();
    }
}
