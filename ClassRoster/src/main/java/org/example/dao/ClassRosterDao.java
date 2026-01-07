package org.example.dao;

import org.example.dto.Student;

import java.util.List;

public interface ClassRosterDao {

    Student addStudent(String studentId, Student student) throws ClassRosterDaoException;
    List<Student> getAllStudents() throws ClassRosterDaoException;
    Student getStudent(String studentId) throws ClassRosterDaoException;
    Student removeStudent(String studentId) throws ClassRosterDaoException;
}
