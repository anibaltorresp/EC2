package com.idat.EC2_PuenteCornejo.model;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer credit;

    private String description;

    @ManyToMany(mappedBy = "courses")
    private Set<Student> students;


    public Course() {
    }


    public Course(Integer id, String name, Integer credit, String description, Set<Student> students) {
        this.id = id;
        this.name = name;
        this.credit = credit;
        this.description = description;
        this.students = students;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCredit() {
        return credit;
    }

    public void setCredit(Integer credit) {
        this.credit = credit;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }
}
