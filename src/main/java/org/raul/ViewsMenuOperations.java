package org.raul;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;

public class ViewsMenuOperations {
    private AppiumDriver driver;

    public ViewsMenuOperations(AppiumDriver driver) {
        this.driver = driver;
    }

    public void clickViews() {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
    }
}
