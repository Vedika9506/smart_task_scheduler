package service;

import model.Task;

public class Worker implements Runnable {

    private TaskScheduler scheduler;

    public Worker(TaskScheduler scheduler) {
        this.scheduler = scheduler;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Task task = scheduler.getTask();
                task.execute();
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}


