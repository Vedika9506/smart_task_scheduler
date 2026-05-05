package model;

import util.TaskException;

public class Task implements Comparable<Task> {
    private int taskId;
    private String name;
    private int priority;

    public Task(int taskId, String name, int priority) {
        this.taskId = taskId;
        this.name = name;
        this.priority = priority;
    }

    public void execute() throws TaskException {
        System.out.println(Thread.currentThread().getName() +
                " executing task: " + name + " (Priority: " + priority + ")");

        if (Math.random() < 0.2) {
            throw new TaskException("Failed task: " + name);
        }
    }

    public int getTaskId() {
        return taskId;
    }

    public String getName() {
        return name;
    }

    public int getPriority() {
        return priority;
    }

    @Override
    public int compareTo(Task o) {
        return Integer.compare(o.priority, this.priority);
    }
}