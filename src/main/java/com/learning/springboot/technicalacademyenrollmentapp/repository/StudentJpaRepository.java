package com.learning.springboot.technicalacademyenrollmentapp.repository;

import com.learning.springboot.technicalacademyenrollmentapp.entity.CourseEntity;
import com.learning.springboot.technicalacademyenrollmentapp.entity.StudentEntity;
import com.learning.springboot.technicalacademyenrollmentapp.enums.StudentStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    Page<StudentEntity> findAll(Pageable pageable);

    Page<StudentEntity> findAllByGender(Pageable pageable, String gender);

    Page<StudentEntity> findAllByGender(
            String gender,
            Pageable pageable
    );

    Page<StudentEntity> findAllByStatus(
            StudentStatus status,
            Pageable pageable
    );

    Page<StudentEntity> findAllByGenderAndStatus(Pageable pageable, String gender, StudentStatus status);

}
