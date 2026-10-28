
package com.learning.springboot.technicalacademyenrollmentapp.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.learning.springboot.technicalacademyenrollmentapp.enums.InstructorStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InstructorResponseDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String mobile;
    private LocalDate joiningDate;
    private double salary;
    private LocalDate dob;
    private InstructorStatus status;
    private String qualification;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
