package com.learning.springboot.technicalacademyenrollmentapp.mappers;
import com.learning.springboot.technicalacademyenrollmentapp.dto.StudentRequestDto;
import com.learning.springboot.technicalacademyenrollmentapp.dto.StudentResponseDto;
import com.learning.springboot.technicalacademyenrollmentapp.entity.StudentEntity;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper {

    public StudentEntity toEntity(StudentRequestDto request) {
        StudentEntity student = new StudentEntity();

        student.setFirstName(request.getFirstName());
        student.setLastName(request.getLastName());
        student.setEmail(request.getEmail());
        student.setMobile(request.getMobile());
        student.setGender(request.getGender());
        student.setAddress(request.getAddress());
        student.setStatus(request.getStatus());
        student.setFees(request.getFees());
        student.setDob(request.getDob());

        return student;
    }

    public StudentResponseDto toResponseDto(StudentEntity student) {
        return StudentResponseDto.builder()
                .id(student.getId())
                .firstName(student.getFirstName())
                .lastName(student.getLastName())
                .email(student.getEmail())
                .mobile(student.getMobile())
                .gender(student.getGender())
                .address(student.getAddress())
                .status(student.getStatus())
                .fees(student.getFees())
                .dob(student.getDob())
                .createdAt(student.getCreatedAt())
                .updatedAt(student.getUpdatedAt())
                .build();
    }
}
