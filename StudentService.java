package com.generation.service;

import com.generation.model.Course;
import com.generation.model.Student;

import java.util.HashMap;
import java.util.Map;

public class StudentService {
    private final Map<String, Student> students = new HashMap<>();

    public void subscribeStudent(Student student) {
        students.put(student.getId(), student);
    }

    public Student findStudent(String studentId) {
        return students.get(studentId);
    }

    public void showSummary() {
        if (students.isEmpty()) {
            System.out.println("No students are currently enrolled.");
            return;
        }

        for (Student student : students.values()) {
            System.out.println("Student ID: " + student.getId());
            System.out.println("Name: " + student.getName());
            System.out.println("Email: " + student.getEmail());
            System.out.println("Birth Date: " + student.getBirthDate());

            System.out.println("Courses:");
            if (student.getCourses().isEmpty()) {
                System.out.println("No enrolled courses.");
            } else {
                for (Course course : student.getCourses()) {
                    System.out.println("- " + course.getCode());
                }
            }

            System.out.println("-------------------------------");
        }
    }

    public void enrollToCourse(String studentId, Course course) {
        Student student = findStudent(studentId);
        if (student != null) {
            student.enrollToCourse(course);
        }
    }
}
