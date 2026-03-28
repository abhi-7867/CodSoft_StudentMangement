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

## Menu Options

1. **Add New Student**: Add a new student with all required information
2. **Remove Student**: Remove a student by roll number (with confirmation)
3. **Search Student**: Search by roll number, name, or grade
4. **Update Student Information**: Modify existing student details
5. **Display All Students**: Show all students in the system
6. **Display Statistics**: Show total count, average age, and grade distribution
7. **Exit**: Close the application

## Data Storage

- Data is automatically saved to `students.dat` file
- Data persists between application sessions
- Uses Java serialization for storage

## Input Validation Rules

- **Roll Number**: Minimum 3 characters, cannot be empty
- **Name**: Minimum 2 characters, letters and spaces only
- **Grade**: Alphanumeric with + and - allowed
- **Age**: Integer between 5 and 120
- **Email**: Standard email format validation
- **Phone Number**: Exactly 10 digits

## Project Structure

```
Student Management System/
├── Student.java                 # Student entity class
├── StudentManagementSystem.java # Management system with CRUD operations
├── InputValidator.java         # Input validation utilities
├── StudentManagementApp.java   # Main application with UI
├── students.dat                # Data file (auto-generated)
└── README.md                   # This file
```

## Example Usage

1. Start the application
2. Select option 1 to add a new student
3. Enter all required information (with validation)
4. Student is saved automatically
5. Use option 3 to search for the student
6. Use option 4 to update information
7. Use option 5 to view all students
8. Exit with option 7

## Notes

- Roll numbers must be unique
- All data is validated before saving
- Confirmation is required for deletion
- File is automatically created if it doesn't exist
- Application handles file errors gracefully

