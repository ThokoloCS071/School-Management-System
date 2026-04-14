# School-Management-System

**School Management System (Java Console Application)
Project Overview**

The **School Management System** is a sophisticated Java-based console application designed to streamline academic administration and student record management. Developed as a core component of my software development portfolio, this project simulates a real-world environment where data integrity, user authentication, and organized record-keeping are paramount. The application serves as a comprehensive tool for educational institutions to manage the lifecycle of a student—from initial registration and identity verification to course enrollment and academic reporting.

**Key Features and Functionality**

**Secure Student Registration:** The system captures essential biographical data including names and surnames. It features a robust validation engine that utilizes Regular Expressions to ensure that South African ID numbers comply with the 13-digit numeric standard before proceeding.

**Dynamic ID Generation: ** To simulate a professional database environment, the system automatically generates unique, non-sequential student numbers ranging from 10,000 to 50,000, ensuring every record is distinct.

**Academic Enrollment & Mapping:** A built-in registration module allows students to browse a digital catalog of courses. Using 2D array structures, the system maps compulsory and elective modules for Computer Science and Mathematics streams, providing a structured academic path.

**Administrative Control (CRUD)**: The application supports full Create, Read, Update, and Delete (CRUD) operations. Users can search for profiles using multi-factor criteria, retrieve lost credentials, or securely remove records from the system using the Java Iterator interface to maintain collection stability.

**Technical Implementation**

This project showcases an advanced understanding of Object-Oriented Programming (OOP). By moving away from static variables to instance-based fields, shows true encapsulation, allowing the ArrayList collection to store unique objects. The logic is handled by a specialized Management inner class, which keeps the codebase modular and readable. Error handling is integrated throughout via try-catch blocks and input buffer clearing, ensuring the application remains resilient against invalid user entries.

**How to Run**

Ensure the Java Development Kit (JDK) is installed on your machine.

Download the source file: SchoolManagementSystem.java.

**Open your terminal or command prompt and compile the code:**
code
Bash
download
content_copy
expand_less
javac SchoolManagementSystem.java

**Execute the program:**

code
Bash
download
content_copy
expand_less
java SchoolManagementSystem
Future Roadmap

