import java.io.*;

public class Cat {
    public static void cat(String[] args) throws IOException {

        if (args.length == 0) {
            return;
        }
        for (String arg : args) {
            try (FileInputStream fis = new FileInputStream(arg)) {
                byte[] buffer = new byte[4096];
                int bytesRead;

                while ((bytesRead = fis.read(buffer)) != -1) {
                    System.out.write(buffer, 0, bytesRead);
                }

                System.out.flush();
            } catch (FileNotFoundException e) {
                return;
            }
        }
    }
}
