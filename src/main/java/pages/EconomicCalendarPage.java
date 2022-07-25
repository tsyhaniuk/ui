package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.Config;

public class EconomicCalendarPage extends BasePage {

    public EconomicCalendarPage(WebDriver driver) {
        super(driver);
    }

    private final By calendarHeading = By.xpath("//h2[text()[contains(., 'Economic Calendar')]]");
    private final WebElement economicCalendarHeading = driver.findElement(calendarHeading);
    private final By timeSelector = By.xpath("//li[@class='saveSpace']");
    private final By theDay = By.xpath("//div[@id='widgetField']/div");
    private final WebElement iframe = driver.findElement(By.xpath("//div[@class='economic-calendar']/iframe"));
    private final By here = By.linkText("here");
    private final WebElement hereElement = driver.findElement(here);
    private final By disclaimer = By.xpath("//strong[@class='text--secondary']");

    public Boolean checkIsEconomicCalendarHeadingDisplayed() {
        waitElementIsVisibleLocatedBy(calendarHeading);
        Boolean isEconomicCalendarPresence = economicCalendarHeading.isDisplayed();
        return isEconomicCalendarPresence;
    }

    public EconomicCalendarPage selectCalendarFrame() {
        driver.switchTo().frame(iframe);
        return this;
    }

    public EconomicCalendarPage clickOnDay(By day) throws InterruptedException {
        if (getScreenResolution().equals(Config.SCREEN_RESOLUTION_800_600) || getScreenResolution().equals(Config.TEST_SCREEN_RESOLUTION_800_600) || getScreenResolution().equals(Config.SCREEN_RESOLUTION_MAXIMUM) || getScreenResolution().equals(Config.TEST_SCREEN_RESOLUTION_MAXIMUM)) {
            driver.findElement(day).click();
        } else if ((getScreenResolution().equals(Config.SCREEN_RESOLUTION_1024_768) || getScreenResolution().equals(Config.TEST_SCREEN_RESOLUTION_1024_768))) {
            driver.findElement(timeSelector).click();
            driver.findElement(day).click();
        }
        Thread.sleep(200); // I know Thread.sleep is bad practice, but otherwise the date in the widget don't have time to update
        return this;
    }

    public String getDateFromWidget() {
        String result = driver.findElement(theDay).getAttribute("innerHTML"); //Initially, I planned to take the date from the //td[@class='theDay'] locator, but it does not work for weekend. Therefore, I decided to take the date directly from the widget. I think this is not a very good solution, but I have not seen another.
        return result;
    }

    public void openRiskWarningPage() {
        if (getScreenResolution().equals(Config.SCREEN_RESOLUTION_800_600) || getScreenResolution().equals(Config.TEST_SCREEN_RESOLUTION_800_600) || getScreenResolution().equals(Config.SCREEN_RESOLUTION_1024_768) || getScreenResolution().equals(Config.TEST_SCREEN_RESOLUTION_1024_768))
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", here);
        else if (getScreenResolution().equals(Config.SCREEN_RESOLUTION_MAXIMUM) || getScreenResolution().equals(Config.TEST_SCREEN_RESOLUTION_MAXIMUM))
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", disclaimer);
        driver.findElement(By.linkText("here")).click();
    }
}

