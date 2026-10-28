package com.learning.springboot.technicalacademyenrollmentapp.repository;

import com.learning.springboot.technicalacademyenrollmentapp.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface StudentJpaRepository extends JpaRepository<StudentEntity, Long> {
}
