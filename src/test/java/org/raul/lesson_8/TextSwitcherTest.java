package org.raul.lesson_8;

import io.appium.java_client.AppiumDriver;
import org.raul.utils.DriverSetUp;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TextSwitcherTest {
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
    public void checkNextButtonFunctionality() {
        int clickNumber = 17;

        int actualResult = new TextSwitcher(driver)
                .scrollToTextSwitcher()
                .clickNextBtn(clickNumber)
                .checkCounterValue();

        Assert.assertEquals(actualResult, clickNumber, "Counter value is different from expected!");
    }
}
