package org.mthree.controller;

import org.mthree.entity.Teacher;
import org.mthree.service.TeacherService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teachers")
public class TeacherController {

    private final TeacherService service;

    public TeacherController(TeacherService service) {
        this.service = service;
    }

    @GetMapping
    public List<Teacher> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Teacher get(@PathVariable int id) {
        return service.get(id);
    }

    @PostMapping
    public Teacher create(@RequestBody Teacher t) {
        return service.save(t);
    }

    @PutMapping("/{id}")
    public Teacher update(@PathVariable int id, @RequestBody Teacher t) {
        return service.save(t);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        service.delete(id);
    }

    @GetMapping("/{id}/courses")
    public Object getCourses(@PathVariable int id) {
        Teacher t = service.get(id);
        return t != null ? t.getCourses() : null;
    }
}
