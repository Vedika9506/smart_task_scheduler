package io;

import model.Task;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileManager {

    public static List<Task> loadTasks(String filePath) throws IOException {
        List<Task> list = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] p = line.split(",");
                int id = Integer.parseInt(p[0].trim());
                String name = p[1].trim();
                int priority = Integer.parseInt(p[2].trim());
                list.add(new Task(id, name, priority));
            }
        }
        return list;
    }
}