package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.Config;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    private final By modalDialog = By.xpath("//div[@class='modal-dialog']");
    private final By acceptAllButton = By.xpath("//div[@class='modal-footer']//button[@aria-label='Close']");
    private final By researchAndEducationButton = By.cssSelector("li.main_nav_research > a");
    private final By researchAndEducation800x600 = By.xpath("//a[@href='#researchMenu']");
    private final By burgerMenu = By.xpath("//button[@class='toggleLeftNav']");
    private final By economicCalendarButton = By.xpath("//li[@class='menu-research']/a[text()[contains(., 'Economic Calendar')]]");
    private final By economicCalendar800x600 = By.xpath("//i[@class='fa fa-calendar']/..");

    public HomePage acceptAllCookies() {
        WebElement isModalDialogPresent = driver.findElement(modalDialog);
        if (isModalDialogPresent.isDisplayed())
            driver.findElement(acceptAllButton).click();
        return this;

    }

    public HomePage openEconomicCalendarPage() {
        if (getScreenResolution().equals(Config.SCREEN_RESOLUTION_800_600) || getScreenResolution().equals(Config.TEST_SCREEN_RESOLUTION_800_600)) {
            driver.findElement(burgerMenu).click();
            waitElementIsVisibleLocatedBy(researchAndEducation800x600);
            driver.findElement(researchAndEducation800x600).click();
            waitElementIsVisibleLocatedBy(economicCalendar800x600);
            driver.findElement(economicCalendar800x600).click();
        } else if (getScreenResolution().equals(Config.SCREEN_RESOLUTION_MAXIMUM) || getScreenResolution().equals(Config.TEST_SCREEN_RESOLUTION_MAXIMUM)) {
            driver.findElement(researchAndEducationButton).click();
            waitElementIsVisibleLocatedBy(economicCalendarButton);
            WebElement btnEconomicCalendar = driver.findElement(economicCalendarButton);
            waitElementIsVisible(btnEconomicCalendar).click();
        } else if (getScreenResolution().equals(Config.SCREEN_RESOLUTION_1024_768) || getScreenResolution().equals(Config.TEST_SCREEN_RESOLUTION_1024_768)) {
            driver.findElement(researchAndEducationButton).click();
            WebElement btnEconomicCalendar = driver.findElement(economicCalendarButton);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", btnEconomicCalendar);
            driver.findElement(economicCalendarButton).click();
        }
        return this;
    }
}
