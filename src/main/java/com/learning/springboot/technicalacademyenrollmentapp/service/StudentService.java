package com.learning.springboot.technicalacademyenrollmentapp.service;

import com.learning.springboot.technicalacademyenrollmentapp.dto.StudentRequestDto;
import com.learning.springboot.technicalacademyenrollmentapp.dto.StudentResponseDto;

import java.util.List;

public interface StudentService {
    List<StudentResponseDto> getAllStudents();

    StudentResponseDto getStudentById(long id);

    StudentResponseDto addStudent(StudentRequestDto request);

    StudentResponseDto updateStudent(long id, StudentRequestDto request);

    StudentResponseDto deleteStudent(long id);
}
