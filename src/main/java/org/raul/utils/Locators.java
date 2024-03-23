package org.raul.utils;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public interface Locators {
    By viewsLocator = AppiumBy.accessibilityId("Views");
    By bottomMenuLocator = AppiumBy.accessibilityId("WebView3");
    By dateWidgetsLocator = AppiumBy.accessibilityId("Date Widgets");
    By dialogLocator = AppiumBy.accessibilityId("1. Dialog");
    By dateChangeLocator = AppiumBy.accessibilityId("change the date");
    By timeChangeLocator = AppiumBy.accessibilityId("change the time (spinner)");
    By txtSwitcherLocator = AppiumBy.accessibilityId("TextSwitcher");
    By viewContainerLocator = AppiumBy.id("android:id/list");
    By yearHeaderLocator = AppiumBy.id("android:id/date_picker_header_year");
    By monthViewLocator = AppiumBy.id("android:id/month_view");
    By okButtonLocator = AppiumBy.id("android:id/button1");
    By timePickerFieldsLocator = AppiumBy.id("android:id/numberpicker_input");
    By TimeSpinnerLayoutLocator = AppiumBy.id("android:id/timePickerLayout");
    By dateDisplayLocator = AppiumBy.id("io.appium.android.apis:id/dateDisplay");
    By viewsSubMenuLocator = AppiumBy.className("android.widget.TextView");
}
