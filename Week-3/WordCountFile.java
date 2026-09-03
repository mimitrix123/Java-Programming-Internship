import java.io.*;

public class WordCountFile {
    public static void main(String[] args) {
        String file = args.length > 0 ? args[0] : "sample.txt";
        int words = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String trimmed = line.trim();
                if (!trimmed.isEmpty()) {
                    words += trimmed.split("\\s+").length;
                }
            }
            System.out.println("Word count = " + words);
        } catch (IOException e) {
            System.out.println("Unable to read file: " + e.getMessage());
        }
    }
}
