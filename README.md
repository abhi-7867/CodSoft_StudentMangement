# Student Management System

A comprehensive Java-based console application for managing student information with persistent data storage.

## Features

1. **Student Management**
   - Add new students with validation
   - Remove existing students
   - Update student information
   - Search students by roll number, name, or grade
   - Display all students
   - View system statistics

2. **Data Persistence**
   - Automatic save to file (`students.dat`)
   - Automatic load on startup
   - Serialization-based storage

3. **Input Validation**
   - Roll number validation
   - Name validation (letters and spaces only)
   - Grade format validation
   - Age range validation (5-120)
   - Email format validation
   - Phone number validation (10 digits)
   - Empty field checks

4. **User Interface**
   - Console-based menu system
   - Clear error messages
   - User-friendly prompts
   - Confirmation for destructive operations

## Student Class Attributes

- **Name**: Student's full name
- **Roll Number**: Unique identifier for the student
- **Grade**: Student's grade/class
- **Age**: Student's age (5-120)
- **Email**: Valid email address
- **Phone Number**: 10-digit phone number

## How to Compile and Run

### Prerequisites
- Java JDK 8 or higher
- Any Java IDE or command line

### Compilation

```bash
javac *.java
```

### Execution

```bash
java StudentManagementApp
```
