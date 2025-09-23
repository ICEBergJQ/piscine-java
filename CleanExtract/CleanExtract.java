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
                part = part + ".";
            }
            // if (part == "." && y == parts.length - 1) {
            //     continue;
            // }
            if (!part.isEmpty()) {
                if (result.length() > 0) {
                    result+= " ";
                }
                result += part;
            }
        }
        // System.out.println("\'"+result+"\'");
         if (result.endsWith(" .")) {
            result = result.replace(" .", "");
            result = result.replace(".", "");
            if (result.isEmpty()) {
                return result;
            }
            return result + " .";
        }

        if (result.endsWith(".")) {
            result = result.replace(" .", "");
            result = result.replace(".", "");
            if (result.isEmpty()) {
                return result;
            }
            return result + ".";
        }

        return result.replace(".", "");
    }
}
