import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private String name;
    private int id;
    private int totalMeals;

    public Student(String name, int id) {
        this.name = name;
        this.id = id;
        this.totalMeals = 0;
    }

    public void addMeals(int meals) {
        if (meals > 0) {
            totalMeals += meals;
        }
    }

    public int getId() {
        return id;
    }

    public void showDetails() {
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
        System.out.println("Total Meals: " + totalMeals);
    }
}

class HostelMealManager {
    private ArrayList<Student> students = new ArrayList<>();

    public void addStudent(String name, int id) {
        for (Student s : students) {
            if (s.getId() == id) {
                System.out.println("Student with this ID already exists.");
                return;
            }
        }

        students.add(new Student(name, id));
        System.out.println("Student added successfully.");
    }

    public void addMealToStudent(int id, int meals) {
        for (Student s : students) {
            if (s.getId() == id) {
                s.addMeals(meals);
                System.out.println("Meals added successfully.");
                return;
            }
        }

        System.out.println("Student not found.");
    }

    public void showStudentDetails(int id) {
        for (Student s : students) {
            if (s.getId() == id) {
                s.showDetails();
                return;
            }
        }

        System.out.println("Student not found.");
    }

    public void showAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        for (Student s : students) {
            s.showDetails();
            System.out.println("-----");
        }
    }
}

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        HostelMealManager manager = new HostelMealManager();

        while (true) {
            System.out.println("\nHostel Meal Management System");
            System.out.println("1. Add Student");
            System.out.println("2. Add Meal");
            System.out.println("3. Show Student Details");
            System.out.println("4. Show All Students");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    scanner.nextLine();

                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter ID: ");
                    int id = scanner.nextInt();

                    manager.addStudent(name, id);
                    break;

                case 2:
                    System.out.print("Enter Student ID: ");
                    int sid = scanner.nextInt();

                    System.out.print("Enter number of meals: ");
                    int meals = scanner.nextInt();

                    manager.addMealToStudent(sid, meals);
                    break;

                case 3:
                    System.out.print("Enter Student ID: ");
                    int sidInfo = scanner.nextInt();

                    manager.showStudentDetails(sidInfo);
                    break;

                case 4:
                    manager.showAllStudents();
                    break;

                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}