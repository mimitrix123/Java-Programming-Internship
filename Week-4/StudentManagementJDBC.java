import java.sql.*;
import java.util.Scanner;

/**
 * Week 4 Capstone: Student Management System using JDBC + MySQL.
 *
 * Before running, create the database/table from schema.sql and update the
 * connection URL, username, and password below.
 */
public class StudentManagementJDBC {
    private static final String URL = "jdbc:mysql://localhost:3306/student_management";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    static class Student {
        int id;
        String name;
        String email;
        String course;
        double marks;

        Student(int id, String name, String email, String course, double marks) {
            this.id = id;
            this.name = name;
            this.email = email;
            this.course = course;
            this.marks = marks;
        }
    }

    private Connection connect() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public void addStudent(Student s) throws SQLException {
        String sql = "INSERT INTO students(id, name, email, course, marks) VALUES (?, ?, ?, ?, ?)";
        try (Connection c = connect(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, s.id);
            ps.setString(2, s.name);
            ps.setString(3, s.email);
            ps.setString(4, s.course);
            ps.setDouble(5, s.marks);
            ps.executeUpdate();
        }
    }

    public void updateStudent(Student s) throws SQLException {
        String sql = "UPDATE students SET name=?, email=?, course=?, marks=? WHERE id=?";
        try (Connection c = connect(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, s.name);
            ps.setString(2, s.email);
            ps.setString(3, s.course);
            ps.setDouble(4, s.marks);
            ps.setInt(5, s.id);
            int rows = ps.executeUpdate();
            System.out.println(rows == 0 ? "Student not found." : "Student updated.");
        }
    }

    public void deleteStudent(int id) throws SQLException {
        String sql = "DELETE FROM students WHERE id=?";
        try (Connection c = connect(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, id);
            int rows = ps.executeUpdate();
            System.out.println(rows == 0 ? "Student not found." : "Student deleted.");
        }
    }

    public void viewStudents() throws SQLException {
        String sql = "SELECT id, name, email, course, marks FROM students ORDER BY id";
        try (Connection c = connect(); Statement st = c.createStatement(); ResultSet rs = st.executeQuery(sql)) {
            System.out.println("\nID | Name | Email | Course | Marks");
            System.out.println("--------------------------------------------");
            while (rs.next()) {
                System.out.printf("%d | %s | %s | %s | %.2f%n",
                        rs.getInt("id"), rs.getString("name"), rs.getString("email"),
                        rs.getString("course"), rs.getDouble("marks"));
            }
        }
    }

    private static Student readStudent(Scanner sc, boolean includeId) {
        int id = includeId ? readInt(sc, "ID: ") : 0;
        System.out.print("Name: ");
        String name = sc.nextLine().trim();
        System.out.print("Email: ");
        String email = sc.nextLine().trim();
        System.out.print("Course: ");
        String course = sc.nextLine().trim();
        double marks = readDouble(sc, "Marks (0-100): ");
        if (marks < 0 || marks > 100) throw new IllegalArgumentException("Marks must be between 0 and 100.");
        return new Student(id, name, email, course, marks);
    }

    private static int readInt(Scanner sc, String prompt) {
        System.out.print(prompt);
        int value = Integer.parseInt(sc.nextLine().trim());
        if (value <= 0) throw new IllegalArgumentException("ID must be positive.");
        return value;
    }

    private static double readDouble(Scanner sc, String prompt) {
        System.out.print(prompt);
        return Double.parseDouble(sc.nextLine().trim());
    }

    public static void main(String[] args) {
        StudentManagementJDBC app = new StudentManagementJDBC();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n=== Student Management System ===");
            System.out.println("1. Add  2. Update  3. Delete  4. View  5. Exit");
            System.out.print("Choose: ");
            String choice = sc.nextLine().trim();
            try {
                switch (choice) {
                    case "1": app.addStudent(readStudent(sc, true)); System.out.println("Student added."); break;
                    case "2": app.updateStudent(readStudent(sc, true)); break;
                    case "3": app.deleteStudent(readInt(sc, "Student ID: ")); break;
                    case "4": app.viewStudents(); break;
                    case "5": System.out.println("Goodbye!"); return;
                    default: System.out.println("Invalid menu choice.");
                }
            } catch (NumberFormatException | IllegalArgumentException e) {
                System.out.println("Invalid input: " + e.getMessage());
            } catch (SQLException e) {
                System.out.println("Database error: " + e.getMessage());
            }
        }
    }
}
