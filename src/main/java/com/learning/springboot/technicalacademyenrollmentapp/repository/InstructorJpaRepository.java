package com.learning.springboot.technicalacademyenrollmentapp.repository;

import com.learning.springboot.technicalacademyenrollmentapp.entity.InstructorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstructorJpaRepository extends JpaRepository<InstructorEntity, Long> {
}
