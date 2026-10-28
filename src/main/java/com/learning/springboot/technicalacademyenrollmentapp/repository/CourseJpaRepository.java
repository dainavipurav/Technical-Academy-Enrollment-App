package com.learning.springboot.technicalacademyenrollmentapp.repository;

import com.learning.springboot.technicalacademyenrollmentapp.entity.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseJpaRepository extends JpaRepository<CourseEntity, Long> {

}
