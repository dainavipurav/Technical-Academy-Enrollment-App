package com.learning.springboot.technicalacademyenrollmentapp.repository;

import com.learning.springboot.technicalacademyenrollmentapp.entity.CourseEntity;
import com.learning.springboot.technicalacademyenrollmentapp.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
public interface StudentJpaRepository extends JpaRepository<StudentEntity, Long> {

    @Query("""
        SELECT c
        FROM EnrollmentEntity e
        JOIN e.course c
        LEFT JOIN FETCH c.instructor
        WHERE e.student.id = :studentId
        """)
    List<CourseEntity> findAllCourseByStudentId(
            @Param("studentId") Long studentId);

}
