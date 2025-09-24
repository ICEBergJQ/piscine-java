import java.io.File;

public class FileSearch {

    public static String searchFile(String fileName) {
        File documents = new File("documents");
        if (!documents.exists() || !documents.isDirectory()) {
            return null;
        }
        return search(documents, fileName);
    }

    private static String search(File folder, String fileName) {
        File[] files = folder.listFiles();
        if (files != null) {
            for (File f : files) {
                if (f.isDirectory()) {
                    String result = search(f, fileName);
                    if (result != null) {
                        return result;
                    }
                } else if (f.getName().equals(fileName)) {
                    return f.getPath().replace("\\", "/");
                }
            }
        }
        return null;
    }
}
