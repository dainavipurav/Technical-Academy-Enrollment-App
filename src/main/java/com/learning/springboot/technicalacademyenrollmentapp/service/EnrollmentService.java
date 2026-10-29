package com.learning.springboot.technicalacademyenrollmentapp.service;

import com.learning.springboot.technicalacademyenrollmentapp.dto.enrollment.EnrollmentRequestDto;
import com.learning.springboot.technicalacademyenrollmentapp.dto.enrollment.EnrollmentResponseDto;
import com.learning.springboot.technicalacademyenrollmentapp.dto.success.SuccessResponseDto;

import java.util.List;

public interface EnrollmentService {
    List<EnrollmentResponseDto> getAllEnrollments();

    EnrollmentResponseDto getEnrollmentById(long id);

    EnrollmentResponseDto addEnrollment(EnrollmentRequestDto request);

    EnrollmentResponseDto updateEnrollmentById(long id, EnrollmentRequestDto request);

    SuccessResponseDto deleteEnrollmentById(long id);
}
