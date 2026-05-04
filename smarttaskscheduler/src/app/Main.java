package app;

import model.Task;
import service.TaskScheduler;
import service.Worker;
import io.FileManager;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        TaskScheduler scheduler = new TaskScheduler();

        // start workers
        Thread t1 = new Thread(new Worker(scheduler), "Worker-1");
        Thread t2 = new Thread(new Worker(scheduler), "Worker-2");
        t1.start();
        t2.start();

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add Task");
            System.out.println("2. Load Tasks from File");
            System.out.println("3. Exit");

            int choice = sc.nextInt();
            sc.nextLine();

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter ID: ");
                        int id = sc.nextInt(); sc.nextLine();

                        System.out.print("Enter Name: ");
                        String name = sc.nextLine();

                        System.out.print("Enter Priority: ");
                        int priority = sc.nextInt(); sc.nextLine();

                        scheduler.addTask(new Task(id, name, priority));
                        break;

                    case 2:
                        List<Task> tasks = FileManager.loadTasks("tasks.txt");
                        for (Task t : tasks) {
                            scheduler.addTask(t);
                        }
                        break;

                    case 3:
                        System.exit(0);

                    default:
                        System.out.println("Invalid choice");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}