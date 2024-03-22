package org.raul.lesson_8;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.raul.utils.AndroidUtils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * 1) Открыть приложение → Views → Написать тест, который будет
 * проверять количество элементов. (имеются ввиду кнопки при тапе
 * на которые можно будет перейти на новую страницу).
 * */
public class CountViewsSubMenus extends AndroidUtils {
    private AppiumDriver driver;

    public CountViewsSubMenus(AppiumDriver driver) {
        this.driver = driver;
    }

    public int totalSubMenuElements() {
        Set<String> uniqueList = new HashSet<>();

        while (driver.findElements(bottomMenuLocator).isEmpty()) {
            uniqueList.addAll(countVisibleMenuElements());
            AndroidUtils.swiper(driver);
        }
        uniqueList.addAll(countVisibleMenuElements()); // counting after last swipe

        return uniqueList.size();
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
}
