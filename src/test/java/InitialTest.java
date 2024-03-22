import io.appium.java_client.AppiumDriver;
import org.raul.utils.DriverSetUp;
import org.raul.ViewsMenuOperations;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class InitialTest {
    private AppiumDriver driver;
    private ViewsMenuOperations views;

    @BeforeClass
    public void setUp() {
        driver = DriverSetUp.androidDriverSetup();
        views = new ViewsMenuOperations(driver);
    }
    @Test
    public void initialSetupTest(){

        views.clickViews();
    }

}
