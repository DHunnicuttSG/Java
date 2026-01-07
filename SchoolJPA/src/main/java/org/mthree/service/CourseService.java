package org.mthree.service;

import org.mthree.entity.Course;
import org.mthree.repository.CourseRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CourseService {
    private final CourseRepository repo;

    public CourseService(CourseRepository repo) {
        this.repo = repo;
    }

    public List<Course> getAll() {
        return repo.findAll();
    }

    public Course get(int id) {
        return repo.findById(id).orElse(null);
    }

    public Course save(Course c) {
        return repo.save(c);
    }

    public void delete(int id) {
        repo.deleteById(id);
    }
}
