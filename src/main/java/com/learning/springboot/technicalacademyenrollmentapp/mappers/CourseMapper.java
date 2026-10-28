package com.learning.springboot.technicalacademyenrollmentapp.mappers;

import com.learning.springboot.technicalacademyenrollmentapp.dto.course.CourseRequestDto;
import com.learning.springboot.technicalacademyenrollmentapp.dto.course.CourseResponseDto;
import com.learning.springboot.technicalacademyenrollmentapp.entity.CourseEntity;
import com.learning.springboot.technicalacademyenrollmentapp.entity.InstructorEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CourseMapper {

    private final InstructorMapper mapper;

    public CourseResponseDto toResponseDto(CourseEntity course) {
        return CourseResponseDto.builder()
                .id(course.getId())
                .instructorId(mapper.toResponseDto(course.getInstructorId()))
                .courseName(course.getCourseName())
                .courseCode(course.getCourseCode())
                .description(course.getDescription())
                .duration(course.getDuration())
                .fees(java.math.BigDecimal.valueOf(course.getFees()))
                .levels(
                        course.getLevels() != null
                                ? course.getLevels().name()
                                : null)
                .status(
                        course.getStatus() != null
                                ? course.getStatus().name()
                                : null)
                .startedAt(course.getStartedAt())
                .endedAt(course.getEndedAt())
                .createdAt(course.getCreatedAt())
                .updatedAt(course.getUpdatedAt())
                .build();
    }

    public CourseEntity toEntity(
            CourseRequestDto request,
            InstructorEntity instructor) {

        return CourseEntity.builder()
                .instructorId(instructor)
                .courseName(request.getCourseName())
                .courseCode(request.getCourseCode())
                .description(request.getDescription())
                .duration(request.getDuration())
                .fees(request.getFees().doubleValue())
                .levels(request.getLevels())
                .status(request.getStatus())
                .startedAt(request.getStartedAt())
                .endedAt(request.getEndedAt())
                .build();
    }
}
