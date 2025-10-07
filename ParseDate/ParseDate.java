import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParseDate {

    public static LocalDateTime parseIsoFormat(String stringDate) {
        return LocalDateTime.parse(stringDate);
    }

    public static LocalDate parseFullTextFormat(String stringDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE dd MMMM yyyy", Locale.ENGLISH);
        return LocalDate.parse(stringDate, formatter);
    }

    public static LocalTime parseTimeFormat(String stringDate) {
        if (stringDate == null)
            return null;

        stringDate = stringDate.toLowerCase();

        Pattern pattern = Pattern.compile("(\\d+)");
        Matcher matcher = pattern.matcher(stringDate);

        int[] values = new int[3];
        int i = 0;

        while (matcher.find() && i < 3) {
            values[i++] = Integer.parseInt(matcher.group(1));
        }

        int hour = values[0];
        int minute = values[1];
        int second = values[2];

        if (stringDate.contains("evening") || stringDate.contains("afternoon")) {
            if (hour < 12)
                hour += 12;
        } else if (stringDate.contains("morning") && hour == 12) {
            hour = 0;
        }

        return LocalTime.of(hour, minute, second);
    }

}
