package ui.timezone;

import base.pages.BasePage;
import base.pages.EventPage;
import base.pages.SettingsPage;
import core.BaseTest;
import core.ui.dto.events.Event;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.testng.Tag;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static base.helpers.Date.convertUTCTimeToMinutes;
import static base.helpers.Date.getCurrentTimeZoneUTC;
import static core.ui.tests.TimeZoneTests.verifyPageIsSameAfterChangeTimeZone;
import static io.qameta.allure.SeverityLevel.NORMAL;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@Feature("Event time zone change feature")
@Tag("ui")
public class TimeZoneChangeTest extends BaseTest {
    BasePage basePage;
    SettingsPage settingsPage;
    EventPage eventPage;

    @BeforeClass
    public void beforeTimeZoneChangeTest() {
        basePage = new BasePage();
        settingsPage = new SettingsPage();
        eventPage = new EventPage();

        basePage.openMainPage();
    }

    @Owner("nazarii_dzhevaga")
    @Severity(NORMAL)
    @Description("Verify that changing the time zone updates event start time")
    @Test()
    public void verifyTimeZoneChange() {
        basePage.clickOnEvent(eventPage.getRandomNotStartedEvent());
        Event eventBeforeTimezoneChange = new Event();

        basePage.openMenuSettings();
        String selectedRandomTimeZoneUTC = settingsPage.selectRandomTimeZoneExcludingAutomatic();

        settingsPage.clickApplyButton();
        Event eventAfterTimezoneChange = new Event();

        verifyPageIsSameAfterChangeTimeZone(eventBeforeTimezoneChange, eventAfterTimezoneChange);

        String currentTimeZoneUTC = getCurrentTimeZoneUTC();
        int utcMinutesDifference = eventPage.calculateUtcMinutesDifference(convertUTCTimeToMinutes(currentTimeZoneUTC), convertUTCTimeToMinutes(selectedRandomTimeZoneUTC), selectedRandomTimeZoneUTC);
        eventBeforeTimezoneChange.setEventDate(eventBeforeTimezoneChange.getEventDate().plusMinutes(utcMinutesDifference));

        assertThat("Event date after changing utc timezone is not correct. Current utc: " + currentTimeZoneUTC + ", selected: " + selectedRandomTimeZoneUTC, eventAfterTimezoneChange.getEventDate(), equalTo(eventBeforeTimezoneChange.getEventDate()));
    }
}
