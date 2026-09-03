import java.util.Scanner;

public class CustomAgeValidation {
    static void validateAge(int age) throws InvalidAgeException {
        if (age < 0 || age > 120) {
            throw new InvalidAgeException("Age must be between 0 and 120.");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Enter age: ");
            int age = sc.nextInt();
            validateAge(age);
            System.out.println("Valid age: " + age);
        } catch (InvalidAgeException e) {
            System.out.println("Invalid age: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Invalid input.");
        } finally {
            sc.close();
        }
    }
}
