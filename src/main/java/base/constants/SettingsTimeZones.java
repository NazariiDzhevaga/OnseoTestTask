package base.constants;

public enum SettingsTimeZones {
    AUTOMATIC("Automatic"),
    UTC_MINUS_11("UTC -11:00"),
    UTC_MINUS_10("UTC -10:00"),
    UTC_MINUS_9_30("UTC -09:30"),
    UTC_MINUS_9("UTC -09:00"),
    UTC_MINUS_8_30("UTC -08:30"),
    UTC_MINUS_8("UTC -08:00"),
    UTC_MINUS_7("UTC -07:00"),
    UTC_MINUS_6("UTC -06:00"),
    UTC_MINUS_5("UTC -05:00"),
    UTC_MINUS_4_30("UTC -04:30"),
    UTC_MINUS_4("UTC -04:00"),
    UTC_MINUS_3_30("UTC -03:30"),
    UTC_MINUS_3("UTC -03:00"),
    UTC_MINUS_2_30("UTC -02:30"),
    UTC_MINUS_2("UTC -02:00"),
    UTC_MINUS_1("UTC -01:00"),
    UTC_0("UTC +00:00"),
    UTC_1("UTC +01:00"),
    UTC_2("UTC +02:00"),
    UTC_3("UTC +03:00"),
    UTC_3_30("UTC +03:30"),
    UTC_4("UTC +04:00"),
    UTC_4_30("UTC +04:30"),
    UTC_5("UTC +05:00"),
    UTC_5_30("UTC +05:30"),
    UTC_5_45("UTC +05:45"),
    UTC_6("UTC +06:00"),
    UTC_6_30("UTC +06:30"),
    UTC_6_45("UTC +06:45"),
    UTC_7("UTC +07:00"),
    UTC_7_30("UTC +07:30"),
    UTC_8("UTC +08:00"),
    UTC_8_30("UTC +08:30"),
    UTC_8_45("UTC +08:45"),
    UTC_9("UTC +09:00"),
    UTC_9_30("UTC +09:30"),
    UTC_9_45("UTC +09:45"),
    UTC_10("UTC +10:00"),
    UTC_10_30("UTC +10:30"),
    UTC_11("UTC +11:00"),
    UTC_11_30("UTC +11:30"),
    UTC_12("UTC +12:00"),
    UTC_12_30("UTC +12:30"),
    UTC_12_45("UTC +12:45"),
    UTC_13("UTC +13:00"),
    UTC_13_45("UTC +13:45"),
    UTC_14("UTC +14:00");

    private final String time;

    public String getTimeZone() {
        return time;
    }

    SettingsTimeZones(String timeZone) {
        this.time = timeZone;
    }
}
