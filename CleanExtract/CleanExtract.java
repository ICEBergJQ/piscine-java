public class CleanExtract {
    public static String extract(String s) {
        String[] parts = s.split("\\|");
        String result = "";

        for (String part : parts) {
            part = part.trim();
            Boolean flag = part.endsWith(".");
            part = part.replace(".", "");
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
        if (result.endsWith(".")) {
            result = result.replace(".", "");
            return result + ".";
        }

        return result;
    }
}
