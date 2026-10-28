package com.learning.springboot.technicalacademyenrollmentapp.dto.enrollment;

import com.learning.springboot.technicalacademyenrollmentapp.enums.EnrollmentStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EnrollmentRequestDto {
    private long student;
    private long course;
    private LocalDate enrollmentDate;
    private EnrollmentStatus status;
}
