package org.mthree.service;

import org.mthree.entity.Student;
import org.mthree.repository.StudentRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentService {

    private final StudentRepository repo;

    public StudentService(StudentRepository repo) {
        this.repo = repo;
    }

    public List<Student> getAll() {
        return repo.findAll();
    }

    public Student get(int id) {
        return repo.findById(id).orElse(null);
    }

    public Student save(Student s) {
        return repo.save(s);
    }

    public void delete(int id) {
        repo.deleteById(id);
    }
}
