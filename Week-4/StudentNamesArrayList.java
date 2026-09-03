import java.util.*;

public class StudentNamesArrayList {
    public static void main(String[] args) {
        ArrayList<String> students = new ArrayList<>();
        students.add("Asha");
        students.add("Rahul");
        students.add("Priya");
        students.add("Karan");

        System.out.println("Student names:");
        for (String student : students) {
            System.out.println(student);
        }
    }
}
