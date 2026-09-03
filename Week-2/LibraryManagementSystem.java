import java.util.ArrayList;
import java.util.List;

abstract class LibraryItem {
    private final String id;
    private final String title;

    protected LibraryItem(String id, String title) {
        this.id = id;
        this.title = title;
    }

    public String getId() { return id; }
    public String getTitle() { return title; }
    public abstract void displayDetails();
}

class Book extends LibraryItem {
    private final String author;
    private boolean borrowed;

    public Book(String id, String title, String author) {
        super(id, title);
        this.author = author;
    }

    public boolean isBorrowed() { return borrowed; }

    public void borrow() {
        if (borrowed) throw new IllegalStateException("Book is already borrowed.");
        borrowed = true;
    }

    public void giveBack() {
        if (!borrowed) throw new IllegalStateException("Book is not currently borrowed.");
        borrowed = false;
    }

    @Override
    public void displayDetails() {
        System.out.printf("%s | %s | %s | %s%n", getId(), getTitle(), author,
                borrowed ? "Borrowed" : "Available");
    }
}

class User {
    private final int id;
    private final String name;
    private final List<Book> borrowedBooks = new ArrayList<>();

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void borrowBook(Book book) {
        book.borrow();
        borrowedBooks.add(book);
    }

    public void returnBook(Book book) {
        if (!borrowedBooks.remove(book)) {
            throw new IllegalStateException("This user did not borrow the book.");
        }
        book.giveBack();
    }

    public void displayBorrowedBooks() {
        System.out.println("Books borrowed by " + name + ":");
        if (borrowedBooks.isEmpty()) {
            System.out.println("None");
            return;
        }
        for (Book book : borrowedBooks) book.displayDetails();
    }
}

class Library {
    private final List<Book> books = new ArrayList<>();

    public void addBook(Book book) { books.add(book); }

    public void displayBooks() {
        System.out.println("Library catalog:");
        for (Book book : books) book.displayDetails();
    }

    public Book findBook(String id) {
        for (Book book : books) {
            if (book.getId().equals(id)) return book;
        }
        return null;
    }

    public void borrowBook(User user, String id) {
        Book book = findBook(id);
        if (book == null) throw new IllegalArgumentException("Book not found.");
        user.borrowBook(book);
    }

    public void returnBook(User user, String id) {
        Book book = findBook(id);
        if (book == null) throw new IllegalArgumentException("Book not found.");
        user.returnBook(book);
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Library library = new Library();
        Book java = new Book("B101", "Java Fundamentals", "James Gosling");
        Book oop = new Book("B102", "Object-Oriented Programming", "Martin Fowler");

        library.addBook(java);
        library.addBook(oop);

        User user = new User(1, "Mimi");

        library.displayBooks();
        System.out.println("\nBorrowing B101...");
        library.borrowBook(user, "B101");
        library.displayBooks();
        user.displayBorrowedBooks();

        System.out.println("\nReturning B101...");
        library.returnBook(user, "B101");
        library.displayBooks();
        user.displayBorrowedBooks();
    }
}
