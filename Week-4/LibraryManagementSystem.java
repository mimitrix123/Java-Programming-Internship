import java.io.*;
import java.util.*;

public class LibraryManagementSystem {
    private static final String FILE_NAME = "library_books.txt";
    private final Map<Integer, Book> books = new LinkedHashMap<>();

    static class Book {
        int id;
        String title;
        String author;
        boolean borrowed;

        Book(int id, String title, String author) {
            this.id = id;
            this.title = title;
            this.author = author;
        }

        String toFileString() {
            return id + "|" + title.replace("|", "/") + "|" + author.replace("|", "/") + "|" + borrowed;
        }
    }

    public void addBook(Book book) {
        books.put(book.id, book);
    }

    public boolean borrowBook(int id) {
        Book book = books.get(id);
        if (book == null || book.borrowed) return false;
        book.borrowed = true;
        return true;
    }

    public boolean returnBook(int id) {
        Book book = books.get(id);
        if (book == null || !book.borrowed) return false;
        book.borrowed = false;
        return true;
    }

    public void displayBooks() {
        System.out.println("\nLibrary books:");
        for (Book book : books.values()) {
            System.out.printf("%d | %s | %s | %s%n", book.id, book.title, book.author,
                    book.borrowed ? "Borrowed" : "Available");
        }
    }

    public void saveToFile() throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Book book : books.values()) {
                writer.write(book.toFileString());
                writer.newLine();
            }
        }
    }

    public void loadFromFile() throws IOException {
        File file = new File(FILE_NAME);
        if (!file.exists()) return;
        books.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|", -1);
                if (parts.length == 4) {
                    Book book = new Book(Integer.parseInt(parts[0]), parts[1], parts[2]);
                    book.borrowed = Boolean.parseBoolean(parts[3]);
                    books.put(book.id, book);
                }
            }
        }
    }

    public static void main(String[] args) {
        LibraryManagementSystem library = new LibraryManagementSystem();
        try {
            library.loadFromFile();
            if (library.books.isEmpty()) {
                library.addBook(new Book(1, "Clean Code", "Robert C. Martin"));
                library.addBook(new Book(2, "Effective Java", "Joshua Bloch"));
                library.addBook(new Book(3, "Head First Java", "Kathy Sierra"));
            }

            library.displayBooks();
            System.out.println("Borrow book 2: " + (library.borrowBook(2) ? "Success" : "Failed"));
            System.out.println("Return book 2: " + (library.returnBook(2) ? "Success" : "Failed"));
            library.saveToFile();
            System.out.println("\nData saved to " + FILE_NAME);
        } catch (IOException | NumberFormatException e) {
            System.out.println("File/data error: " + e.getMessage());
        }
    }
}
