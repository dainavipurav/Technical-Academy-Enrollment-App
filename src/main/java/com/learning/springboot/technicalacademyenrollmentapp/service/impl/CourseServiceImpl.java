package com.learning.springboot.technicalacademyenrollmentapp.service.impl;

import com.learning.springboot.technicalacademyenrollmentapp.dto.course.CourseResponseDto;
import com.learning.springboot.technicalacademyenrollmentapp.entity.CourseEntity;
import com.learning.springboot.technicalacademyenrollmentapp.mappers.CourseMapper;
import com.learning.springboot.technicalacademyenrollmentapp.repository.CourseJpaRepository;
import com.learning.springboot.technicalacademyenrollmentapp.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseJpaRepository repository;
    private final CourseMapper mapper;

    @Override
    public List<CourseResponseDto> getAllCourses() {

        List<CourseEntity> courseEntities = repository.findAll();

        return courseEntities.stream().map(mapper::toResponseDto).toList();
    }
}
