package com.learning.springboot.technicalacademyenrollmentapp.service;

import com.learning.springboot.technicalacademyenrollmentapp.dto.course.CourseRequestDto;
import com.learning.springboot.technicalacademyenrollmentapp.dto.course.CourseResponseDto;

import java.util.List;

public interface CourseService {

    List<CourseResponseDto> getAllCourses();

    CourseResponseDto getCourseById(long id);

    CourseResponseDto addCourse(CourseRequestDto request);

    CourseResponseDto updateCourseById(long id, CourseRequestDto request);

    CourseResponseDto deleteCourseById(long id);
}
