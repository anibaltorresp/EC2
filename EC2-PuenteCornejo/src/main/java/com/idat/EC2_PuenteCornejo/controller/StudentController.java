package com.idat.EC2_PuenteCornejo.controller;
import com.idat.EC2_PuenteCornejo.model.Student;
import com.idat.EC2_PuenteCornejo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;
@RestController
@RequestMapping("/api/students")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/by-course/{courseName}")
    public ResponseEntity<List<Student>> getStudentsByCourse(@PathVariable String courseName) {
        return ResponseEntity.ok(studentService.findStudentsByCourse(courseName));
    }

    @GetMapping("/course-count")
    public ResponseEntity<List<Object[]>> getStudentCourseCount() {
        return ResponseEntity.ok(studentService.getStudentCourseCount());
    }

    @GetMapping("/by-birthdate")
    public ResponseEntity<List<Student>> getStudentsByBirthDate(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate birthDate) {
        return ResponseEntity.ok(studentService.findStudentsByBirthDate(birthDate));
    }
}