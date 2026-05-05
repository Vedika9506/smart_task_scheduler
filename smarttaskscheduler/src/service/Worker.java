package service;

import model.Task;
import util.LoggerUtil;

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

                int retries = 2;

                while (retries >= 0) {
                    try {
                        task.execute();
                        LoggerUtil.log("SUCCESS: " + task);
                        break;
                    } catch (Exception e) {
                        LoggerUtil.log("ERROR: " + e.getMessage());
                        retries--;
                        if (retries < 0) {
                            LoggerUtil.log("FAILED permanently: " + task);
                        }
                    }
                }

            } catch (InterruptedException e) {
                LoggerUtil.log("Thread interrupted");
            }
        }
    }
}