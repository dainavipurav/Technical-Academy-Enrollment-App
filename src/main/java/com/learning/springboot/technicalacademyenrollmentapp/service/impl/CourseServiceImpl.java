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
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;

import java.time.Duration;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CourseServiceImpl implements CourseService {

    private final CourseJpaRepository repository;
    private final InstructorJpaRepository instructorJpaRepository;
    private final CourseMapper mapper;
    private final RedisTemplate<String,String> redisTemplate;
    private final ObjectMapper objectMapper;

    @Override
    public List<CourseResponseDto> getAllCourses() {

        String redisCourseListKey = "courses";

        String cachedCourses = redisTemplate.opsForValue().get(redisCourseListKey);

        if(cachedCourses != null){
            log.info("Cache Hit : Course data found success");
            return objectMapper.readValue(
                    cachedCourses,
                    new TypeReference<List<CourseResponseDto>>() {}
            );
        }

        log.info("Cache Miss : Course data not found");
        List<CourseEntity> courseEntities = repository.findAll();
        List<CourseResponseDto> courses = courseEntities.stream().map(mapper::toResponseDto).toList();
        String json = objectMapper.writeValueAsString(courses);
        redisTemplate.opsForValue().set(redisCourseListKey, json, Duration.ofMinutes(1));

        return courses;
    }


//    @Cacheable(value = "courses", key = "#id")
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

    @Override
    public CourseResponseDto updateCourseById(long id, CourseRequestDto request) {

        CourseEntity entity = repository.findById(id).orElseThrow(() -> new CourseNotFoundException("Course not found with id : " + id));
        InstructorEntity instructorEntity = instructorJpaRepository.findById(request.getInstructorId()).orElseThrow(() -> new InstructorNotFoundException("Instructor not found with id : " + request.getInstructorId()));

        entity.setCourseCode(request.getCourseCode());
        entity.setInstructor(instructorEntity);
        entity.setCourseName(request.getCourseName());
        entity.setCourseCode(request.getCourseCode());
        entity.setDescription(request.getDescription());
        entity.setDuration(request.getDuration());
        entity.setFees(request.getFees());
        entity.setLevels(request.getLevels());
        entity.setStatus(request.getStatus());
        entity.setStartedAt(request.getStartedAt());
        entity.setEndedAt(request.getEndedAt());

        return mapper.toResponseDto(repository.save(entity));
    }

    @Override
    public CourseResponseDto deleteCourseById(long id) {

        CourseEntity courseEntity = repository.findById(id).orElseThrow(() -> new CourseNotFoundException("Course not found with id : " + id));

        repository.delete(courseEntity);

        return mapper.toResponseDto(courseEntity);
    }
}
