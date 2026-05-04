package service;

import model.Task;
import java.util.ArrayList;
import java.util.List;

public class TaskScheduler {

    private List<Task> tasks = new ArrayList<>();

    public void addTask(int id, String name, int priority) {

        // ✅ CORRECT WAY (use constructor)
        Task task = new Task(id, name, priority);

        tasks.add(task);

        System.out.println("Task added successfully!");
    }

    public void showTasks() {
        for (Task t : tasks) {
            System.out.println(t);
        }
    }
}