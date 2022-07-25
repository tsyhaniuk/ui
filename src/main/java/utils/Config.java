package utils;

import helpers.DriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;

public class Config {

    public static final String BASE_URL = "https://www.xm.com/";
    public static final String BROWSER = "win.chrome";
    public static final Boolean HOLD_BROWSER_OPEN = true;
    public static final Dimension SCREEN_RESOLUTION_800_600 = new Dimension(800, 600);
    public static final Dimension SCREEN_RESOLUTION_1024_768 = new Dimension(1024, 768);
    public static final Dimension SCREEN_RESOLUTION_MAXIMUM = Config.getMaximizeScreenSize();
    public static final Dimension TEST_SCREEN_RESOLUTION_800_600 = new Dimension(802, 602);
    public static final Dimension TEST_SCREEN_RESOLUTION_1024_768 = new Dimension(1026, 770);
    public static final Dimension TEST_SCREEN_RESOLUTION_MAXIMUM = new Dimension(1554, 842);


    private static Dimension getMaximizeScreenSize() {
        WebDriver driver = DriverManager.createDriver();
        driver.manage().window().maximize();
        Dimension maximizeScreenSize = driver.manage().window().getSize();
        driver.quit();
        return maximizeScreenSize;
    }
}
