package assertions;

import org.testng.Assert;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import static java.time.temporal.ChronoUnit.DAYS;

public class DateVerifier {

    private static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private static ZoneId timezone = ZoneId.of("Europe/Dublin");

    public static void verifyIsYesterdayDateCorrect(String date) {
        LocalDate today = LocalDate.now(timezone);
        LocalDate beforeToday = today.minusDays(1);
        String yesterday = dateTimeFormatter.format(beforeToday);
        String[] dates = date.split(" - ");
        Assert.assertEquals(yesterday, dates[0]);
        Assert.assertEquals(yesterday, dates[1]);
    }

    public static void verifyIsTodayDateCorrect(String date) {
        String today = dateTimeFormatter.format(LocalDate.now(timezone));
        String[] dates = date.split(" - ");
        Assert.assertEquals(today, dates[0]);
        Assert.assertEquals(today, dates[1]);
    }

    public static void verifyIsTomorrowDateCorrect(String date) {
        LocalDate today = LocalDate.now(timezone);
        LocalDate afterToday = today.plusDays(1);
        String tomorrow = dateTimeFormatter.format(afterToday);
        String[] dates = date.split(" - ");
        Assert.assertEquals(tomorrow, dates[0]);
        Assert.assertEquals(tomorrow, dates[1]);
    }

    public static void verifyIsWeekIsCorrect(String date) {
        LocalDate today = LocalDate.now(timezone);
        String[] dates = date.split(" - ");
        LocalDate firstDayOfTheWeek = LocalDate.parse(dates[0], dateTimeFormatter);
        LocalDate lastDayOfTheWeek = LocalDate.parse(dates[1], dateTimeFormatter);
        long dayBetween = DAYS.between(firstDayOfTheWeek, lastDayOfTheWeek);
        Assert.assertEquals(6, dayBetween);
        if (today.isAfter(firstDayOfTheWeek) || today.isEqual(firstDayOfTheWeek))
            Assert.assertTrue(true);
        else Assert.assertTrue(false);
        if (today.isBefore(lastDayOfTheWeek) || today.isEqual(lastDayOfTheWeek))
            Assert.assertTrue(true);
        else Assert.assertTrue(false);
    }

}
