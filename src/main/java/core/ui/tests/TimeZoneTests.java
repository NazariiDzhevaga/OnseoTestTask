package core.ui.tests;

import core.ui.dto.events.Event;
import org.testng.asserts.SoftAssert;

public class TimeZoneTests {
    public static void verifyPageIsSameAfterChangeTimeZone(Event eventBeforeTimezoneChange, Event eventAfterTimezoneChange) {
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(eventBeforeTimezoneChange.getSportSection(), eventAfterTimezoneChange.getSportSection(), "There is no 5 days in report file");
        softAssert.assertEquals(eventBeforeTimezoneChange.getEventLeague(), eventAfterTimezoneChange.getEventLeague(), "There is no 5 days in report file");
        softAssert.assertEquals(eventBeforeTimezoneChange.getEventCountry(), eventAfterTimezoneChange.getEventCountry(), "There is no 5 days in report file");
        softAssert.assertEquals(eventBeforeTimezoneChange.getFirstCompetitor(), eventAfterTimezoneChange.getFirstCompetitor(), "There is no 5 days in report file");
        softAssert.assertEquals(eventBeforeTimezoneChange.getSecondCompetitor(), eventAfterTimezoneChange.getSecondCompetitor(), "There is no 5 days in report file");
        softAssert.assertEquals(eventBeforeTimezoneChange.getCountryFlag(), eventAfterTimezoneChange.getCountryFlag(), "There is no 5 days in report file");

        softAssert.assertAll();
    }
}
