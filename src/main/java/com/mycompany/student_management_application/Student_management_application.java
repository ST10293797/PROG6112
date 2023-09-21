/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.student_management_application;

import com.mycompany.student_management_application.student_class.Student;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.swing.JOptionPane;

public class Student_management_application {

    public static void main(String[] args) {
        List<Student> studentList; // ArrayList to store student objects
        studentList = new ArrayList<>();

        do {
            // Display the main menu using JOptionPane
            String[] options = {
                "Capture a new student",
                "Search for a student",
                "Delete a student",
                "Print student report",
                "Exit application"
            };

            int userInput = JOptionPane.showOptionDialog(
                null,
                "STUDENT MANAGEMENT APPLICATION\n" +
                "Please select one of the following menu items:",
                "STUDENT MANAGEMENT",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                options,
                options[0]
            );

            // Process the user's choice
            switch (userInput) {
                case 0:
                    // Capture a new student
                    Student newStudent = captureNewStudent();
                    if (newStudent != null) {
                        studentList.add(newStudent); // Add the new student to the list
                        JOptionPane.showMessageDialog(null, "Student information saved.");
                    }
                    break;
                case 1:
                    // Search for a student
                    searchForStudent(studentList);
                    break;
                case 2:
                    // Delete a student
                    deleteStudent(studentList);
                    break;
                case 3:
                    // Print student report
                    printStudentReport(studentList);
                    break;
                case 4:
                    // Exit the application
                    JOptionPane.showMessageDialog(null, "Exiting the application. Goodbye!");
                    System.exit(0);
                    break;
                default:
                    // Invalid choice
                    JOptionPane.showMessageDialog(null, "Invalid choice. Please select a valid menu option.");
            }

        } while (true); // Infinite loop until the user chooses to exit
    }

    // Method to capture a new student's information
    private static Student captureNewStudent() {
        String studentID = JOptionPane.showInputDialog("Enter the student id:");
        
        // Check if the user canceled the input dialog
        if (studentID == null) {
            JOptionPane.showMessageDialog(null, "Operation canceled. No student added.");
            return null; // Return null to indicate no student was added
        }
        
        String name = JOptionPane.showInputDialog("Enter the student name:");
        
        // Validate and capture student age
        int age = 0;
        boolean validAge = false;
        
        while (!validAge) {
            String ageInput = JOptionPane.showInputDialog("Enter the student age (must be 16 or older):");
            
            // Check if the user canceled the input dialog
            if (ageInput == null) {
                JOptionPane.showMessageDialog(null, "Operation canceled. No student added.");
                return null; // Return null to indicate no student was added
            }
            
            try {
                age = Integer.parseInt(ageInput);
                if (age >= 16) {
                    validAge = true;
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid age. Please enter an age of 16 or older.");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid age (numbers only).");
            }
        }
        
        String email = JOptionPane.showInputDialog("Enter the student email:");
        String course = JOptionPane.showInputDialog("Enter the student course:");

        // Create a new Student object and return it
        return new Student(studentID, name, age, email, course);
    }

    // Method to search for a student by student ID
    private static void searchForStudent(List<Student> studentList) {
        String studentIDToSearch = JOptionPane.showInputDialog("Enter the student ID to search:");
        
        for (Student student : studentList) {
            if (student.getStudentID().equals(studentIDToSearch)) {
                // Student found, display the details
                StringBuilder studentInfo = new StringBuilder();
                studentInfo.append("Student ID: ").append(student.getStudentID()).append("\n");
                studentInfo.append("Name: ").append(student.getName()).append("\n");
                studentInfo.append("Age: ").append(student.getAge()).append("\n");
                studentInfo.append("Email: ").append(student.getEmail()).append("\n");
                studentInfo.append("Course: ").append(student.getCourse()).append("\n");
                JOptionPane.showMessageDialog(null, studentInfo.toString(), "Student Details", JOptionPane.INFORMATION_MESSAGE);
                return; // Exit the method after displaying student details
            }
        }

        // Student not found, display an error message
        JOptionPane.showMessageDialog(null, "Student not found with the provided ID.", "Error", JOptionPane.ERROR_MESSAGE);
    }

    // Method to delete a student by student ID
    private static void deleteStudent(List<Student> studentList) {
        String studentIDToDelete = JOptionPane.showInputDialog("Enter the student ID to delete:");

        for (Student student : studentList) {
            if (student.getStudentID().equals(studentIDToDelete)) {
                // Student found, ask for confirmation
                int confirmation = JOptionPane.showConfirmDialog(
                    null,
                    "Are you sure you want to delete this student?\nStudent ID: " + studentIDToDelete,
                    "Confirmation",
                    JOptionPane.YES_NO_OPTION
                );
                 if (confirmation == JOptionPane.YES_OPTION) {
                    studentList.remove(student); // Delete the student
                    JOptionPane.showMessageDialog(null, "Student deleted successfully.");
                }
                return; // Exit the method after deleting or canceling
            }
        }

        // Student not found, display an error message
        JOptionPane.showMessageDialog(null, "Student not found with the provided ID.", "Error", JOptionPane.ERROR_MESSAGE);
    }

    // Method to generate and display the student report
    private static void printStudentReport(List<Student> studentList) {
        if (studentList.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No students have been added yet.");
            return;
        }

        StringBuilder reportBuilder = new StringBuilder();
        reportBuilder.append("Student Report:\n");

        for (Student student : studentList) {
            reportBuilder.append("Student ID: ").append(student.getStudentID()).append("\n");
            reportBuilder.append("Name: ").append(student.getName()).append("\n");
            reportBuilder.append("Age: ").append(student.getAge()).append("\n");
            reportBuilder.append("Email: ").append(student.getEmail()).append("\n");
            reportBuilder.append("Course: ").append(student.getCourse()).append("\n");
            reportBuilder.append("------------------------\n");
        }

        JOptionPane.showMessageDialog(null, reportBuilder.toString(), "Student Report", JOptionPane.INFORMATION_MESSAGE);
    }

    // Student class to represent student information
    static class Student {
        private String studentID;
        private String name;
        private int age;
        private String email;
        private String course;

        public Student(String studentID, String name, int age, String email, String course) {
            this.studentID = studentID;
            this.name = name;
            this.age = age;
            this.email = email;
            this.course = course;
        }

        public String getStudentID() {
            return studentID;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public String getEmail() {
            return email;
        }

        public String getCourse() {
            return course;
        }

        void setCourse(String physics) {
            throw new UnsupportedOperationException("Not supported yet."); 
        }

        void setStudentID(int i) {
            throw new UnsupportedOperationException("Not supported yet."); 
        }

        void setAge(int i) {
            throw new UnsupportedOperationException("Not supported yet."); 
        }

        void setEmail(String janeexamplecom) {
            throw new UnsupportedOperationException("Not supported yet."); 
        }

        void setName(String jane_Doe) {
            throw new UnsupportedOperationException("Not supported yet."); 
        }

        
    }
}

      