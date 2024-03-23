package org.raul.utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverSetUp {

    private static final String LOCALHOST = "http://127.0.0.1:4723";
    private static AppiumDriver driver;


    // restrict access to instantiation
    private DriverSetUp() {
    }

    private static AppiumDriver androidDriverSetup() {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);
        options.setDeviceName("Aqa");
        options.setAppPackage("io.appium.android.apis");
        options.setAppActivity("io.appium.android.apis.ApiDemos");

        try {
            driver = new AndroidDriver(new URL(LOCALHOST), options);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        return driver;
    }

    public static AppiumDriver startAndroidDriver() {
        if (driver == null) {
            try {
                driver = androidDriverSetup();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return driver;
    }
}
