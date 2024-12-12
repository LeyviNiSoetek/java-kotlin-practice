package org.example.time;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Legacy date/time-related APIs (< Java 8), like Calendar, Date, SimpleDateFormater ... etc.
 */
public class LegacyTimeTester {
    public static void main(String[] args) {
//        dateFormatPractice();
        calendarPractice();
    }

    private static void calendarPractice() {
        // NOTE: Calender instances are mutable
//        calendarLeniencePractice();
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar.getTime());
        calendar.add(Calendar.YEAR, 3);
        System.out.println(calendar.getTime());
        calendar.add(Calendar.MONTH, 13);
        System.out.println(calendar.getTime());
    }

    private static void calendarLeniencePractice() {
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar);
        System.out.println(calendar.getTime());

        calendar.set(Calendar.YEAR, 2025);

        calendar.setLenient(true); // NOTE: `true` is the default
        System.out.println("isLenient: " + calendar.isLenient());
        calendar.set(Calendar.MONTH, Calendar.MARCH);
        calendar.set(Calendar.DAY_OF_MONTH, 35);
        System.out.println(calendar.getTime()); // this updates internal fields and gives date of April 04

        calendar.setLenient(false);
        System.out.println("isLenient: " + calendar.isLenient());
        System.out.println(calendar.getTime()); // still gives date of April 04 since it was once corrected
        calendar.set(Calendar.MONTH, Calendar.MARCH);
        calendar.set(Calendar.DAY_OF_MONTH, 35); // now the internal day of month is a invalid value
        System.out.println(calendar); // this is fine (no exceptions thrown)
        try {
            System.out.println(calendar.getTime()); // this throws IllegalArgumentException
        } catch (Exception e) {
            System.out.println("oh-oh.");
            e.printStackTrace();
        }
    }

    private static void dateFormatPractice() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXX");
        System.out.println(dateFormat.format(new Date()));
        System.out.println(dateFormat.format(Calendar.getInstance().getTime()));
        try {
            System.out.println("Please enter a time that's in the format above: ");
            String timeString = new BufferedReader(new InputStreamReader(System.in)).readLine();
            Date parsedDate = dateFormat.parse(timeString);
            System.out.println(parsedDate);
        } catch (IOException | ParseException e) {
            e.printStackTrace();
            System.out.println("Failed to parse date");
            throw new RuntimeException(e);
        }
    }
}
