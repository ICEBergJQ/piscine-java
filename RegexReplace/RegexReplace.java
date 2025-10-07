import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexReplace {

    public static String removeUnits(String s) {
        if (s == null) return null;
        return s.replaceAll("(\\d+)(cm|€)(?=\\s|$)", "$1");
    }

    public static String obfuscateEmail(String s) {
        if (s == null) return null;

        String[] parts = s.split("@");
        if (parts.length != 2) return s;

        String username = parts[0];
        String domain = parts[1];

        username = obfuscateUsername(username);
        domain = obfuscateDomain(domain);

        return username + "@" + domain;
    }

    private static String obfuscateUsername(String username) {
        if (username.matches(".*[-._].*")) {
            return username.replaceAll("(?<=[-._]).", "*");
        }

        if (username.length() > 3) {
            return username.substring(0, username.length() - 3) + "***";
        }
        return username;
    }

    private static String obfuscateDomain(String domain) {
        String[] domainParts = domain.split("\\.");

        if (domainParts.length >= 3) {
            domainParts[0] = "*******";
            domainParts[domainParts.length - 1] = "***";
        } else if (domainParts.length == 2) {
            if (!domain.endsWith(".com") && !domain.endsWith(".org") && !domain.endsWith(".net")) {
                domainParts[0] = "*******";
                domainParts[1] = "**";
            } else {
                domainParts[0] = "*******";
            }
        }

        return String.join(".", domainParts);
    }
}
