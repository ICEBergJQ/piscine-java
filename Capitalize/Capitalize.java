package Capitalize;
import java.io.*;

public class Capitalize {
    public static void capitalize(String[] args) throws IOException {
        if (args.length < 2) {
            return;
        }

        String inputFile = args[0];
        String outputFile = args[1];

        try (
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))
        ) {
            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(capitalizeLine(line));
                writer.newLine();
            }
        }
    }

    private static String capitalizeLine(String line) {
        StringBuilder sb = new StringBuilder();
        boolean capitalizeNext = true;

        for (char c : line.toCharArray()) {
            if (Character.isWhitespace(c)) {
                capitalizeNext = true;
                sb.append(c);
            } else if (capitalizeNext) {
                sb.append(Character.toUpperCase(c));
                capitalizeNext = false;
            } else {
                sb.append(Character.toLowerCase(c));
            }
        }
        return sb.toString();
    }
}
