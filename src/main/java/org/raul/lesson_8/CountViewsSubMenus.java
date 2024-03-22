package org.raul.lesson_8;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.raul.utils.AndroidUtils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CountViewsSubMenus extends AndroidUtils {
//    private final By viewsLocator = AppiumBy.accessibilityId("Views");
//    private final By bottomMenuLocator = AppiumBy.accessibilityId("WebView3");
//    private final By txtSwitcherLocator = AppiumBy.accessibilityId("TextSwitcher");
//    private final By dateWidgetsLocator = AppiumBy.accessibilityId("Date Widgets");
//    private final By dialogLocator = AppiumBy.accessibilityId("1. Dialog");
//    private final By dateChangeLocator = AppiumBy.accessibilityId("change the date");
//    private final By timeChangeLocator = AppiumBy.accessibilityId("change the time (spinner)");
//    private final By viewContainerLocator = AppiumBy.id("android:id/list");
//    private final By viewsSubMenuLocator = AppiumBy.className("android.widget.TextView");


    private AppiumDriver driver;

    public CountViewsSubMenus(AppiumDriver driver) {
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
            AndroidUtils.swipe(driver);
        }
        uniqueList.addAll(countVisibleMenuElements());

        for (String element : uniqueList) {
            System.out.println(element);
        }
        int total = uniqueList.size();
        System.out.println(total);
    }
}
