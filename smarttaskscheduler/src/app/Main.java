package app;

import model.Task;
import service.TaskScheduler;
import service.Worker;

public class Main {

    public static void main(String[] args) {

        TaskScheduler scheduler = new TaskScheduler();

        // Create worker threads
        Thread worker1 = new Thread(new Worker(scheduler), "Worker-1");
        Thread worker2 = new Thread(new Worker(scheduler), "Worker-2");

        worker1.start();
        worker2.start();

        // Add tasks
        scheduler.addTask(new Task(1, "Backup Data", 3));
        scheduler.addTask(new Task(2, "Send Email", 1));
        scheduler.addTask(new Task(3, "Generate Report", 2));
        scheduler.addTask(new Task(4, "System Scan", 5));
    }
}
