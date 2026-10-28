package com.learning.springboot.technicalacademyenrollmentapp.mappers;

import com.learning.springboot.technicalacademyenrollmentapp.dto.enrollment.EnrollmentResponseDto;
import com.learning.springboot.technicalacademyenrollmentapp.entity.CourseEntity;
import com.learning.springboot.technicalacademyenrollmentapp.entity.EnrollmentEntity;
import com.learning.springboot.technicalacademyenrollmentapp.entity.StudentEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EnrollmentMapper {

    private final StudentMapper studentMapper;

    private final CourseMapper courseMapper;

    public EnrollmentResponseDto toResponseDto(EnrollmentEntity request){

        return EnrollmentResponseDto.builder()
            .id(request.getId())
            .student(request.getStudent() == null ? null : studentMapper.toResponseDto(request.getStudent()))
            .course(request.getCourse() == null ? null : courseMapper.toResponseDto(request.getCourse()))
            .enrollmentDate(request.getEnrollmentDate())
            .status(request.getStatus())
            .createdAt(request.getCreatedAt())
            .updatedAt(request.getUpdatedAt())
            .build();
    }

    public EnrollmentEntity toEntity(EnrollmentResponseDto request, CourseEntity courseEntity, StudentEntity studentEntity){
        return EnrollmentEntity.builder()
                .id(request.getId())
                .course(courseEntity)
                .student(studentEntity)
                .enrollmentDate(request.getEnrollmentDate())
                .status(request.getStatus())
                .createdAt(request.getCreatedAt())
                .updatedAt(request.getUpdatedAt())
                .build();
    }


}
