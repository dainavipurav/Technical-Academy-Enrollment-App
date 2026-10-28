package com.learning.springboot.technicalacademyenrollmentapp.controller;

import com.learning.springboot.technicalacademyenrollmentapp.dto.course.CourseResponseDto;
import com.learning.springboot.technicalacademyenrollmentapp.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/courses")
public class CourseController {

    private final CourseService courseService;

    @GetMapping
    public List<CourseResponseDto> getAllCourses(){
        return courseService.getAllCourses();
    }

}
