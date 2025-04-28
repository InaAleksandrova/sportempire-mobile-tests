package com.sportempire.mobile.stepdefinition;

import com.sportempire.mobile.hooks.Hooks;
import com.sportempire.pages.BurgerMenu;
import com.sportempire.pages.LivePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class LiveStepDefinitions {

    private BurgerMenu burgerMenu = new BurgerMenu(Hooks.driver);
    private LivePage livePage = new LivePage(Hooks.driver);

    @When("I navigate to Live from burger menu")
    public void navigateToLive() {
        burgerMenu.clickBurgerMenu();
        burgerMenu.tapLiveFromBurgerMenu();
    }

    @And("I choose sport with more than 5 events")
    public void chooseSportWithMoreThan5Events() {
        livePage.chooseSportWithMoreThan5Events();
    }

    @And("I place a bet with odd value between {double} and {double}")
    public void placeABetWithOddValueBetween(double number1, double number2){
        livePage.clickRandomNumberBetweenNumbers(number1, number2);
    }

    @Then("I verify bet slip value is {string}")
    public void verifyBetSlipValue(String value) {
        Assert.assertEquals(livePage.getBetSlipValue(), value, "Incorrect value in bet slip");
    }
}
