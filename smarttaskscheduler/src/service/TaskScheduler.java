package service;

import model.Task;
import java.util.concurrent.PriorityBlockingQueue;

public class TaskScheduler {

    private PriorityBlockingQueue<Task> taskQueue = new PriorityBlockingQueue<>();

    public void addTask(Task task) {
        System.out.println("Task Added: " + task);
        taskQueue.put(task);
    }

    public Task getTask() throws InterruptedException {
        return taskQueue.take();
    }
}