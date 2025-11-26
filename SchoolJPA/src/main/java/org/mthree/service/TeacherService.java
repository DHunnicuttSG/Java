package org.mthree.service;

import org.mthree.entity.Teacher;
import org.mthree.repository.TeacherRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TeacherService {

    private final TeacherRepository repo;

    public TeacherService(TeacherRepository repo) {
        this.repo = repo;
    }

    public List<Teacher> getAll() {
        return repo.findAll();
    }

    public Teacher get(int id) {
        return repo.findById(id).orElse(null);
    }

    public Teacher save(Teacher t) {
        return repo.save(t);
    }

    public void delete(int id) {
        repo.deleteById(id);
    }
}
