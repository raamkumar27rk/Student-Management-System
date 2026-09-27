import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        StudentManager manager = new StudentManager();

        while (true) {

            System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Save Students");
            System.out.println("7. Exit");

            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:

                    System.out.print("Enter student ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter student name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter student age: ");
                    int age = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter course: ");
                    String course = sc.nextLine();

                    System.out.print("Enter marks: ");
                    double marks = sc.nextDouble();
                    sc.nextLine();

                    Student student = new Student(id, name, age, course, marks);

                    manager.addStudent(student);

                    break;

                case 2:

                    manager.viewStudents();

                    break;

                case 3:

                    System.out.print("Enter student ID to search: ");
                    int searchId = sc.nextInt();
                    sc.nextLine();

                    Student foundStudent = manager.searchStudent(searchId);

                    if (foundStudent != null) {

                        System.out.println("\nStudent found:");
                        System.out.println(foundStudent);

                    } else {

                        System.out.println("Student not found.");
                    }

                    break;

                case 4:

                    System.out.print("Enter student ID to update: ");
                    int updateId = sc.nextInt();
                    sc.nextLine();

                    Student existingStudent = manager.searchStudent(updateId);

                    if (existingStudent == null) {

                        System.out.println("Student not found.");

                    } else {

                        System.out.print("Enter new name: ");
                        String newName = sc.nextLine();

                        System.out.print("Enter new age: ");
                        int newAge = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter new course: ");
                        String newCourse = sc.nextLine();

                        System.out.print("Enter new marks: ");
                        double newMarks = sc.nextDouble();
                        sc.nextLine();

                        boolean updated = manager.updateStudent(
                                updateId,
                                newName,
                                newAge,
                                newCourse,
                                newMarks);

                        if (updated) {
                            System.out.println("Student updated successfully.");
                        }
                    }

                    break;

                case 5:

                    System.out.print("Enter student ID to delete: ");
                    int deleteId = sc.nextInt();
                    sc.nextLine();

                    boolean deleted = manager.deleteStudent(deleteId);

                    if (deleted) {
                        System.out.println("Student deleted successfully.");
                    } else {
                        System.out.println("Student not found.");
                    }

                    break;

                case 6:

                    FileHandler.saveStudents(manager.getStudents());

                    break;

                case 7:

                    FileHandler.saveStudents(manager.getStudents());

                    System.out.println("Goodbye!");

                    sc.close();

                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}