package org.raul.utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverSetUp {

    private static AppiumDriver driver;
    private static final String LOCALHOST = "http://127.0.0.1:4723";

    public static AppiumDriver androidDriverSetup() {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);
        options.setDeviceName("Aqa");
        options.setApp("C:/Users/Rashad Gurbanov/Desktop/DevLab/Java/AndersenLab/ApiDemos-debug.apk");

        try {
            driver = new AndroidDriver(new URL(LOCALHOST), options);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        return driver;
    }
}
