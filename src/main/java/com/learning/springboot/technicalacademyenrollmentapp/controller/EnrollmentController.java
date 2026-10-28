package com.learning.springboot.technicalacademyenrollmentapp.controller;

import com.learning.springboot.technicalacademyenrollmentapp.dto.enrollment.EnrollmentRequestDto;
import com.learning.springboot.technicalacademyenrollmentapp.dto.enrollment.EnrollmentResponseDto;
import com.learning.springboot.technicalacademyenrollmentapp.service.EnrollmentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/enrollments")
@RequiredArgsConstructor
@Validated
public class EnrollmentController {

    private final EnrollmentService enrollmentService;

    @GetMapping
    public List<EnrollmentResponseDto> getAllEnrollments(){
        return enrollmentService.getAllEnrollments();
    }

    @GetMapping("/{id}")
    public EnrollmentResponseDto getEnrollmentById(@PathVariable long id){
        return enrollmentService.getEnrollmentById(id);
    }

    @PostMapping
    public EnrollmentResponseDto addEnrollment(@Valid @RequestBody EnrollmentRequestDto request){
        return enrollmentService.addEnrollment(request);
    }
}
