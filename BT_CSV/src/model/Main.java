package model;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final String COMMA_DELIMITER = ",";
    private  static final String NEW_LINE_SEPARATOR = "\n";
    private static final String FILE_HEADER= "id, name, gender";


    public static void writeCsvFile(String fileName) throws IOException {
        Student student1 = new Student(1, "Đạt", "nam");
        Student student2 = new Student(2, "Tú", "nam");
        Student student3 = new Student(3, "Thành", "nam");
        Student student4 = new Student(4, "Thế Anh", "nam");
        List<Student> students = new ArrayList<>();
        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(fileName);
            fileWriter.append(FILE_HEADER);
            fileWriter.append(NEW_LINE_SEPARATOR);

            for (Student student : students) {
                fileWriter.append(String.valueOf(student.getId()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(student.getName());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(student.getGender());
                fileWriter.append(NEW_LINE_SEPARATOR);
            }
            System.out.println("CSV successfully");
        } catch (IOException e) {
            System.out.println("ERRO CSV");
            e.printStackTrace();
        } finally {
            fileWriter.close();
        }
    }
    public static void main(String[] args) throws IOException {
        String fileName = "Student.csv";
        writeCsvFile(fileName);
    }


}
