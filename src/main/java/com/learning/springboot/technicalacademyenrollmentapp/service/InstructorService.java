package com.learning.springboot.technicalacademyenrollmentapp.service;

import com.learning.springboot.technicalacademyenrollmentapp.dto.InstructorRequestDto;
import com.learning.springboot.technicalacademyenrollmentapp.dto.InstructorResponseDto;

import java.util.List;

public interface InstructorService {

    List<InstructorResponseDto> getAllInstructors();

    InstructorResponseDto getInstructorById(long id);

    InstructorResponseDto addInstructor(InstructorRequestDto request);

    InstructorResponseDto updateInstructorById(long id, InstructorRequestDto request);

    InstructorResponseDto deleteInstructorById(long id);
}
