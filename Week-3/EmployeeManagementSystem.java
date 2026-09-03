import java.io.*;
import java.util.*;

public class EmployeeManagementSystem {
    private static final String FILE_NAME = "employees.txt";
    private static final Map<Integer, Employee> employees = new LinkedHashMap<>();

    static class Employee {
        int id;
        String name, department;
        double salary;

        Employee(int id, String name, String department, double salary) {
            if (id <= 0 || name == null || name.isBlank() || department == null || department.isBlank() || salary < 0)
                throw new IllegalArgumentException("Invalid employee details.");
            this.id = id; this.name = name; this.department = department; this.salary = salary;
        }

        String toFileLine() {
            return id + "|" + name.replace("|", "") + "|" + department.replace("|", "") + "|" + salary;
        }

        @Override
        public String toString() {
            return String.format("ID=%d, Name=%s, Department=%s, Salary=%.2f", id, name, department, salary);
        }
    }

    static void addEmployee(Employee employee) {
        if (employees.containsKey(employee.id)) throw new IllegalArgumentException("Employee ID already exists.");
        employees.put(employee.id, employee);
    }

    static void save() throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Employee e : employees.values()) {
                bw.write(e.toFileLine());
                bw.newLine();
            }
        }
    }

    static void load() throws IOException {
        employees.clear();
        File file = new File(FILE_NAME);
        if (!file.exists()) return;
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.isBlank()) continue;
                String[] p = line.split("\\|", -1);
                if (p.length != 4) continue;
                try {
                    addEmployee(new Employee(Integer.parseInt(p[0]), p[1], p[2], Double.parseDouble(p[3])));
                } catch (IllegalArgumentException ignored) {
                    System.out.println("Skipped invalid record: " + line);
                }
            }
        }
    }

    static void displayAll() {
        if (employees.isEmpty()) { System.out.println("No employees found."); return; }
        employees.values().forEach(System.out::println);
    }

    static void searchById(int id) {
        Employee e = employees.get(id);
        System.out.println(e == null ? "Employee not found." : e);
    }

    static void deleteById(int id) {
        if (employees.remove(id) == null) throw new NoSuchElementException("Employee not found.");
    }

    public static void main(String[] args) {
        try {
            load();
            if (employees.isEmpty()) {
                addEmployee(new Employee(101, "Asha", "Engineering", 65000));
                addEmployee(new Employee(102, "Rahul", "HR", 52000));
                addEmployee(new Employee(103, "Priya", "Finance", 60000));
                save();
            }

            System.out.println("=== Employee Management System ===");
            displayAll();
            System.out.println("\nSearch ID 102:");
            searchById(102);

            if (!employees.containsKey(104)) {
                System.out.println("\nAdding employee 104:");
                addEmployee(new Employee(104, "Karan", "Sales", 48000));
                save();
            }
            displayAll();
        } catch (IOException e) {
            System.out.println("File operation failed: " + e.getMessage());
        } catch (IllegalArgumentException | NoSuchElementException e) {
            System.out.println("Operation failed: " + e.getMessage());
        }
    }
}
