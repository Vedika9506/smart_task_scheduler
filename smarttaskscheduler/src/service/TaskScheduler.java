package service;

import model.Task;
import java.util.LinkedList;
import java.util.Queue;

public class TaskScheduler {

    // Queue to store tasks
    private Queue<Task> taskQueue = new LinkedList<>();

    // Add task to queue
    public synchronized void addTask(Task task) {

        taskQueue.add(task);

        // Use toString() instead of accessing private fields
        System.out.println("Task added: " + task);

        // Notify waiting threads
        notify();
    }

    // Get task from queue
    public synchronized Task getTask() throws InterruptedException {

        // If queue is empty, wait
        while (taskQueue.isEmpty()) {
            wait();
        }

        // Remove and return task
        return taskQueue.poll();
    }
}