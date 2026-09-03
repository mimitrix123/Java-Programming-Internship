import java.util.*;

public class StudentMarksRecord {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Double> marks = new ArrayList<>();
        System.out.print("Enter number of subjects: ");
        int n = sc.nextInt();
        if (n <= 0) {
            System.out.println("Number of subjects must be positive.");
            sc.close();
            return;
        }
        for (int i = 1; i <= n; i++) {
            System.out.print("Enter mark " + i + ": ");
            double mark = sc.nextDouble();
            if (mark < 0 || mark > 100) {
                System.out.println("Mark must be 0-100.");
                sc.close();
                return;
            }
            marks.add(mark);
        }
        double highest = Collections.max(marks);
        double lowest = Collections.min(marks);
        double average = marks.stream().mapToDouble(Double::doubleValue).average().orElse(0);
        System.out.println("Marks: " + marks);
        System.out.println("Highest = " + highest);
        System.out.println("Lowest = " + lowest);
        System.out.printf("Average = %.2f%n", average);
        sc.close();
    }
}
