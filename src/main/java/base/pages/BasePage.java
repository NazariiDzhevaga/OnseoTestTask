package base.pages;

import base.constants.Hosts;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.core.Is.is;

public class BasePage {
    public static String cookieBanner = "//a[contains(text(), 'Cookie Policy')]";
    public static String simpleCookieBar = "//*[@id='simpleCookieBar']";
    public static String cookieConsentBanner = "//*[@id='onetrust-group-container']";
    public static String cookieConsentBannerAcceptButton = "//*[@id='onetrust-accept-btn-handler']";
    public static String simpleCookieBarCloseButton = "//*[@id='simpleCookieBarCloseButton']";
    public String notStartedEvents = "//div[contains(@id, 'match-row')][ not(contains(@id, '__live'))][@class='np rp']//*[contains(text(), ':')]/../..";
    public String matchRowsCalendarToday = "//*[contains(@data-testid, '-active')]";
    public String matchRowsCalendarTomorrow = matchRowsCalendarToday + "/following-sibling::*[1]";
    public String siteMenu = "//*[@id='burger-menu-open']";
    public String siteMenuBody = "//*[@id='burger-menu-body']";
    public String siteMenuSettings = "//*[@id='burger-menu__settings']";
    public static String centerContent = "//*[@id='content-center']";

    @Step("Open main page")
    public void openMainPage() {
        open(Hosts.LIVE_SCORE.getPath());
        waitForCookieBanner();
        closeCookieBanner();
        closeCookieConsentBanner();
    }

    public static void waitForCookieBanner() {
        $x(cookieBanner).shouldHave(visible);
    }

    @Step("Close cookie banner")
    public static void closeCookieBanner() {
        if ($x(simpleCookieBar).is(visible)) {
            $x(simpleCookieBarCloseButton).scrollIntoView("{block: \"center\"}").shouldHave().click();
        }
    }

    @Step("Close cookie consent banner")
    public static void closeCookieConsentBanner() {
        if ($x(cookieConsentBanner).is(visible)) {
            $x(cookieConsentBannerAcceptButton).scrollIntoView("{block: \"center\"}").shouldHave().click();
        }
    }

    @Step("Select next day on match calendar")
    public void selectNextDayOnMatchCalendar() {
        String chosenDateBeforeSelect = $x(matchRowsCalendarToday).scrollIntoView("{block: \"center\"}").shouldHave(visible).text();
        $x(matchRowsCalendarTomorrow).scrollIntoView("{block: \"center\"}").shouldHave(visible).click();
        String currentChosenDateAfterSelect = $x(matchRowsCalendarToday).scrollIntoView("{block: \"center\"}").shouldHave(visible).text();
        assertThat("After selection next day on match calendar day is not changed", chosenDateBeforeSelect, is(not(equalTo(currentChosenDateAfterSelect))));
    }

    @Step("Click on event")
    public void clickOnEvent(SelenideElement event) {
        event.scrollIntoView("{block: \"center\"}").shouldHave(visible).click();
    }

    @Step("Open site menu")
    public void openSiteMenu() {
        $x(siteMenu).scrollIntoView("{block: \"center\"}").shouldHave(visible).click();
        $x(siteMenuBody).shouldHave(visible);
    }

    @Step("Open menu settings")
    public void openMenuSettings() {
        openSiteMenu();
        $x(siteMenuSettings).shouldHave(visible).click();
        $x(centerContent).shouldHave(Condition.partialText("Settings"));
    }
}
