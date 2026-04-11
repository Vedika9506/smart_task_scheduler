package service;

import java.util.LinkedList;
import java.util.Queue;
import model.Task;

public class TaskScheduler {

    private Queue<Task> taskQueue = new LinkedList<>();

  
    public synchronized void addTask(Task task) {
        taskQueue.add(task);
        System.out.println("Task added: " + task.name);
        notify(); // worker ko signal
    }
    public synchronized Task getTask() throws InterruptedException {
        while (taskQueue.isEmpty()) {
            wait(); // wait until task available
        }
        return taskQueue.poll();
    }
}