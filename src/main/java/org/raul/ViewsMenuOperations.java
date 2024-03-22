package org.raul;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.time.Duration;
import java.util.Collections;

public class ViewsMenuOperations {
    private AppiumDriver driver;

    public ViewsMenuOperations(AppiumDriver driver) {
        this.driver = driver;
    }

    public void clickViews() {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
    }

    public void scrollToElement () {
        By locator = AppiumBy.accessibilityId("WebView2");
        while (driver.findElements(locator).isEmpty()) {
            swipeOrScroll();
        }
        if (!driver.findElements(locator).isEmpty()) {
           driver.findElement(locator).click();
        }
    }

    public void swipeOrScroll() {
        Dimension screenSize = driver.manage().window().getSize();
        int startX = screenSize.getWidth() / 2;
        int startY = screenSize.getHeight() / 2;
        int endY = (int) (screenSize.getHeight() * 0.25);

        PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
        Sequence sequence = new Sequence(finger1, 1)
                .addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY))
                .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger1, Duration.ofMillis(200)))
                .addAction(finger1.createPointerMove(Duration.ofMillis(100), PointerInput.Origin.viewport(), startX, endY))
                .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Collections.singletonList(sequence));
    }
}
