# Week 4 Final Project Report

## Project
Student Management System using Java, OOP, JDBC, and MySQL.

## Objective
Build a persistent CRUD application that demonstrates object-oriented programming, collections-ready data modeling, exception handling, database connectivity, and clean separation of responsibilities.

## Core Logic
1. The `Student` class represents a student record with ID, name, email, course, and marks.
2. JDBC connects the Java application to the MySQL `student_management` database.
3. `PreparedStatement` is used for INSERT, UPDATE, and DELETE operations.
4. `Statement` and `ResultSet` are used to retrieve and display student records.
5. Input is validated before database operations; invalid numeric values and invalid marks are handled with exceptions.
6. Try-with-resources automatically closes database resources.
7. The database provides persistent storage, so records remain available after the application exits.

## CRUD Modules
- **Add Student:** inserts a new student record.
- **Update Student:** changes an existing student's details using the ID.
- **Delete Student:** removes a student by ID.
- **View Students:** lists all records in ID order.

## Database
The `schema.sql` file creates the database and `students` table. Update the JDBC URL, MySQL username, and password in `StudentManagementJDBC.java` before running.

## Testing Checklist
- Add a valid student.
- View the inserted record.
- Update the student's details.
- View again to confirm the update.
- Delete the student.
- View again to confirm deletion.
- Enter non-numeric ID/marks and verify graceful input-error handling.
- Enter marks outside 0–100 and verify validation.

## Conclusion
The project demonstrates the Week 4 capstone requirements with a practical CRUD workflow and persistent database storage. The optional GUI layer can be added later without changing the core database operations.
