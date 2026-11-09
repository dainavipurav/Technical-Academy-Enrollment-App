package com.learning.springboot.technicalacademyenrollmentapp.service;

import com.learning.springboot.technicalacademyenrollmentapp.dto.course.CourseResponseDto;
import com.learning.springboot.technicalacademyenrollmentapp.dto.student.StudentRequestDto;
import com.learning.springboot.technicalacademyenrollmentapp.dto.student.StudentResponseDto;
import com.learning.springboot.technicalacademyenrollmentapp.enums.StudentStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface StudentService {
    List<StudentResponseDto> getAllStudents();

    StudentResponseDto getStudentById(long id);

    StudentResponseDto addStudent(StudentRequestDto request);

    StudentResponseDto updateStudent(long id, StudentRequestDto request);

    StudentResponseDto deleteStudent(long id);

    List<CourseResponseDto> getAllCoursesByStudentId(long studentId);

    Page<StudentResponseDto> getAllStudents(Pageable pageable, String gender, StudentStatus status);
}
