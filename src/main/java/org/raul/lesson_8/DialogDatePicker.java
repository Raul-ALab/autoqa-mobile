package org.raul.lesson_8;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.raul.utils.AndroidUtils;

import java.time.Duration;

/*
 * 2) Открыть приложение → Views → Data Widgets → 1. Dialog →
 * Здесь нужно задать дату и время использую данные кнопки.
 * Нужно задать завтрашнее число (18/03) и время 11:11 PM
 * */
public class DialogDatePicker extends AndroidUtils {
    private AppiumDriver driver;
    private WebDriverWait wait;


    public DialogDatePicker(AppiumDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public DialogDatePicker navigateToDateWidgets() {
        clickViews(driver);
        wait.until(ExpectedConditions.elementToBeClickable(dateWidgetsLocator)).click();
        return this;
    }

    public DialogDatePicker clickDialog() {
        wait.until(ExpectedConditions.elementToBeClickable(dialogLocator)).click();
        return this;
    }

    public DialogDatePicker clickChangeTheDate() {
        wait.until(ExpectedConditions.elementToBeClickable(dateChangeLocator)).click();
        return this;
    }

    public DialogDatePicker pickYear(String year) {
        wait.until(ExpectedConditions.elementToBeClickable(yearHeaderLocator)).click();

        String dynamicYearXpath = String.format("//android.widget.TextView[@resource-id='android:id/text1' and @text='%s']", year);
        driver.findElement(AppiumBy.xpath(dynamicYearXpath)).click();
        return this;
    }

    public DialogDatePicker clickMonthView() {
        wait.until(ExpectedConditions.elementToBeClickable(monthViewLocator)).click();
        return this;
    }

    public DialogDatePicker pickDate(String date) {
        String dynamicDateXpath = String.format("//android.view.View[@text='%s']", date);
        driver.findElement(AppiumBy.xpath(dynamicDateXpath)).click();
        driver.findElement(okButtonLocator).click();
        return this;
    }

    public String getDateResult() {
        String result = driver.findElement(dateDisplayLocator).getText();
        String[] extractedDate = result.split(" ");
        return extractedDate[0].trim();
    }
}
