import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

public class StreamMap {
    public static Integer sumOfStringLength(Stream<String> s) {
        return s.mapToInt(String::length).sum();
    }

    public static List<String> upperCaseAllString(Stream<String> s) {
        return s.map(String::toUpperCase).toList();
    }
    
    public static Set<Integer> uniqIntValuesGreaterThan42(Stream<Double> s) {
        return s.map(Double::intValue)
                .filter(n -> n > 42)
                .collect(java.util.stream.Collectors.toSet());
    }
}