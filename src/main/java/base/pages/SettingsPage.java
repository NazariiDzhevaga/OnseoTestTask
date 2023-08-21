package base.pages;

import base.constants.SettingsTimeZones;
import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import java.util.Random;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class SettingsPage extends BasePage {
    public String timeZone = "//*[@id='TZ_SELECT-label']";
    public String timeZoneSelections = "//*[contains(@class, 'selectItem')]";
    public String timeZoneToSet = timeZoneSelections + "[contains(text(), '%s')]";
    public String selectedTimeZone = "//*[@id='TZ_SELECT']";
    public String applyButton = "//*[@data-testid='settings-form_apply-button']";

    @Step("Click on apply button")
    public void clickApplyButton() {
        $x(applyButton).shouldHave(visible).click();
        $x(centerContent).shouldNotHave(Condition.partialText("Settings"));
    }

    public String selectRandomTimeZoneExcludingAutomatic() {
        return selectTimeZone(getRandomTimeZoneExcludingAutomatic());
    }

    @Step("Select time zone {0}")
    public String selectTimeZone(SettingsTimeZones timeZones) {
        openTimeZoneDropdownMenu();
        $x(String.format(timeZoneToSet, timeZones.getTimeZone())).click();
        $x(selectedTimeZone).shouldHave(text(timeZones.getTimeZone()));
        return $x(selectedTimeZone).text();
    }

    @Step("Open time zone dropdown menu")
    public void openTimeZoneDropdownMenu() {
        if ($x(timeZoneSelections).is(Condition.not(visible))) {
            $x(timeZone).shouldHave(Condition.partialText("UTC")).click();
        }
        $$x(timeZoneSelections).shouldHave(CollectionCondition.size(49));
    }

    public static SettingsTimeZones getRandomTimeZoneExcludingAutomatic() {
        Random random = new Random();
        SettingsTimeZones[] timeZones = SettingsTimeZones.values();

        int randomIndex = random.nextInt(timeZones.length);
        if (randomIndex == SettingsTimeZones.AUTOMATIC.ordinal()) {
            randomIndex++;
        }

        return timeZones[randomIndex];
    }
}
