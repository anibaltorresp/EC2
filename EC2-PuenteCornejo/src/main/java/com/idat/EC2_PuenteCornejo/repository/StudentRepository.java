package com.idat.EC2_PuenteCornejo.repository;
import com.idat.EC2_PuenteCornejo.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.time.LocalDate;
import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    // 1. JPQL query for students in specific course
    @Query("SELECT DISTINCT s FROM Student s " +  "JOIN s.courses c " +
            "WHERE c.name LIKE %:courseName%")
    List<Student> findStudentsByCourseNameContaining(@Param("courseName") String courseName);

    // 3. JPQL query for course count per student
    @Query("SELECT s.id as studentId, s.name as studentName, COUNT(c) as courseCount " +
            "FROM Student s LEFT JOIN s.courses c GROUP BY s.id, s.name")
    List<Object[]> countCoursesPerStudent();

    // 5. JPQL query for students by birth date
    @Query("SELECT s FROM Student s WHERE s.dateOfBirth = :birthDate")
    List<Student> findStudentsByBirthDate(@Param("birthDate") LocalDate birthDate);






}