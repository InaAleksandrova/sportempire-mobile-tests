package com.sportempire.driverFactory;

import com.sportempire.constants.AppiumDriverConstants;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class AppiumDriverService {

    private AppiumDriverLocalService appiumService;

    public AppiumDriverLocalService startAppiumService() {
        if (appiumService == null) {
            appiumService = AppiumDriverLocalService.buildService(
                    new AppiumServiceBuilder()
                            .withIPAddress(AppiumDriverConstants.APPIUM_SERVER_IP)
                            .usingPort(AppiumDriverConstants.APPIUM_SERVER_PORT)
            );
            appiumService.start();
        }
        return appiumService;
    }

    public void stopAppiumService(AppiumDriverLocalService appiumService) {
        appiumService.stop();
    }
}
