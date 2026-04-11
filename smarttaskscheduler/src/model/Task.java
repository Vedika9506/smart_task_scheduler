package model;

public class Task {
    public int id;
    public String name;
    public int priority;

    public Task(int id, String name, int priority) {
        this.id = id;
        this.name = name;
        this.priority = priority;
    }

  
    public void execute() {
        System.out.println(Thread.currentThread().getName() +
                " executing task: " + name + " (Priority: " + priority + ")");
    }
}