package org.example.time;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.UnsupportedTemporalTypeException;

/**
 * Modern date/time-related APIs (>= Java 8),
 * like Instant, LocalDateTime, ZonedDateTime, DateTimeFormatter ... etc.
 */
public class ModernTimeTester {
    // TODO: available values?
    private static final ZoneId zoneIdUtc = ZoneId.of("UTC");
    private static final ZoneId zoneIdTaipei = ZoneId.of("Asia/Taipei");
    private static final ZoneId zoneIdTokyo = ZoneId.of("Asia/Tokyo");
    private static final ZoneId zoneIdSystem = ZoneId.systemDefault();
    public static void main(String[] args) {
//        instantAndDateTime();
        LocalDate.of(2024, 1, 1);
        LocalTime.of(0, 0);
        LocalDateTime.of(2024, 1, 1, 0, 0);
        LocalDateTime.of(
                LocalDate.of(2024, 1, 1),
                LocalTime.of(0, 0)
        );
    }

    private static void instantAndDateTime() {
        DateTimeFormatter formatterWithTimezone = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSXX");
        DateTimeFormatter formatterWithoutTimezone = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS");
        // an "instant" in different timezone
        Instant miko1stSoloLiveStartInstant = Instant.ofEpochMilli(1729933200000L); // 2024-10-26T18:00+0900
        Instant miko1stSoloLiveEndInstant = miko1stSoloLiveStartInstant.plus(Duration.ofHours(2));
        System.out.println(formatterWithTimezone.withZone(zoneIdUtc).format(miko1stSoloLiveStartInstant));
        System.out.println(formatterWithTimezone.withZone(zoneIdTaipei).format(miko1stSoloLiveStartInstant));
        System.out.println(formatterWithTimezone.withZone(zoneIdTokyo).format(miko1stSoloLiveStartInstant));

        ZonedDateTime zonedDateTime = miko1stSoloLiveStartInstant.atZone(zoneIdTokyo);
        LocalDateTime localDateTime = LocalDateTime.ofInstant(miko1stSoloLiveStartInstant, zoneIdUtc);
        // NOTE: `DateTimeFormatter::format(*DateTime)` and `*DateTime::format(DateTimeFormatter)` are almost (?) the same;
        //       they are just different favors.
        System.out.println(formatterWithTimezone.format(zonedDateTime));

        System.out.println(formatterWithoutTimezone.format(localDateTime));

        try {
            // formatter tries to use the LocalDateTime instances' timezone offset
            System.out.println(formatterWithTimezone.format(localDateTime)); // UnsupportedTemporalTypeException: Unsupported field: OffsetSeconds
        } catch (UnsupportedTemporalTypeException e) {
            e.printStackTrace();
        }

    }
}
