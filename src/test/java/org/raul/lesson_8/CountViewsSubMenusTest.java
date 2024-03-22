import io.appium.java_client.AppiumDriver;
import org.raul.utils.DriverSetUp;
import org.raul.lesson_8.CountViewsSubMenus;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class InitialTest {
    private AppiumDriver driver;
    private CountViewsSubMenus views;

    @BeforeClass
    public void setUp() {
        driver = DriverSetUp.startAndroidDriver();
        views = new CountViewsSubMenus(driver);
    }

    @Test
    public void initialSetupTest(){

        views.clickViews();
        views.totalSubMenuElements();
    }
}
