package org.mthree.controller;

import org.mthree.entity.Course;
import org.mthree.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    private final CourseService service;

    public CourseController(CourseService service) {
        this.service = service;
    }

    @GetMapping
    public List<Course> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Course get(@PathVariable int id) {
        return service.get(id);
    }

    @PostMapping
    public Course create(@RequestBody Course c) {
        return service.save(c);
    }

    @PutMapping("/{id}")
    public Course update(@PathVariable int id, @RequestBody Course c) {
        return service.save(c);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        service.delete(id);
    }

    @GetMapping("/{id}/students")
    public Object getStudents(@PathVariable int id) {
        Course c = service.get(id);
        return c != null ? c.getStudents() : null;
    }
}