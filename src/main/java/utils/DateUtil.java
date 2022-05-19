package utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

// Utility class for formatting Dates
public class DateUtil {
    // Formatter for all Date objects
    private static final DateTimeFormatter formatter =
            DateTimeFormatter.ofPattern("yyyy-MM-dd'T'hh:mm:ssz", Locale.ENGLISH);

    // Method to parse Strings to a LocalDate objects
    public static LocalDate parseDate(String date_str) {
        return LocalDate.parse(date_str, formatter);
    }
}
