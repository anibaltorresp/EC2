package com.idat.EC2_PuenteCornejo.service;
import com.idat.EC2_PuenteCornejo.model.Course;
import com.idat.EC2_PuenteCornejo.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class CourseService {
    private final CourseRepository courseRepository;

    @Autowired
    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public List<Course> findCoursesByMinCredits(Integer minCredits) {
        return courseRepository.findCoursesByMinimumCredits(minCredits);
    }

    public Integer getStudentTotalCredits(Integer studentId) {
        return courseRepository.calculateTotalCreditsForStudent(studentId);
    }

    public List<Object[]> getStudentCourseDetails() {
        return courseRepository.findStudentCourseDetails();
    }
}