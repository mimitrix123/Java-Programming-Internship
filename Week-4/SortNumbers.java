import java.util.*;

public class SortNumbers {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(42, 7, 19, 3, 25, 11));

        System.out.println("Before sorting: " + numbers);
        Collections.sort(numbers);
        System.out.println("Ascending order: " + numbers);

        Collections.reverse(numbers);
        System.out.println("Descending order: " + numbers);
    }
}
