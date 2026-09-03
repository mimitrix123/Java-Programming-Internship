# Java Programming Internship — Week 2

## Object-Oriented Programming (OOP)

Complete solutions for the Week 2 practice questions, assignments, and Library Management System mini project.

### Practice Questions

1. `Student.java` — Student class with name, marks, roll number, constructor, and display method.
2. `BankAccount.java` — encapsulated account with `deposit()` and `withdraw()` methods and validation.
3. `Vehicle.java` + `Car.java` — inheritance, method overriding, and runtime polymorphism.
4. `Shape.java` + `Circle.java` — interface implementation for area and perimeter.
5. `OverloadingOverridingDemo.java` — method overloading and method overriding.

### Assignment: Vehicle Inheritance

`Vehicle` is the base class and `Car` and `Bike` extend it. Both subclasses override `start()` and `move()`.

### Mini Project: Library Management System

`LibraryManagementSystem.java` contains:

- `LibraryItem` — abstract base class demonstrating abstraction.
- `Book` — extends `LibraryItem`, with private state for encapsulation.
- `User` — tracks borrowed books.
- `Library` — supports add, find, borrow, and return operations.
- Runtime behavior demonstrating inheritance and polymorphism.

### Concepts covered

- Classes and objects
- Constructors
- Encapsulation and access modifiers
- Inheritance
- Polymorphism
- Method overloading
- Method overriding
- Abstract classes
- Interfaces
- Collections (`ArrayList`)
- Basic validation and exception handling

### Compile and run

```bash
javac *.java
java Student
java BankAccount
java Car
java Circle
java OverloadingOverridingDemo
java LibraryManagementSystem
```
