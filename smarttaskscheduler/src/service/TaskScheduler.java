package service;

import model.Task;
import java.util.LinkedList;
import java.util.Queue;

public class TaskScheduler {

    private Queue<Task> taskQueue = new LinkedList<>();

    public synchronized void addTask(Task task) {
        taskQueue.add(task);
        System.out.println("Task added: " + task);
        notify();
    }

    public synchronized Task getTask() throws InterruptedException {
        while (taskQueue.isEmpty()) {
            wait();
        }
        return taskQueue.poll();
    }
}