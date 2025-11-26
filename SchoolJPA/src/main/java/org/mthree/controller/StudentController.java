package org.mthree.controller;

import org.mthree.entity.Student;
import org.mthree.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAll();
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable int id) {
        return studentService.get(id);
    }

    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return studentService.save(student);
    }

    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable int id, @RequestBody Student student) {
        Student studentExists = getStudentById(id);
        if (studentExists != null) {
            return studentService.save(student);
        } else {
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable int id) {
        studentService.delete(id);
    }

    // 🚀 Get all courses for a student
    @GetMapping("/{id}/courses")
    public Object getStudentCourses(@PathVariable int id) {
        Student s = studentService.get(id);
        return s != null ? s.getCourses() : null;
    }
}
