package tests;

import assertions.Assertion;
import assertions.DateVerifier;
import constants.Constant;
import helpers.ScreenDataProvider;
import org.openqa.selenium.Dimension;
import org.testng.annotations.Test;
import utils.Config;

public class RegressionTest extends BaseTest {

    @Test(dataProvider = "getScreenResolution", dataProviderClass = ScreenDataProvider.class)
    public void useCaseTest(Dimension screenResolution) throws InterruptedException {
        setScreenResolution(screenResolution);
        basePage.open(Config.BASE_URL);
        homePage
                .acceptAllCookies()
                .openEconomicCalendarPage();

        Assertion.verifyIsCalendarPageTitleCorrect(Constant.PageTitles.ECONOMIC_CALENDAR_PAGE_TITLE, driver.getTitle());
        Assertion.verifyIsEconomicCalendarHeadingDisplayed(economicCalendarPage.checkIsEconomicCalendarHeadingDisplayed());
        economicCalendarPage.selectCalendarFrame();
        economicCalendarPage.clickOnDay(Constant.DaySelectors.YESTERDAY);
        DateVerifier.verifyIsYesterdayDateCorrect(economicCalendarPage.getDateFromWidget());
        economicCalendarPage.clickOnDay(Constant.DaySelectors.TODAY);
        DateVerifier.verifyIsTodayDateCorrect(economicCalendarPage.getDateFromWidget());
        economicCalendarPage.clickOnDay(Constant.DaySelectors.TOMORROW);
        DateVerifier.verifyIsTomorrowDateCorrect(economicCalendarPage.getDateFromWidget());
        economicCalendarPage.clickOnDay(Constant.DaySelectors.THIS_WEEK);
        DateVerifier.verifyIsWeekIsCorrect(economicCalendarPage.getDateFromWidget());
        economicCalendarPage.openRiskWarningPage();

        Assertion.verifyIsWarningRiskPageLinkCorrect(driver.getCurrentUrl(), Constant.PageUrls.RISK_WARNING_PAGE_URL);
        riskWarningPage.openDocumentInNewTab();
        switchToNewOpenedTab();
        Assertion.verifyIsNewTabOpened(driver.getTitle(), Constant.PageTitles.RISK_WARNING);

    }
}
