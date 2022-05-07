import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DateUtil {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'hh:mm:ssz", Locale.ENGLISH);
    public static LocalDate parseDate(String date_str) {
        return LocalDate.parse(date_str, formatter);
    }
}
