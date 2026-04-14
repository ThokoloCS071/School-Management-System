import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
import java.util.Iterator;

public class SchoolManagementSystem {
    // Fields (Removed 'static' so each student has their own data)
    private String name;
    private String surname;
    private String id;
    private int studentNumber;
    private String course;
    private String modules;

    // Constructor
    public SchoolManagementSystem(String name, String surname, String id, int studentNumber) {
        this.name = name;
        this.surname = surname;
        this.id = id;
        this.studentNumber = studentNumber;
        this.course = "Not Enrolled";
        this.modules = "None";
    }

    // Standard way to display student data
    @Override
    public String toString() {
        return "STUDENT NUMBER: " + studentNumber + 
               " | NAME: " + name + " " + surname + 
               " | ID: " + id + 
               " | COURSE: " + course + 
               " | MODULES: " + modules;
    }

    // Logic Class for managing the system
    private static class Management {
        ArrayList<SchoolManagementSystem> students = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        Random random = new Random();

        public void saveProfile() {
            System.out.println("\n--- NEW REGISTRATION ---");
            System.out.print("ENTER YOUR NAME: ");
            String name = input.next();
            System.out.print("ENTER YOUR SURNAME: ");
            String surname = input.next();

            String id = "";
            while (true) {
                System.out.print("ENTER YOUR 13-DIGIT ID: ");
                id = input.next();
                if (id.matches("\\d{13}")) {
                    break;
                } else {
                    System.out.println("ERROR: The ID must contain exactly 13 digits.");
                }
            }

            int studentNumber = random.nextInt(40000) + 10000; // Generates 10000 - 50000
            
            SchoolManagementSystem newStudent = new SchoolManagementSystem(name, surname, id, studentNumber);
            students.add(newStudent);

            System.out.println("\n*** PROFILE CREATED SUCCESSFULLY ***");
            System.out.println(newStudent.toString());
            System.out.println("--------------------------------------");
        }

        public void searchProfile() {
            System.out.println("\n--- SEARCH PROFILE ---");
            System.out.print("ENTER STUDENT ID: ");
            String searchId = input.next();
            System.out.print("ENTER STUDENT NUMBER: ");
            int searchNum = input.nextInt();

            boolean found = false;
            for (SchoolManagementSystem s : students) {
                if (s.id.equals(searchId) && s.studentNumber == searchNum) {
                    System.out.println("RESULT FOUND: " + s);
                    found = true;
                    break;
                }
            }
            if (!found) System.out.println("SORRY: No match found for that ID and Student Number.");
        }

        public void deleteProfile() {
            System.out.print("\nENTER STUDENT NUMBER TO DELETE: ");
            int searchNum = input.nextInt();
            
            Iterator<SchoolManagementSystem> iterator = students.iterator();
            boolean removed = false;

            while (iterator.hasNext()) {
                SchoolManagementSystem s = iterator.next();
                if (s.studentNumber == searchNum) {
                    iterator.remove();
                    System.out.println("SUCCESS: Profile deleted.");
                    removed = true;
                    break;
                }
            }
            if (!removed) System.out.println("ERROR: Student Number not found.");
        }

        public void getNumber() {
            System.out.print("\nENTER YOUR ID: ");
            String searchId = input.next();
            boolean found = false;

            for (SchoolManagementSystem s : students) {
                if (s.id.equals(searchId)) {
                    System.out.println("FOUND: Your Student Number is: " + s.studentNumber);
                    found = true;
                    break;
                }
            }
            if (!found) System.out.println("ERROR: ID not recognized.");
        }

        public void enroll() {
            System.out.println("\n--- MODULE REGISTRATION ---");
            System.out.print("ENTER STUDENT NUMBER: ");
            int searchNum = input.nextInt();

            for (SchoolManagementSystem s : students) {
                if (s.studentNumber == searchNum) {
                    System.out.println("\nOFFERED COURSES:");
                    String[][] cm = {
                        {"COURSE      |", "Computer Science", "Mathematics"},
                        {"COMPULSORY  |", "COM1321, COM1427", "MAT1121, MAT1142"},
                        {"ELECTIVE    |", "MAT1121, COM1423", "COM1321, MAT1247"}
                    };

                    for (String[] row : cm) {
                        System.out.printf("%-15s %-20s %-20s\n", row[0], row[1], row[2]);
                    }

                    System.out.print("\nWHICH COURSE DO YOU WANT? ");
                    s.course = input.next();
                    System.out.print("ENTER CHOSEN MODULES: ");
                    input.nextLine(); // consume leftover newline
                    s.modules = input.nextLine();

                    System.out.println("REGISTRATION SUCCESSFUL FOR " + s.name);
                    return;
                }
            }
            System.out.println("ERROR: Student number not found.");
        }

        public void studentReport() {
            System.out.println("\n========== STUDENT REPORT ==========");
            if (students.isEmpty()) {
                System.out.println("No students registered in the system.");
            } else {
                for (int i = 0; i < students.size(); i++) {
                    System.out.println((i + 1) + ". " + students.get(i).toString());
                }
            }
            System.out.println("====================================");
        }

        public void exit() {
            System.out.println("Exiting application... Goodbye!");
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        Management manage = new Management();
        Scanner menuInput = new Scanner(System.in);

        while (true) {
            try {
                System.out.println("\nMAIN MENU:");
                System.out.println("1. New Registration");
                System.out.println("2. Search Profile");
                System.out.println("3. Delete Profile");
                System.out.println("4. Find Student Number");
                System.out.println("5. Module Registration");
                System.out.println("6. Student Report");
                System.out.println("0. EXIT");
                System.out.print("CHOICE: ");

                String choice = menuInput.next();

                switch (choice) {
                    case "1": manage.saveProfile(); break;
                    case "2": manage.searchProfile(); break;
                    case "3": manage.deleteProfile(); break;
                    case "4": manage.getNumber(); break;
                    case "5": manage.enroll(); break;
                    case "6": manage.studentReport(); break;
                    case "0": manage.exit(); break;
                    default: System.out.println("INVALID CHOICE, TRY AGAIN.");
                }
            } catch (Exception e) {
                System.out.println("SYSTEM ERROR: Invalid Input. Returning to menu.");
                menuInput.nextLine(); // clear buffer
            }
        }
    }
}