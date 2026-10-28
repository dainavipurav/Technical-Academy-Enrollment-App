package com.learning.springboot.technicalacademyenrollmentapp.service;

import com.learning.springboot.technicalacademyenrollmentapp.dto.course.CourseResponseDto;

import java.util.List;

public interface CourseService {

    List<CourseResponseDto> getAllCourses();
}
