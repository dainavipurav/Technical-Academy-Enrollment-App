package com.learning.springboot.technicalacademyenrollmentapp.service.impl;

import com.learning.springboot.technicalacademyenrollmentapp.dto.course.CourseRequestDto;
import com.learning.springboot.technicalacademyenrollmentapp.dto.course.CourseResponseDto;
import com.learning.springboot.technicalacademyenrollmentapp.entity.CourseEntity;
import com.learning.springboot.technicalacademyenrollmentapp.entity.InstructorEntity;
import com.learning.springboot.technicalacademyenrollmentapp.exception.CourseNotFoundException;
import com.learning.springboot.technicalacademyenrollmentapp.exception.InstructorNotFoundException;
import com.learning.springboot.technicalacademyenrollmentapp.mappers.CourseMapper;
import com.learning.springboot.technicalacademyenrollmentapp.repository.CourseJpaRepository;
import com.learning.springboot.technicalacademyenrollmentapp.repository.InstructorJpaRepository;
import com.learning.springboot.technicalacademyenrollmentapp.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseJpaRepository repository;
    private final InstructorJpaRepository instructorJpaRepository;
    private final CourseMapper mapper;

    @Override
    public List<CourseResponseDto> getAllCourses() {

        List<CourseEntity> courseEntities = repository.findAll();

        return courseEntities.stream().map(mapper::toResponseDto).toList();
    }

    @Override
    public CourseResponseDto getCourseById(long id) {

        CourseEntity courseEntity = repository.findById(id).orElseThrow(() -> new CourseNotFoundException("Course not found with id : " + id));

        return mapper.toResponseDto(courseEntity);
    }

    @Override
    public CourseResponseDto addCourse(CourseRequestDto request) {
        InstructorEntity instructorEntity = instructorJpaRepository.findById(request.getInstructorId()).orElseThrow(()-> new InstructorNotFoundException("Instructor not found with id : " + request.getInstructorId()));

        CourseEntity entity = repository.save(mapper.toEntity(request, instructorEntity));

        return mapper.toResponseDto(entity);
    }
}
