package com.learning.springboot.technicalacademyenrollmentapp.mappers;

import com.learning.springboot.technicalacademyenrollmentapp.dto.instructor.InstructorRequestDto;
import com.learning.springboot.technicalacademyenrollmentapp.dto.instructor.InstructorResponseDto;
import com.learning.springboot.technicalacademyenrollmentapp.entity.InstructorEntity;
import org.springframework.stereotype.Component;

@Component
public class InstructorMapper {


    public InstructorEntity toEntity(InstructorRequestDto request){

        return InstructorEntity.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .mobile(request.getMobile())
                .joiningDate(request.getJoiningDate())
                .salary(request.getSalary())
                .dob(request.getDob())
                .status(request.getStatus())
                .qualification(request.getQualification())
                .build();
    }

    public InstructorResponseDto toResponseDto(InstructorEntity entity){
        return InstructorResponseDto.builder()
                .id(entity.getId())
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName())
                .email(entity.getEmail())
                .mobile(entity.getMobile())
                .joiningDate(entity.getJoiningDate())
                .salary(entity.getSalary())
                .dob(entity.getDob())
                .status(entity.getStatus())
                .qualification(entity.getQualification())
                .createdAt(entity.getCreatedAt())
                .updatedAt(entity.getUpdatedAt())
                .build();
    }
}
