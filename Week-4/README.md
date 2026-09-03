# Week 4 – Collections & Capstone Project

This week covers Java Collections, OOP + file handling, JDBC/MySQL, CRUD design, exception handling, and final project documentation.

## Practice Questions

### 1. ArrayList – Student Names
`StudentNamesArrayList.java` stores student names in an `ArrayList<String>` and prints each name.

### 2. HashMap – Roll Numbers to Names
`StudentRollMap.java` uses `HashMap<Integer, String>` to map roll numbers to student names.

### 3. Sorting with Collections
`SortNumbers.java` uses `Collections.sort()` for ascending order and `Collections.reverse()` for descending order.

### 4. Library Management System
`LibraryManagementSystem.java` demonstrates OOP, collections, file handling, and exception handling. It supports adding books, borrowing, returning, displaying, saving, and loading book data.

### 5. Final Project Report
`Final-Project-Report.md` documents the final capstone logic, CRUD modules, database design, and testing checklist.

## Capstone: Student Management System

`StudentManagementJDBC.java` implements the Week 4 capstone option using JDBC + MySQL.

Features:
- Add student
- Update student
- Delete student
- View students
- Input validation
- SQL exception handling
- Persistent MySQL storage

`schema.sql` creates the required database and `students` table.

## Requirements
- Java JDK 8+
- MySQL Server
- MySQL Connector/J JDBC driver

## Run the JDBC Capstone

1. Execute `schema.sql` in MySQL.
2. Open `StudentManagementJDBC.java` and set `URL`, `USER`, and `PASSWORD`.
3. Add the MySQL Connector/J JAR to the classpath.
4. Compile and run:

```bash
javac -cp mysql-connector-j.jar StudentManagementJDBC.java
java -cp .;mysql-connector-j.jar StudentManagementJDBC
```

On Linux/macOS, use `:` instead of `;` in the classpath.

## Files

- `StudentNamesArrayList.java`
- `StudentRollMap.java`
- `SortNumbers.java`
- `LibraryManagementSystem.java`
- `StudentManagementJDBC.java`
- `schema.sql`
- `Final-Project-Report.md`
