package org.example.dao;

import org.example.dto.Student;

import java.util.List;

public interface ClassRosterDao {

    Student addStudent(String studentId, Student student);
    List<Student> getAllStudents();
    Student getStudent(String studentId);
    Student removeStudent(String studentId);
}
