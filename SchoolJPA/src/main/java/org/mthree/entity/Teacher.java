package org.mthree.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int teacherId;

    private String firstName;
    private String lastName;
    private String dept;

    public Set<Course> getCourses() {
        return courses;
    }

    @OneToMany(mappedBy = "teacher")
    @JsonIgnore
    private Set<Course> courses;


}
