import java.util.Scanner;

public class ArraySum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter array size: ");
        int size = scanner.nextInt();

        if (size < 0) {
            System.out.println("Array size cannot be negative.");
            scanner.close();
            return;
        }

        int[] numbers = new int[size];
        long sum = 0;

        System.out.println("Enter " + size + " elements:");
        for (int i = 0; i < size; i++) {
            numbers[i] = scanner.nextInt();
            sum += numbers[i];
        }

        System.out.println("Sum = " + sum);
        scanner.close();
    }
}
