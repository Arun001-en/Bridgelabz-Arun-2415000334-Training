import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public interface DateFormatUtility {
    // Static method to format dates in different patterns
    static String formatDate(LocalDate date, String pattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return date.format(formatter);
    }
}
