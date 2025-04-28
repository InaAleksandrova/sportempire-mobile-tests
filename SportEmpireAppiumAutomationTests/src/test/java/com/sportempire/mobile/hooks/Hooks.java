package com.sportempire.mobile.hooks;

import com.sportempire.driverFactory.AndroidDriverService;
import com.sportempire.driverFactory.AppiumDriverService;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

@Slf4j
public class Hooks {
    private static final Logger log = LoggerFactory.getLogger(Hooks.class);
    private static AppiumDriverService appiumDriverService;
    private static AndroidDriverService androidDriverService;
    private static AppiumDriverLocalService appiumService;

    public static AppiumDriver driver;

    @Before
    public void setUp(Scenario scenario) {
        // Initialize the services
        appiumDriverService = new AppiumDriverService();
        androidDriverService = new AndroidDriverService();

        // Start the Appium server
        appiumService = appiumDriverService.startAppiumService();

        // Initialize the Android driver with the running Appium service
        androidDriverService.initializeDriver(appiumService);

        // Get the driver instance to use in the tests
        driver = androidDriverService.getDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        log.info("Starting scenario: " + scenario.getName());
    }

    @After
    public void tearDown(Scenario scenario) {
        log.info("Ending scenario: " + scenario.getName());

        // Close the Android driver
        if (androidDriverService != null) {
            androidDriverService.closeDriver();
        }

        // Stop the Appium server
        if (appiumDriverService != null && appiumService != null) {
            appiumDriverService.stopAppiumService(appiumService);
        }
    }
}
