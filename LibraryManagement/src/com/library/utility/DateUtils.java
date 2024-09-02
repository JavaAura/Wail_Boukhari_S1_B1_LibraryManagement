package com.library.utility;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateUtils {
    private static final DateTimeFormatter DEFAULT_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static LocalDate stringToDate(String dateString) {
        return stringToDate(dateString, DEFAULT_FORMATTER);
    }

    public static LocalDate stringToDate(String dateString, DateTimeFormatter formatter) {
        try {
            return LocalDate.parse(dateString, formatter);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Invalid date format. Please use the format " + formatter.toString() + ".", e);
        }
    }

    public static String dateToString(LocalDate date) {
        return dateToString(date, DEFAULT_FORMATTER);
    }

    public static String dateToString(LocalDate date, DateTimeFormatter formatter) {
        return date.format(formatter);
    }
    
    public static boolean isValidDate(String dateString, DateTimeFormatter formatter) {
        try {
            LocalDate.parse(dateString, formatter);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    public static boolean isValidDate(String dateString) {
        return isValidDate(dateString, DEFAULT_FORMATTER);
    }
}
