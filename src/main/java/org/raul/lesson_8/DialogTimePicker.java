package org.raul.lesson_8;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.raul.utils.AndroidUtils;

import java.time.Duration;
import java.util.List;

/*
 * 2) Открыть приложение → Views → Data Widgets → 1. Dialog →
 * Здесь нужно задать дату и время использую данные кнопки.
 * Нужно задать завтрашнее число (18/03) и время 11:11 PM
 * */
public class DialogTimePicker extends AndroidUtils {
    private AppiumDriver driver;
    private WebDriverWait wait;

    private List<WebElement> timePickerFields;


    public DialogTimePicker(AppiumDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public DialogTimePicker clickChangeTheTime() {
        wait.until(ExpectedConditions.elementToBeClickable(timeChangeLocator)).click();
        wait.until(ExpectedConditions.elementToBeClickable(TimeSpinnerLayoutLocator)).click();

        timePickerFields = driver.findElements(timePickerFieldsLocator);
        return this;
    }

    public DialogTimePicker setHour(int hour) {
        WebElement hourInput = timePickerFields.get(0);
        hourInput.clear();
        hourInput.sendKeys(String.valueOf(hour));

        wait.until(ExpectedConditions.textToBePresentInElement(hourInput, String.valueOf(hour)));
        return this;
    }

    public DialogTimePicker setMinute(int minute) {
        WebElement minuteInput = timePickerFields.get(1);
        minuteInput.clear();
        minuteInput.sendKeys(String.valueOf(minute));

        wait.until(ExpectedConditions.textToBePresentInElement(minuteInput, String.valueOf(minute)));
        return this;
    }

    public DialogTimePicker setAmPm(String amORpm) {
        WebElement amPmInput = timePickerFields.get(2);
        amPmInput.clear();
        amPmInput.sendKeys(String.valueOf(amORpm));
        driver.findElement(TimeSpinnerLayoutLocator).click();

        wait.until(ExpectedConditions.textToBePresentInElement(amPmInput, amORpm));
        return this;
    }

    public DialogTimePicker confirmInputFields() {
        driver.findElement(okButtonLocator).click();
        return this;
    }
}
