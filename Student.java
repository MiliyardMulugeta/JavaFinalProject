package com.generation.model;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

public class Student extends Person {
    private final List<Course> courses = new ArrayList<>();

    public Student(String id, String name, String email, Date birthDate) {
        super(id, name, email, birthDate);
    }

    public void enrollToCourse(Course course) {
        if (course != null && !isAttendingCourse(course.getCode())) {
            this.courses.add(course);
        }
    }

    public boolean isAttendingCourse(String courseCode) {
        for (Course course : courses) {
            if (course.getCode().equals(courseCode)) {
                return true;
            }
        }
        return false;
    }

    public List<Course> getCourses() {
        return new ArrayList<>(this.courses);
    }

    @Override
    public String toString() {
        return "Student {" +
                "ID='" + getId() + '\'' +
                ", name='" + getName() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", birthDate=" + getBirthDate() +
                '}';
    }
}

