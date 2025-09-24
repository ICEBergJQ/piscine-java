
// package Capitalize;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Capitalize {
    public static void capitalize(String[] args) throws IOException {
        if (args.length != 2) {
            return;
        }

        String inputFile = args[0];
        String outputFile = args[1];

        try (
                BufferedReader reader = new BufferedReader(new FileReader(inputFile));
                BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            String content = new String(Files.readAllBytes(Paths.get(inputFile)), StandardCharsets.UTF_8);
            String[] lines = content.split("\n", -1); 
            for (int i = 0; i < lines.length; i++) {
                writer.write(capitalizeLine(lines[i]));
                if (i < lines.length - 1) {
                    writer.newLine();
                }
            }
            writer.close();

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
