package org.raul.lesson_8;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.time.Duration;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ViewsMenuOperations {
    private final By viewsLocator = AppiumBy.accessibilityId("Views");
    private final By bottomMenuLocator = AppiumBy.accessibilityId("WebView3");
    private final By txtSwitcherLocator = AppiumBy.accessibilityId("TextSwitcher");
    private final By dateWidgetsLocator = AppiumBy.accessibilityId("Date Widgets");
    private final By dialogLocator = AppiumBy.accessibilityId("1. Dialog");
    private final By dateChangeLocator = AppiumBy.accessibilityId("change the date");
    private final By timeChangeLocator = AppiumBy.accessibilityId("change the time (spinner)");
    private final By viewContainerLocator = AppiumBy.id("android:id/list");
    private final By viewsSubMenuLocator = AppiumBy.className("android.widget.TextView");


    private AppiumDriver driver;

    public ViewsMenuOperations(AppiumDriver driver) {
        this.driver = driver;
    }

    public void clickViews() {
        driver.findElement(viewsLocator).click();
    }

    private Set<String> countVisibleMenuElements() {
        WebElement containerElement = driver.findElement(viewContainerLocator);
        Set<String> uniqueList = new HashSet<>();

        List<WebElement> elementList = containerElement.findElements(viewsSubMenuLocator);
        for (WebElement element : elementList) {
            String text = element.getText();
            uniqueList.add(text);
        }
        return uniqueList;
    }

    public void totalSubMenuElements() {
        Set<String> uniqueList = new HashSet<>();

        while (driver.findElements(bottomMenuLocator).isEmpty()) {
            uniqueList.addAll(countVisibleMenuElements());
            swipe();
        }
        uniqueList.addAll(countVisibleMenuElements());

        for (String element : uniqueList) {
            System.out.println(element);
        }
        int total = uniqueList.size();
        System.out.println(total);
    }

    public void scrollToElement() {
        while (driver.findElements(bottomMenuLocator).isEmpty()) {
            swipe();
        }
    }

    public void swipe() {
        Dimension screenSize = driver.manage().window().getSize();
        int pointerX = screenSize.getWidth() / 2;
        int startY = screenSize.getHeight() / 2;
        int endY = (int) (screenSize.getHeight() * 0.25);

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence sequence = new Sequence(finger, 0)
                .addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), pointerX, startY))
                .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger, Duration.ofMillis(1000)))
                .addAction(finger.createPointerMove(Duration.ofMillis(500), PointerInput.Origin.viewport(), pointerX, endY))
                .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger, Duration.ofMillis(1500)));
        driver.perform(Collections.singletonList(sequence));
    }
}
