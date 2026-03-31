package src.StudyManager.main;

import src.StudyManager.model.*;
import src.StudyManager.service.DataHandler;
import java.util.ArrayList;
import java.util.Scanner;

public class StudyManagerPro
{
    private static ArrayList<StudyResource> myResources = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String args[])
    {
        myResources = DataHandler.loadData();
        boolean running = true;

        System.out.println("=== Welcome to Your Personal Study Manager ===");

        while (running) {
            System.out.println("\n------ MAIN MENU ------\n");
            System.out.println("1. Add Book\n2. Add Video\n3. View All\n4. Search\n5. Mark Complete\n6. Reset\n7. Exit");
            System.out.print("Choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice)
            {
                case 1: addBook(); break;
                case 2: addVideo(); break;
                case 3: displayAll(); break;
                case 4: search(); break;
                case 5: markComplete(); break;
                case 6: reset(); break;
                case 7:
                        DataHandler.saveData(myResources);
                        running = false;
                        break;
            }
        }
    }

    private static void addBook()
    {
        System.out.print("Title: "); String t = scanner.nextLine();
        System.out.print("Subject: "); String s = scanner.nextLine();
        System.out.print("Author: "); String a = scanner.nextLine();
        System.out.print("Pages: "); int p = scanner.nextInt();
        myResources.add(new Book(t, s, a, p));
    }

    private static void addVideo()
    {
        System.out.print("Title: "); String t = scanner.nextLine();
        System.out.print("Subject: "); String s = scanner.nextLine();
        System.out.print("URL: "); String u = scanner.nextLine();
        System.out.print("Mins: "); int d = scanner.nextInt();
        myResources.add(new VideoLecture(t, s, u, d));
    }

    private static void displayAll()
    {
        for (StudyResource r : myResources) r.displayDetails();
        double progress = myResources.isEmpty() ? 0 : 
            (double) myResources.stream().filter(StudyResource::isCompleted).count() / myResources.size() * 100;
        System.out.printf("Current Progress: %.2f%%\n", progress);
    }

    private static void search()
    {
        System.out.print("Search Subject: ");
        String q = scanner.nextLine();
        myResources.stream()
            .filter(r -> r.getSubject().equalsIgnoreCase(q))
            .forEach(StudyResource::displayDetails);
    }

    private static void markComplete()
    {
        System.out.print("Enter Title: ");
        String t = scanner.nextLine();
        myResources.stream()
            .filter(r -> r.getTitle().equalsIgnoreCase(t))
            .forEach(StudyResource::markAsComplete);
    }

    private static void reset()
    {
        myResources.clear();
        DataHandler.deleteFile();
        System.out.println("Data Wiped.");
    }
}