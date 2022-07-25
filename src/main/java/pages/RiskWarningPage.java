package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import utils.Config;

public class RiskWarningPage extends BasePage {

    public RiskWarningPage(WebDriver driver) {
        super(driver);
    }

    private final By here = By.xpath("//strong[text()='Risk Disclosure']/following-sibling::a");
    private final By bottomOfPage = By.xpath("//div[@class='dis70']");

    public void openDocumentInNewTab() {
        if (getScreenResolution().equals(Config.SCREEN_RESOLUTION_MAXIMUM) || getScreenResolution().equals(Config.TEST_SCREEN_RESOLUTION_MAXIMUM))
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", here);
        if (getScreenResolution().equals(Config.SCREEN_RESOLUTION_800_600) || getScreenResolution().equals(Config.TEST_SCREEN_RESOLUTION_800_600)
                || getScreenResolution().equals(Config.SCREEN_RESOLUTION_1024_768) || getScreenResolution().equals(Config.TEST_SCREEN_RESOLUTION_1024_768))
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", bottomOfPage);
        driver.findElement(here).click();
    }

}
