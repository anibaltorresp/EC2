package com.idat.EC2_PuenteCornejo.controller;
import com.idat.EC2_PuenteCornejo.model.Course;
import com.idat.EC2_PuenteCornejo.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseController {
    private final CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/by-credits/{minCredits}")
    public ResponseEntity<List<Course>> getCoursesByMinCredits(@PathVariable Integer minCredits) {
        return ResponseEntity.ok(courseService.findCoursesByMinCredits(minCredits));
    }

    @GetMapping("/student-credits/{studentId}")
    public ResponseEntity<Integer> getStudentTotalCredits(@PathVariable Integer studentId) {
        return ResponseEntity.ok(courseService.getStudentTotalCredits(studentId));
    }

    @GetMapping("/student-course-details")
    public ResponseEntity<List<Object[]>> getStudentCourseDetails() {
        return ResponseEntity.ok(courseService.getStudentCourseDetails());
    }
}