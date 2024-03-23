package org.raul.lesson_8;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.raul.utils.AndroidUtils;

import java.time.Duration;
import java.util.List;

/*
 * 3) Открыть приложение → Views → TextSwitcher →
 * Проверить работоспособность кнопки Next. Суть проверки
 * заключается в том, что после определенного количества
 * нажатия на кнопку Next это количество нажатий должно
 * отобразиться в поле по центру экрана
 * */
public class TextSwitcher extends AndroidUtils {
    private AppiumDriver driver;
    private WebDriverWait wait;

    private List<WebElement> timePickerFields;


    public TextSwitcher(AppiumDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public TextSwitcher scrollToTextSwitcher() {
        clickViews(driver);

        do {
            AndroidUtils.swiper(driver);
        } while (driver.findElements(txtSwitcherLocator).isEmpty());
        wait.until(ExpectedConditions.elementToBeClickable(txtSwitcherLocator)).click();
        return this;
    }

    public TextSwitcher clickNextBtn(int times) {
        WebElement nextElement = driver.findElement(nextButtonLocator);
        wait.until(ExpectedConditions.elementToBeClickable(nextElement));

        for (int i = 1; i <= times; i++) {
            nextElement.click();
        }
        return this;
    }

    public int checkCounterValue() {
        WebElement counterElement = driver
                .findElement(counterLocator)
                .findElement(viewsSubMenuLocator);

        return Integer.parseInt(counterElement.getText());
    }
}
