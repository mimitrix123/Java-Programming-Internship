public class MultipleCatchDemo {
    public static void main(String[] args) {
        try {
            String text = args.length > 0 ? args[0] : "abc";
            int index = args.length > 1 ? Integer.parseInt(args[1]) : 5;
            int value = Integer.parseInt(text);
            System.out.println(value / index);
        } catch (NumberFormatException e) {
            System.out.println("Invalid number format.");
        } catch (ArithmeticException e) {
            System.out.println("Arithmetic error: division by zero.");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Array index is invalid.");
        }
    }
}
