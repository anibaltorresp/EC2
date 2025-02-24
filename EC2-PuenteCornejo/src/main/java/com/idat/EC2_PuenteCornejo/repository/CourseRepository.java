package com.idat.EC2_PuenteCornejo.repository;
import com.idat.EC2_PuenteCornejo.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Integer> {
    // 2. Native query for courses by credits
    @Query(value = "SELECT * FROM Courses WHERE credit >= :minCredits", nativeQuery = true)
    List<Course> findCoursesByMinimumCredits(@Param("minCredits") Integer minCredits);

    // 4. Native query for detailed student-course listing
    @Query(value = "SELECT s.name as student_name, s.date_of_birth, s.email, c.name as course_name " +
            "FROM Students s " +
            "JOIN StudentCourses sc ON s.id = sc.student_id " +
            "JOIN Courses c ON sc.course_id = c.id",
            nativeQuery = true)
    List<Object[]> findStudentCourseDetails();

    // 6. Native query for total credits per student
    @Query(value = "SELECT SUM(c.credit) " +
            "FROM Courses c " +
            "JOIN StudentCourses sc ON c.id = sc.course_id " +
            "WHERE sc.student_id = :studentId",
            nativeQuery = true)
    Integer calculateTotalCreditsForStudent(@Param("studentId") Integer studentId);
}