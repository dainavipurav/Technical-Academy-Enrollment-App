package com.learning.springboot.technicalacademyenrollmentapp.controller;

import com.learning.springboot.technicalacademyenrollmentapp.dto.course.CourseRequestDto;
import com.learning.springboot.technicalacademyenrollmentapp.dto.course.CourseResponseDto;
import com.learning.springboot.technicalacademyenrollmentapp.service.CourseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/api/courses")
public class CourseController {

    private final CourseService courseService;

    @GetMapping
    public List<CourseResponseDto> getAllCourses(){
        return courseService.getAllCourses();
    }

    @GetMapping("{id}")
    public CourseResponseDto getCourseById(@PathVariable long id){
        return courseService.getCourseById(id);
    }

    @PostMapping
    public CourseResponseDto addCourse(@Valid @RequestBody CourseRequestDto request){
        return courseService.addCourse(request);
    }

}
