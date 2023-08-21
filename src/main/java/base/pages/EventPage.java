package base.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.Random;

import static base.constants.TimeZoneConstants.PLUS;
import static com.codeborne.selenide.Selenide.$$x;

public class EventPage extends BasePage{

    public static String activeSportSection ="//*[contains(@id, 'active') and contains(@id, 'sport-navigation')]";
    public static String activeLeagueSection ="//*[@id='exploreMenuList']//*[@data-active='true']";
    public static String eventHeader = centerContent + "//*[contains(@id, 'category-header__link')]";
    public static String eventHeaderFlag = eventHeader + "//*[@alt]";
    public static String eventHeaderLeague = eventHeader + "//*[@id='category-header__stage']";
    public static String eventHeaderCountry = eventHeader + "//*[@id='category-header__category']";
    public static String eventFirstCompetitor = centerContent + "//*[@data-testid='match-detail_team-name_home']";
    public static String eventSecondCompetitor = centerContent + "//*[@data-testid='match-detail_team-name_away']";
    public static String eventScoreOrTime = centerContent + "//*[@id='score-or-time']";
    public static String eventSevStatus = centerContent + "//*[@id='SEV__status']";

    public int calculateUtcMinutesDifference(int currentTimeZoneMinutes, int randomTimeZoneMinutes, String selectedRandomTimeZoneUTC) {
        //When dealing with negative UTC offsets, it's important to subtract both the current UTC minutes and the selected negative UTC minutes.
        //For instance, consider a scenario where the base UTC offset is +03:00 (180 minutes) and the chosen UTC offset is -02:00 (120 minutes).
        //In this case, the calculation involves subtracting both 180 and 120 minutes (a total of 300 minutes) from the current event date and time
        if (selectedRandomTimeZoneUTC.contains(PLUS)) {
            return randomTimeZoneMinutes - currentTimeZoneMinutes;
        } else {
            return Math.negateExact(currentTimeZoneMinutes + randomTimeZoneMinutes);
        }
    }

    public SelenideElement getRandomNotStartedEvent() {
        ElementsCollection eventsNotStarted = $$x(notStartedEvents);
        //Select tomorrow's date if there are no events that haven't started yet for today
        if (notStartedEvents.isEmpty()) {
            selectNextDayOnMatchCalendar();
            eventsNotStarted = $$x(notStartedEvents);
        }
        return eventsNotStarted.get(new Random().nextInt(eventsNotStarted.size()));
    }
}
