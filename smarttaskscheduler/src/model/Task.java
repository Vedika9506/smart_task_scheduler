package model;

public class Task {
    private int id;
    private String name;
    private int priority;

    // Constructor
    public Task(int id, String name, int priority) {
        this.id = id;
        this.name = name;
        this.priority = priority;
    }

    // Getters
    public int getId() { return id; }
    public String getName() { return name; }
    public int getPriority() { return priority; }

    // Setters
    public void setId(int id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setPriority(int priority) { this.priority = priority; }

    @Override
    public String toString() {
        return id + ", " + name + ", " + priority;
    }
}