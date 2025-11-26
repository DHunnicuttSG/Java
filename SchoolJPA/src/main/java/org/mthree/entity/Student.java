package org.mthree.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int studentId;
    private String firstName;
    private String lastName;

    @ManyToMany(mappedBy = "students")
    @JsonIgnore
    private Set<Course> courses;

    public Set<Course> getCourses() {
        return courses;
    }
}
