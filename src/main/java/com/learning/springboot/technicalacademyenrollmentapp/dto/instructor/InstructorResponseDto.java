package com.learning.springboot.technicalacademyenrollmentapp.dto.instructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.learning.springboot.technicalacademyenrollmentapp.enums.InstructorStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(description = "Response representation containing instructor details")
public class InstructorResponseDto {

    @Schema(description = "Unique identifier of the instructor", example = "1")
    private Long id;

    @Schema(description = "Instructor's first name", example = "John")
    private String firstName;

    @Schema(description = "Instructor's last name", example = "Doe")
    private String lastName;

    @Schema(description = "Instructor's email address", example = "john.doe@academy.com")
    private String email;

    @Schema(description = "Contact phone number", example = "+1234567890")
    private String mobile;

    @Schema(description = "Date of joining", example = "2024-01-15")
    private LocalDate joiningDate;

    @Schema(description = "Instructor salary", example = "75000.00")
    private double salary;

    @Schema(description = "Date of birth", example = "1988-05-20")
    private LocalDate dob;

    @Schema(description = "Employment status", example = "ACTIVE")
    private InstructorStatus status;

    @Schema(description = "Highest qualification", example = "M.S. in Computer Science")
    private String qualification;

    @Schema(description = "Record creation timestamp", example = "2024-01-15T09:00:00")
    private LocalDateTime createdAt;

    @Schema(description = "Record last update timestamp", example = "2024-01-15T09:00:00")
    private LocalDateTime updatedAt;
}
