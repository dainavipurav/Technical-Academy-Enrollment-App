package com.learning.springboot.technicalacademyenrollmentapp.service.impl;

import com.learning.springboot.technicalacademyenrollmentapp.dto.enrollment.EnrollmentResponseDto;
import com.learning.springboot.technicalacademyenrollmentapp.entity.EnrollmentEntity;
import com.learning.springboot.technicalacademyenrollmentapp.exception.EnrollmentNotFoundException;
import com.learning.springboot.technicalacademyenrollmentapp.mappers.EnrollmentMapper;
import com.learning.springboot.technicalacademyenrollmentapp.repository.EnrollmentJpaRepository;
import com.learning.springboot.technicalacademyenrollmentapp.service.EnrollmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EnrollmentServiceImpl implements EnrollmentService {

    private final EnrollmentJpaRepository repository;

    private final EnrollmentMapper mapper;

    @Override
    public List<EnrollmentResponseDto> getAllEnrollments() {

        List<EnrollmentEntity> enrollmentEntities = repository.findAll();

        return enrollmentEntities.stream().map(mapper::toResponseDto).toList();
    }

    @Override
    public EnrollmentResponseDto getEnrollmentById(long id) {

        EnrollmentEntity enrollmentEntity = repository.findById(id).orElseThrow(() -> new EnrollmentNotFoundException("No Enrollment found with id : " + id));

        return mapper.toResponseDto(enrollmentEntity);
    }
}
