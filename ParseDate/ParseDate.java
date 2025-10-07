import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class ParseDate {

    public static LocalDateTime parseIsoFormat(String stringDate) {
        return LocalDateTime.parse(stringDate);
    }

    public static LocalDate parseFullTextFormat(String stringDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE dd MMMM yyyy", Locale.ENGLISH);
        return LocalDate.parse(stringDate, formatter);
    }

    public static LocalTime parseTimeFormat(String stringDate) {
        if (stringDate == null) {
            return null;
        }
        String lower = stringDate.toLowerCase();

        int hours = Integer.parseInt(lower.split(" hours")[0].trim());
        int minutes = Integer.parseInt(lower.split(" ")[6].trim());
        int seconds = Integer.parseInt(lower.split(" ")[10].trim());

        if (lower.contains("evening") && hours < 12) {
            hours += 12;
        }

        return LocalTime.of(hours, minutes, seconds);
    }
}
