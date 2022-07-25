package assertions;

import org.testng.asserts.SoftAssert;

import static org.testng.Assert.assertTrue;

public class Assertion {

    public static final SoftAssert assertion = new SoftAssert();

    public static void verifyIsCalendarPageTitleCorrect(String title, String titleInDom) {
        assertion.assertEquals(title, titleInDom);
    }

    public static void verifyIsEconomicCalendarHeadingDisplayed(Boolean isEconomicalCalendarHeadingPresence) {
        assertTrue(isEconomicalCalendarHeadingPresence);
    }

    public static void verifyIsWarningRiskPageLinkCorrect(String actualUrl, String expectedUrl) {
        assertion.assertEquals(actualUrl, expectedUrl);
    }

    public static void verifyIsNewTabOpened(String actualPageTitle, String pageTitleFromPreviousTab) {
        assertion.assertFalse(actualPageTitle.equals(pageTitleFromPreviousTab));
    }

}
