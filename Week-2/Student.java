public class Student {
    private String name;
    private double marks;
    private int rollNumber;

    public Student(String name, double marks, int rollNumber) {
        this.name = name;
        this.marks = marks;
        this.rollNumber = rollNumber;
    }

    public void displayInfo() {
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Name: " + name);
        System.out.println("Marks: " + marks);
    }

    public static void main(String[] args) {
        Student student = new Student("Mimi", 92.5, 101);
        student.displayInfo();
    }
}
