package constants;

import org.openqa.selenium.By;

public class Constant {

    public static class TimeoutVariables {

        public static final int IMPLICIT_WAIT = 5;
        public static final int EXPLICIT_WAIT = 10;
    }

    public static class PageTitles {

        public static final String ECONOMIC_CALENDAR_PAGE_TITLE = "Economic Calendar";
        public static final String RISK_WARNING = "Research";
    }

    public static class DaySelectors {
        public static final By YESTERDAY = By.id("timeFrame_yesterday");
        public static final By TODAY = By.id("timeFrame_today");
        public static final By TOMORROW = By.id("timeFrame_tomorrow");
        public static final By THIS_WEEK = By.id("timeFrame_thisWeek");
    }

    public static class PageUrls {
        public static final String RISK_WARNING_PAGE_URL = "https://www.xm.com/research/risk_warning";
    }

}
