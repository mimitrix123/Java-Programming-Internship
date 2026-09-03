import java.util.Scanner;

public class SwapWithoutThirdVariable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter first number: ");
        long first = scanner.nextLong();
        System.out.print("Enter second number: ");
        long second = scanner.nextLong();

        // XOR swap avoids arithmetic overflow and uses no third variable.
        first = first ^ second;
        second = first ^ second;
        first = first ^ second;

        System.out.println("After swapping:");
        System.out.println("First number = " + first);
        System.out.println("Second number = " + second);

        scanner.close();
    }
}
