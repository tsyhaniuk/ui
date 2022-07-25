package tests;

import helpers.DriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import pages.BasePage;
import pages.EconomicCalendarPage;
import pages.HomePage;
import pages.RiskWarningPage;

import java.util.ArrayList;
import java.util.List;

import static utils.Config.HOLD_BROWSER_OPEN;

public class BaseTest {

    protected WebDriver driver = DriverManager.createDriver();
    protected BasePage basePage = new BasePage(driver);
    protected HomePage homePage = new HomePage(driver);
    protected EconomicCalendarPage economicCalendarPage = new EconomicCalendarPage(driver);
    protected RiskWarningPage riskWarningPage = new RiskWarningPage(driver);

    public void setScreenResolution(Dimension screenResolution) {
        driver.manage().window().setSize(screenResolution);
    }

    public void switchToNewOpenedTab() {
        List<String> browserTabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(browserTabs.get(1));
    }

    @AfterSuite
    public void close() {
        if (HOLD_BROWSER_OPEN)
            driver.quit();
    }
}
