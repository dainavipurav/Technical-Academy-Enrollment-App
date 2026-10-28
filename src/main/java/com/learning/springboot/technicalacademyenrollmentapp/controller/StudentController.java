package com.learning.springboot.technicalacademyenrollmentapp.controller;


import com.learning.springboot.technicalacademyenrollmentapp.dto.student.StudentRequestDto;
import com.learning.springboot.technicalacademyenrollmentapp.dto.student.StudentResponseDto;
import com.learning.springboot.technicalacademyenrollmentapp.service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService studentService;

    @GetMapping
    public List<StudentResponseDto> getAllStudents(){
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public StudentResponseDto getStudentById(@PathVariable long id){
        return studentService.getStudentById(id);
    }

    @PostMapping
    public StudentResponseDto addStudent(@Valid @RequestBody StudentRequestDto request){
        return studentService.addStudent(request);
    }

    @PutMapping("/{id}")
    public StudentResponseDto updateStudent(@PathVariable long id, @Valid @RequestBody StudentRequestDto request){
        return studentService.updateStudent(id, request);
    }

    @DeleteMapping("/{id}")
    public StudentResponseDto deleteStudent(@PathVariable long id){
        return studentService.deleteStudent(id);
    }
}
