import java.util.ArrayList;

public class StudentManager {

    private ArrayList<Student> students;

    public StudentManager() {
        students = FileHandler.loadStudents();
    }

    // Add student
    public void addStudent(Student student) {
        students.add(student);
        System.out.println("Student added successfully.");
    }

    // View all students
    public void viewStudents() {

        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        for (Student student : students) {
            System.out.println("--------------------");
            System.out.println(student);
        }

        System.out.println("--------------------");
    }

    // Search student
    public Student searchStudent(int id) {

        for (Student student : students) {

            if (student.getId() == id) {
                return student;
            }
        }

        return null;
    }

    // Update student
    public boolean updateStudent(
            int id,
            String name,
            int age,
            String course,
            double marks) {

        Student student = searchStudent(id);

        if (student != null) {

            student.setName(name);
            student.setAge(age);
            student.setCourse(course);
            student.setMarks(marks);

            return true;
        }

        return false;
    }

    // Delete student
    public boolean deleteStudent(int id) {

        Student student = searchStudent(id);

        if (student != null) {
            students.remove(student);
            return true;
        }

        return false;
    }

    // Get all students
    public ArrayList<Student> getStudents() {
        return students;
    }
}