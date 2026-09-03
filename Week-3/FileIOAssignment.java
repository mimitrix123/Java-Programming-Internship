import java.io.*;
import java.util.*;

public class FileIOAssignment {
    public static void main(String[] args) {
        String input = "input.txt";
        String output = "word_frequency.txt";
        Map<String, Integer> frequency = new TreeMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(input))) {
            String line;
            while ((line = br.readLine()) != null) {
                for (String word : line.toLowerCase().split("[^a-z0-9]+")) {
                    if (!word.isEmpty()) frequency.merge(word, 1, Integer::sum);
                }
            }

            try (BufferedWriter bw = new BufferedWriter(new FileWriter(output))) {
                for (Map.Entry<String, Integer> entry : frequency.entrySet()) {
                    bw.write(entry.getKey() + " = " + entry.getValue());
                    bw.newLine();
                }
            }
            System.out.println("Word frequencies written to " + output);
        } catch (IOException e) {
            System.out.println("File error: " + e.getMessage());
        }
    }
}
