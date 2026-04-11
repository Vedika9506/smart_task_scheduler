package model;

public class Task implements Comparable<Task> {
    private int taskId;
    private String taskName;
    private int priority;

    public Task(int taskId, String taskName, int priority) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.priority = priority;
    }

    public void execute() throws Exception {
        System.out.println(Thread.currentThread().getName() +
                " executing Task: " + taskName + " (Priority: " + priority + ")");

        // Simulate work
        Thread.sleep(1000);

        // Random failure simulation
        if (Math.random() < 0.2) {
            throw new Exception("Task Failed: " + taskName);
        }

        System.out.println("Completed Task: " + taskName);
    }

    public int getPriority() {
        return priority;
    }

    @Override
    public int compareTo(Task other) {
        return Integer.compare(other.priority, this.priority); // High priority first
    }
}