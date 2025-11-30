package com.airtripe.studentmanagement.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateUtil {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public static LocalDate parseDate(String input) {
        try {
            return LocalDate.parse(input, FORMATTER);
        } catch (DateTimeParseException e) {
            System.out.println("Invalid date format. Expected yyyy-MM-dd. Using today's date instead.");
            return LocalDate.now();
        }
    }

    public static String formatDate(LocalDate date) {
        return date.format(FORMATTER);
    }
}
