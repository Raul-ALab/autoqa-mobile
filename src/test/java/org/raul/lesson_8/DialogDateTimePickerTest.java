package org.raul.lesson_8;

import io.appium.java_client.AppiumDriver;
import org.raul.utils.DriverSetUp;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DialogDateTimePickerTest {
    private AppiumDriver driver;

    @BeforeClass
    public void setUp() {
        driver = DriverSetUp.startAndroidDriver();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void verifyDatePicker() {
        String year = "2024";
        String day = "18";

        String actualDate = new DialogDatePicker(driver)
                .navigateToDateWidgets()
                .clickDialog()
                .clickChangeTheDate()
                .pickYear(year)
                .clickMonthView()
                .pickDate(day)
                .getDateResult();

        String expectedDate = "3-18-2024";
        Assert.assertEquals(actualDate, expectedDate);
    }

    @Test(dependsOnMethods = "verifyDatePicker", alwaysRun = true)
    public void verifyTimePicker() {
        int hour = 11;
        int minute = 11;
        String amPm = "PM";

        DialogTimePicker timePicker = new DialogTimePicker(driver)
                .clickChangeTheTime()
                .setHour(hour)
                .setMinute(minute)
                .setAmPm(amPm)
                .confirmInputFields();
    }
}
