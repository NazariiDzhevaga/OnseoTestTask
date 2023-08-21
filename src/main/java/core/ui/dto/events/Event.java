package core.ui.dto.events;

import base.helpers.Date;

import java.time.LocalDateTime;
import java.util.Objects;

import static base.pages.EventPage.*;
import static com.codeborne.selenide.Selenide.$x;

public class Event {

    public String sportSection;
    public String leagueSection;
    public String countryFlag;
    public String eventLeague;
    public String eventCountry;
    public String firstCompetitor;
    public String secondCompetitor;
    public String scoreOrTime;
    public String sevStatus;
    public LocalDateTime eventDate;

    public Event() {
        this.sportSection = $x(activeSportSection).text();
        this.leagueSection = $x(activeLeagueSection).text();
        this.countryFlag = $x(eventHeaderFlag).getAttribute("alt");
        this.eventLeague = $x(eventHeaderLeague).text();
        this.eventCountry = $x(eventHeaderCountry).text();
        this.firstCompetitor = $x(eventFirstCompetitor).text();
        this.secondCompetitor = $x(eventSecondCompetitor).text();
        this.scoreOrTime = $x(eventScoreOrTime).text();
        this.sevStatus = $x(eventSevStatus).text();
        if (this.scoreOrTime.contains(":")) {
            this.eventDate = Date.convertEventDataToLocalDateTime(scoreOrTime, sevStatus);
        }
    }

    public String getSportSection() {
        return sportSection;
    }

    public void setSportSection(String sportSection) {
        this.sportSection = sportSection;
    }

    public String getEventLeague() {
        return eventLeague;
    }

    public void setEventLeague(String eventLeague) {
        this.eventLeague = eventLeague;
    }

    public String getCountryFlag() {
        return countryFlag;
    }

    public void setCountryFlag(String countryFlag) {
        this.countryFlag = countryFlag;
    }

    public String getEventCountry() {
        return eventCountry;
    }

    public void setEventCountry(String eventCountry) {
        this.eventCountry = eventCountry;
    }

    public String getFirstCompetitor() {
        return firstCompetitor;
    }

    public void setFirstCompetitor(String firstCompetitor) {
        this.firstCompetitor = firstCompetitor;
    }

    public String getSecondCompetitor() {
        return secondCompetitor;
    }

    public void setSecondCompetitor(String secondCompetitor) {
        this.secondCompetitor = secondCompetitor;
    }

    public String getScoreOrTime() {
        return scoreOrTime;
    }

    public void setScoreOrTime(String scoreOrTime) {
        this.scoreOrTime = scoreOrTime;
    }

    public String getSevStatus() {
        return sevStatus;
    }

    public void setSevStatus(String sevStatus) {
        this.sevStatus = sevStatus;
    }

    public LocalDateTime getEventDate() {
        return eventDate;
    }

    public void setEventDate(LocalDateTime eventDate) {
        this.eventDate = eventDate;
    }

    @Override
    public String toString() {
        return "Event{" +
                "sportSection='" + sportSection + '\'' +
                ", eventLeague='" + eventLeague + '\'' +
                ", countryFlag='" + countryFlag + '\'' +
                ", eventCountry='" + eventCountry + '\'' +
                ", firstCompetitor='" + firstCompetitor + '\'' +
                ", secondCompetitor='" + secondCompetitor + '\'' +
                ", scoreOrTime='" + scoreOrTime + '\'' +
                ", sevStatus='" + sevStatus + '\'' +
                ", eventDate=" + eventDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return Objects.equals(sportSection, event.sportSection) && Objects.equals(eventLeague, event.eventLeague) && Objects.equals(countryFlag, event.countryFlag) && Objects.equals(eventCountry, event.eventCountry) && Objects.equals(firstCompetitor, event.firstCompetitor) && Objects.equals(secondCompetitor, event.secondCompetitor) && Objects.equals(scoreOrTime, event.scoreOrTime) && Objects.equals(sevStatus, event.sevStatus) && Objects.equals(eventDate, event.eventDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sportSection, eventLeague, countryFlag, eventCountry, firstCompetitor, secondCompetitor, scoreOrTime, sevStatus, eventDate);
    }
}
