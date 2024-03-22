package org.raul.utils;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.time.Duration;
import java.util.Collections;

public class AndroidUtils {
    protected final By viewsLocator = AppiumBy.accessibilityId("Views");
    protected final By bottomMenuLocator = AppiumBy.accessibilityId("WebView3");
    protected final By txtSwitcherLocator = AppiumBy.accessibilityId("TextSwitcher");
    protected final By dateWidgetsLocator = AppiumBy.accessibilityId("Date Widgets");
    protected final By dialogLocator = AppiumBy.accessibilityId("1. Dialog");
    protected final By dateChangeLocator = AppiumBy.accessibilityId("change the date");
    protected final By timeChangeLocator = AppiumBy.accessibilityId("change the time (spinner)");
    protected final By viewContainerLocator = AppiumBy.id("android:id/list");
    protected final By viewsSubMenuLocator = AppiumBy.className("android.widget.TextView");
    private AppiumDriver driver;

    public static void swiper(AppiumDriver driver) {
        Dimension screenSize = driver.manage().window().getSize();
        int pointerX = screenSize.getWidth() / 2;
        int startY = screenSize.getHeight() / 2;
        int endY = (int) (screenSize.getHeight() * 0.25);

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence sequence = new Sequence(finger, 0)
                .addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), pointerX, startY))
                .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger, Duration.ofMillis(200)))
                .addAction(finger.createPointerMove(Duration.ofMillis(330), PointerInput.Origin.viewport(), pointerX, endY))
                .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Collections.singletonList(sequence));
    }

    public void clickViews(AppiumDriver driver) {
        driver.findElement(viewsLocator).click();
    }
}
