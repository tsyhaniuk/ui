package helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

import static utils.Config.BROWSER;
import static constants.Constant.TimeoutVariables.IMPLICIT_WAIT;

public class DriverManager {
    public static WebDriver createDriver() {
        WebDriver driver = null;

        switch (BROWSER) {
            case "win.chrome":
                System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
                driver = new ChromeDriver();
                break;
            default:
                Assert.fail("Incorrect browser name: " + BROWSER);
        }
        driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT, TimeUnit.SECONDS);
        return driver;
    }
}
