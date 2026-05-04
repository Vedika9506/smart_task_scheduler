package app;

import service.TaskScheduler;
import model.Task;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TaskScheduler scheduler = new TaskScheduler();

        while (true) {
            System.out.println("\n1. Add Task\n2. Exit");

            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {

                System.out.print("Enter ID: ");
                int id = sc.nextInt();
                sc.nextLine();

                System.out.print("Enter Name: ");
                String name = sc.nextLine();

                System.out.print("Enter Priority: ");
                int priority = sc.nextInt();

                Task task = new Task(id, name, priority);
                scheduler.addTask(task);

            } else {
                break;
            }
        }
    }
}