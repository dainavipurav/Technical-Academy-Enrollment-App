package com.learning.springboot.technicalacademyenrollmentapp.controller;

import com.learning.springboot.technicalacademyenrollmentapp.dto.InstructorRequestDto;
import com.learning.springboot.technicalacademyenrollmentapp.dto.InstructorResponseDto;
import com.learning.springboot.technicalacademyenrollmentapp.service.InstructorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/api/instructors")
public class InstructorController {

    private final InstructorService instructorService;

    @GetMapping
    public List<InstructorResponseDto> getAllInstructors(){
        return instructorService.getAllInstructors();
    }

    @GetMapping("{id}")
    public InstructorResponseDto getInstructorById(@PathVariable long id){
        return instructorService.getInstructorById(id);
    }

    @PostMapping
    public InstructorResponseDto addInstructor(@Valid @RequestBody InstructorRequestDto request){
        return instructorService.addInstructor(request);
    }

    @PutMapping("/{id}")
    public InstructorResponseDto updateInstructorById(@PathVariable long id, @Valid @RequestBody InstructorRequestDto request){
        return instructorService.updateInstructorById(id, request);
    }

    @DeleteMapping("/{id}")
    public InstructorResponseDto deleteInstructorById(@PathVariable long id){
        return instructorService.deleteInstructorById(id);
    }

}
