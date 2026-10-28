package com.learning.springboot.technicalacademyenrollmentapp.service.impl;

import com.learning.springboot.technicalacademyenrollmentapp.dto.student.StudentRequestDto;
import com.learning.springboot.technicalacademyenrollmentapp.dto.student.StudentResponseDto;
import com.learning.springboot.technicalacademyenrollmentapp.entity.StudentEntity;
import com.learning.springboot.technicalacademyenrollmentapp.exception.StudentNotFoundException;
import com.learning.springboot.technicalacademyenrollmentapp.mappers.StudentMapper;
import com.learning.springboot.technicalacademyenrollmentapp.repository.StudentJpaRepository;
import com.learning.springboot.technicalacademyenrollmentapp.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentJpaRepository repository;
    private final StudentMapper mapper;

    @Override
    public List<StudentResponseDto> getAllStudents() {
        List<StudentEntity> studentEntities = repository.findAll();

        return studentEntities.stream().map(mapper::toResponseDto).toList();
    }

    @Override
    public StudentResponseDto getStudentById(long id) {

        StudentEntity studentEntity = repository.findById(id).orElseThrow(() -> new StudentNotFoundException("Student not found with id : " + id));

        return mapper.toResponseDto(studentEntity);
    }

    @Override
    public StudentResponseDto addStudent(StudentRequestDto request) {
        StudentEntity studentEntity = mapper.toEntity(request);
        StudentEntity s = repository.save(studentEntity);
        return mapper.toResponseDto(s);
    }

    @Override
    public StudentResponseDto updateStudent(long id, StudentRequestDto request) {
        StudentEntity studentEntity = repository.findById(id).orElseThrow(() -> new StudentNotFoundException("Student not found with id : " + id));

        studentEntity.setAddress(request.getAddress());
        studentEntity.setDob(request.getDob());
        studentEntity.setEmail(request.getEmail());
        studentEntity.setFees(request.getFees());
        studentEntity.setFirstName(request.getFirstName());
        studentEntity.setLastName(request.getLastName());
        studentEntity.setGender(request.getGender());
        studentEntity.setMobile(request.getMobile());
        studentEntity.setStatus(request.getStatus());

        StudentEntity result = repository.save(studentEntity);

        return mapper.toResponseDto(result);
    }

    @Override
    public StudentResponseDto deleteStudent(long id) {

        StudentEntity studentEntity = repository.findById(id).orElseThrow(() -> new StudentNotFoundException("Student not found with Id : " + id));

        repository.deleteById(studentEntity.getId());

        return mapper.toResponseDto(studentEntity);
    }
}
