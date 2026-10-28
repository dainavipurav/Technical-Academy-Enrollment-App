package com.learning.springboot.technicalacademyenrollmentapp.service.impl;

import com.learning.springboot.technicalacademyenrollmentapp.dto.InstructorRequestDto;
import com.learning.springboot.technicalacademyenrollmentapp.dto.InstructorResponseDto;
import com.learning.springboot.technicalacademyenrollmentapp.entity.InstructorEntity;
import com.learning.springboot.technicalacademyenrollmentapp.exception.InstructorNotFoundException;
import com.learning.springboot.technicalacademyenrollmentapp.mappers.InstructorMapper;
import com.learning.springboot.technicalacademyenrollmentapp.repository.InstructorJpaRepository;
import com.learning.springboot.technicalacademyenrollmentapp.service.InstructorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class InstructorServiceImpl implements InstructorService {

    private final InstructorJpaRepository repository;
    private final InstructorMapper mapper;

    @Override
    public List<InstructorResponseDto> getAllInstructors() {
        List<InstructorEntity> instructorEntities = repository.findAll();

        return instructorEntities.stream().map(mapper::toResponseDto).toList();
    }

    @Override
    public InstructorResponseDto getInstructorById(long id) {

        InstructorEntity instructor = repository.findById(id).orElseThrow(() -> new InstructorNotFoundException("Instructor not found with id : " + id));

        return mapper.toResponseDto(instructor);
    }

    @Override
    public InstructorResponseDto addInstructor(InstructorRequestDto request) {

        InstructorEntity instructorEntity = mapper.toEntity(request);

        return mapper.toResponseDto(repository.save(instructorEntity));
    }

    @Override
    public InstructorResponseDto updateInstructorById(long id, InstructorRequestDto request) {
        InstructorEntity requestEntity = repository.findById(id).orElseThrow(() -> new InstructorNotFoundException("Instructor not found with id : " + id));

        requestEntity.setFirstName(request.getFirstName());
        requestEntity.setLastName(request.getLastName());
        requestEntity.setDob(request.getDob());
        requestEntity.setEmail(request.getEmail());
        requestEntity.setMobile(request.getMobile());
        requestEntity.setJoiningDate(request.getJoiningDate());
        requestEntity.setSalary(request.getSalary());
        requestEntity.setStatus(request.getStatus());

        InstructorEntity responseEntity = repository.save(requestEntity);

        return mapper.toResponseDto(requestEntity);
    }

    @Override
    public InstructorResponseDto deleteInstructorById(long id) {

        InstructorEntity instructorEntity = repository.findById(id).orElseThrow(() -> new InstructorNotFoundException("Instructor not found with id : " + id));

        repository.deleteById(id);

        return mapper.toResponseDto(instructorEntity);
    }
}
