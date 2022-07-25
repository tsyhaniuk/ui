package helpers;


import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import utils.Config;

public class ScreenDataProvider {

    @DataProvider
    public static Object[][] getScreenResolution() {
        return new Object[][]{
                {
                        Config.SCREEN_RESOLUTION_800_600

                },
                {
                        Config.SCREEN_RESOLUTION_1024_768
                },
                {
                        Config.SCREEN_RESOLUTION_MAXIMUM
                }
        };
    }
}
