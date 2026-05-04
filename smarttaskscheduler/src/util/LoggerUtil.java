package util;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class LoggerUtil {
    private static final String FILE = "logs.txt";

    public static synchronized void log(String msg) {
        String line = "[" + LocalDateTime.now() + "] " + msg + "\n";
        System.out.print(line); // also print to console
        try (FileWriter fw = new FileWriter(FILE, true)) {
            fw.write(line);
        } catch (IOException e) {
            System.out.println("Logging failed: " + e.getMessage());
        }
    }
}