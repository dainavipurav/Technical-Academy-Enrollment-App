package com.learning.springboot.technicalacademyenrollmentapp.dto.student;

import com.learning.springboot.technicalacademyenrollmentapp.enums.StudentStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "Response representation containing student details")
public class StudentResponseDto {

    @Schema(description = "Unique identifier of the student", example = "1")
    private Long id;

    @Schema(description = "Student's first name", example = "Alice")
    private String firstName;

    @Schema(description = "Student's last name", example = "Smith")
    private String lastName;

    @Schema(description = "Student's email address", example = "alice.smith@example.com")
    private String email;

    @Schema(description = "Student's contact number", example = "+1987654321")
    private String mobile;

    @Schema(description = "Gender", example = "FEMALE")
    private String gender;

    @Schema(description = "Residential or mailing address", example = "123 Academic Way, Tech City")
    private String address;

    @Schema(description = "Enrollment status", example = "ACTIVE")
    private StudentStatus status;

    @Schema(description = "Fees paid or payable", example = "1200.00")
    private Double fees;

    @Schema(description = "Date of birth", example = "2001-04-12")
    private LocalDate dob;

    @Schema(description = "Record creation timestamp", example = "2026-01-10T08:30:00")
    private LocalDateTime createdAt;

    @Schema(description = "Record last update timestamp", example = "2026-01-10T08:30:00")
    private LocalDateTime updatedAt;
}