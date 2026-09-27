import java.io.*;
import java.util.ArrayList;

public class FileHandler {

    private static final String FILE_NAME = "students.txt";

    // Save students to file
    public static void saveStudents(ArrayList<Student> students) {

        try {

            FileWriter writer = new FileWriter(FILE_NAME);

            for (Student student : students) {

                writer.write(
                    student.getId() + "," +
                    student.getName() + "," +
                    student.getAge() + "," +
                    student.getCourse() + "," +
                    student.getMarks() +
                    "\n"
                );
            }

            writer.close();

            System.out.println("Students saved successfully.");

        } catch (IOException e) {

            System.out.println("Error while saving students.");
        }
    }

    // Load students from file
    public static ArrayList<Student> loadStudents() {

        ArrayList<Student> students = new ArrayList<>();

        File file = new File(FILE_NAME);

        if (!file.exists()) {
            return students;
        }

        try {

            BufferedReader reader =
                    new BufferedReader(new FileReader(FILE_NAME));

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split(",");

                int id = Integer.parseInt(data[0]);
                String name = data[1];
                int age = Integer.parseInt(data[2]);
                String course = data[3];
                double marks = Double.parseDouble(data[4]);

                Student student =
                        new Student(id, name, age, course, marks);

                students.add(student);
            }

            reader.close();

        } catch (IOException e) {

            System.out.println("Error while loading students.");
        }

        return students;
    }
}