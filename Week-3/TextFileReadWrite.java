import java.io.*;

public class TextFileReadWrite {
    public static void main(String[] args) {
        String file = "sample.txt";
        String output = "copy.txt";
        try (FileWriter writer = new FileWriter(file)) {
            writer.write("Java file handling is useful.\nThis is a sample text file.");
        } catch (IOException e) { System.out.println("Write error: " + e.getMessage()); return; }

        try (FileReader reader = new FileReader(file); FileWriter writer = new FileWriter(output)) {
            int ch;
            while ((ch = reader.read()) != -1) { System.out.print((char) ch); writer.write(ch); }
            System.out.println("\nCopied successfully to " + output);
        } catch (IOException e) { System.out.println("File error: " + e.getMessage()); }
    }
}
