package org.example.time;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.YearMonth;
import java.util.*;

/**
 * Practice of manual implementation (without many of Java time APIs)
 * of day-of-year application.
 */
public class DayOfYear {
    public static void main(String[] args) {
        Calendar today = Calendar.getInstance();
        int year;
        int month;
        int day;

        year = getNumberFromInput("year", today.get(Calendar.YEAR), number -> true); // TODO: max/min limitation
        month = getNumberFromInput("month", today.get(Calendar.MONTH) + 1, number -> number >= 1 && number <= 12);
        day = getNumberFromInput("day", today.get(Calendar.DAY_OF_MONTH), number -> 1 <= number && number <= YearMonth.of(year, month).lengthOfMonth());
        System.out.printf("%02d-%02d is the %3dth day of %02d.\n", month, day, dayOfYear(year, month, day), year);
    }

    private interface NumberValidator {
        public boolean isValid(int number);
    }

    private static int getNumberFromInput(String caption, int fallback, NumberValidator validator) {
        BufferedReader userInputReader = new BufferedReader(new InputStreamReader(System.in));
        String lineRead;
        int number;

        while (true) {
            System.out.print("Please enter " + caption + "[" + fallback + "]: ");
            try {
                lineRead = userInputReader.readLine();
            } catch (IOException e) {
                System.out.println("Failed to read input.");
                throw new RuntimeException(e);
            }

            // TODO: null check?
            if (lineRead.isBlank()) {
                return fallback;
            }

            try {
                number = Integer.parseInt(lineRead);
            } catch (NumberFormatException e) {
                System.out.println(lineRead + " is not a number.");
                continue;
            }

            if (!validator.isValid(number)) {
                System.out.println(lineRead + " is not valid.");
                continue;
            }
            return number;
        }
    }

    private static boolean isLeapYear(int year) {
        // or simply `Year.isLeap(year)`
        return year % 400 == 0 || (year % 100 != 0 && year % 4 == 0);
    }

    private static final int[][] daysOfMonth = {
            {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31},
            {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}, // leap year
    };

    /**
     *
     * @param year 1-based year
     * @param month 1-based month
     * @param day 1-based day
     */
    private static int dayOfYear(int year, int month, int day) {
        final int[] daysOfMothToUse = daysOfMonth[isLeapYear(year) ? 1 : 0];
        int dayOfYear = 0;
        for (int i = 0; i < (month - 1); i++) {
            dayOfYear += daysOfMothToUse[i];
        }
        return dayOfYear + day;

        // or using `Calendar`:
        /*
        Calendar date = Calendar.getInstance();
        date.set(year, month - 1, day); // NOTE: Calendar uses 0-based month
        return date.get(Calendar.DAY_OF_YEAR);
        */
    }
}

