import java.util.*;

public class StudentRollMap {
    public static void main(String[] args) {
        HashMap<Integer, String> students = new HashMap<>();
        students.put(101, "Asha");
        students.put(102, "Rahul");
        students.put(103, "Priya");
        students.put(104, "Karan");

        System.out.println("Roll number -> Student name");
        for (Map.Entry<Integer, String> entry : students.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}
