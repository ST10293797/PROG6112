/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.student_management_application;

import com.mycompany.student_management_application.student_class.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StudentTest {

    private Student student;

    @BeforeEach
    public void setUp() {
        // Create a new Student object before each test
      student = new Student("1", "John Doe", 20, "john@example.com", "Math");
    }

    @Test
    public void testGetStudentID() {
        assertEquals("1", student.getStudentID());
    }

    @Test
    public void testGetName() {
        assertEquals("John Doe", student.getName());
    }

    @Test
    public void testGetAge() {
        assertEquals(20, student.getAge());
    }

    @Test
    public void testGetEmail() {
        assertEquals("john@example.com", student.getEmail());
    }

    @Test
    public void testGetCourse() {
        assertEquals("Math", student.getCourse());
    }

    @Test
    public void testSetStudentID() {
        student.setStudentID("1");
        assertEquals("1", student.getStudentID());
    }

    @Test
    public void testSetName() {
        student.setName("Jane Doe");
        assertEquals("Jane Doe", student.getName());
    }

    @Test
    public void testSetAge() {
        student.setAge(21);
        assertEquals(21, student.getAge());
    }

    @Test
    public void testSetEmail() {
        student.setEmail("jane@example.com");
        assertEquals("jane@example.com", student.getEmail());
    }

    @Test
    public void testSetCourse() {
        student.setCourse("Physics");
        assertEquals("Physics", student.getCourse());
    }      
}
