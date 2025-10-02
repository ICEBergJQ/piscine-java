import java.util.Set;
import java.util.Map;

public class Wedding {
    public static Map<String, String> createCouple(Set<String> first, Set<String> second) {
        if (first.size() != second.size()) {
            throw new IllegalArgumentException("Sets must be of equal size");
        }

        return first.stream()
                .sorted()
                .collect(java.util.stream.Collectors.toMap(
                        name -> name,
                        name -> {
                            String partner = second.stream()
                                    .sorted()
                                    .skip(first.stream().sorted().toList().indexOf(name))
                                    .findFirst()
                                    .orElseThrow();
                            return partner;
                        }));
    }
}