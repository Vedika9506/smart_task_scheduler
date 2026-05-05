package io;

import model.Task;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileManager {

    public static List<Task> loadTasks(String filePath) throws IOException {
        List<Task> tasks = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");

                int id = Integer.parseInt(parts[0].trim());
                String name = parts[1].trim();
                int priority = Integer.parseInt(parts[2].trim());

                tasks.add(new Task(id, name, priority));
            }
        }

        return tasks;
    }
}