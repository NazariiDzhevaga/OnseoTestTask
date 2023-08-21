package base.helpers;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZonedDateTime;
import java.util.Arrays;

public class Date {

    public static String getCurrentTimeZoneUTC() {
        return ZonedDateTime.now().getOffset().getId();
    }

    public static LocalDateTime convertEventDataToLocalDateTime(String time, String day) {
        LocalDateTime convertedDate = LocalDateTime.now();
        if (!day.equals("Today")) {
            String[] dateAndMonth = day.split(" ");
            int desiredDay = Integer.parseInt(dateAndMonth[0]);
            Month desiredMonth = Arrays.stream(Month.values()).filter(e -> e.name().contains(dateAndMonth[1].toUpperCase())).findFirst().get();
            convertedDate = convertedDate.withMonth(desiredMonth.getValue()).withDayOfMonth(desiredDay);
        }
        String[] hoursAndMinutes = time.split(":");
        LocalTime desiredTime = LocalTime.of(Integer.parseInt(hoursAndMinutes[0]), Integer.parseInt(hoursAndMinutes[1]));
        return convertedDate.with(desiredTime);
    }

    public static int convertUTCTimeToMinutes(String timeZone) {
        timeZone = timeZone.replaceAll("UTC ", "");
        int hours = Integer.parseInt(timeZone.substring(1, 3));
        int minutes = Integer.parseInt(timeZone.substring(4, 6));

        return (hours * 60) + minutes;
    }
}
