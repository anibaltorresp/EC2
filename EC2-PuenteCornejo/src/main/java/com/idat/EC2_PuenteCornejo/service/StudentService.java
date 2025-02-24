package com.idat.EC2_PuenteCornejo.service;
import com.idat.EC2_PuenteCornejo.model.Student;
import com.idat.EC2_PuenteCornejo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;
@Service
public class StudentService {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> findStudentsByCourse(String courseName) {
        return studentRepository.findStudentsByCourseNameContaining(courseName);
    }

    public List<Student> findStudentsByBirthDate(LocalDate birthDate) {
        return studentRepository.findStudentsByBirthDate(birthDate);
    }

    public List<Object[]> getStudentCourseCount() {
        return studentRepository.countCoursesPerStudent();
    }
}