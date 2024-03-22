package org.raul.lesson_8;

import io.appium.java_client.AppiumDriver;
import org.raul.utils.DriverSetUp;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CountViewsSubMenusTest {
    private AppiumDriver driver;
    private CountViewsSubMenus views;

    @BeforeClass
    public void setUp() {
        driver = DriverSetUp.startAndroidDriver();
        views = new CountViewsSubMenus(driver);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void initialSetupTest() {
        views.clickViews(driver);

        int actualResult = views.totalSubMenuElements();
        int expectedResult = 42;
        Assert.assertEquals(actualResult, expectedResult, "Total of Views sub-menu elements is 42!");

    }
}
