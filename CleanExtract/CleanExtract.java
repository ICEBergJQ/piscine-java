public class CleanExtract {
    public static String extract(String s) {
        String[] parts = s.split("\\|");
        String result = "";

        for (int y = 0; y < parts.length; y++) {
            String part = parts[y].trim();
            Boolean flag = part.endsWith(".");
            String temp = "";
            Boolean f = false;
            for (int i = 0; i < part.length(); i++) {
                 if (part.charAt(i) == '.') {
                     f = true;
                 }
                 if (f) {
                    temp += part.charAt(i);
                 }

            }
            part = temp.replace(".", "");
            part = part.trim();
            if (flag) {
                part = part+".";
            }

            if (!part.isEmpty()) {
                if (result.length() > 0) {
                    result+= " ";
                }
                result += part;
            }
        }
        // System.out.println("\'"+result+"\'");

        if (result.endsWith(".")) {
            result = result.replace(" .", "");
            result = result.replace(".", "");
            return result + ".";
        }

        return result.replace(".", "");
    }
}

// 'The quick brown fox Jumps over the lazy dog.', 'The quick brown what do you fox Jumps over the lazy dog.' was returned
// java.lang.AssertionError: Should return 'The quick brown fox Jumps over the lazy dog.', 'The quick brown what do you fox Jumps over the lazy dog.'
