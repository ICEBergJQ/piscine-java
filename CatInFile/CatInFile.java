// package CatInFile;

import java.io.*;

public class CatInFile {
    public static void cat(String[] args) throws IOException {
        if (args.length == 0) {
            return;
        }
        for (String arg : args) {
            try (
                    InputStream in = System.in;
                    FileOutputStream fos = new FileOutputStream(arg)) {
                byte[] buffer = new byte[4096];
                int bytesRead;

                while ((bytesRead = in.read(buffer)) != -1) {
                    fos.write(buffer, 0, bytesRead);
                }

                fos.flush();
            } catch (FileNotFoundException e) {
                return;
            }
        }
    }
}