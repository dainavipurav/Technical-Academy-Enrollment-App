package com.learning.springboot.technicalacademyenrollmentapp.dto.course;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.learning.springboot.technicalacademyenrollmentapp.enums.CourseLevel;
import com.learning.springboot.technicalacademyenrollmentapp.enums.CourseStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(description = "Data Transfer Object for creating or updating a course")
public class CourseRequestDto {

    @Schema(description = "ID of the assigned instructor", example = "1")
    private Long instructorId;

    @NotBlank(message = "Course name is required")
    @Schema(description = "Name of the course", example = "Java Full Stack Development", requiredMode = Schema.RequiredMode.REQUIRED)
    private String courseName;

    @NotBlank(message = "Course code is required")
    @Size(max = 50)
    @Schema(description = "Unique code identifier for the course", example = "CS-101", maxLength = 50, requiredMode = Schema.RequiredMode.REQUIRED)
    private String courseCode;

    @Schema(description = "Detailed syllabus and summary of the course", example = "Comprehensive introduction to Java, Spring Boot, and React.")
    private String description;

    @NotNull(message = "Duration is required")
    @Min(value = 1, message = "Duration must be at least 1")
    @Schema(description = "Course duration in hours or weeks", example = "40", minimum = "1", requiredMode = Schema.RequiredMode.REQUIRED)
    private Integer duration;

    @NotNull(message = "Fees are required")
    @DecimalMin(value = "0.0", message = "Fees cannot be negative")
    @Schema(description = "Enrollment fee for the course", example = "499.99", minimum = "0.0", requiredMode = Schema.RequiredMode.REQUIRED)
    private Double fees;

    @Schema(description = "Target proficiency level of the course", example = "BEGINNER")
    private CourseLevel levels;

    @Schema(description = "Current operational status of the course", example = "ACTIVE")
    private CourseStatus status;

    @Schema(description = "Scheduled start date of the course", example = "2026-09-01")
    private LocalDate startedAt;

    @Schema(description = "Scheduled end date of the course", example = "2026-12-15")
    private LocalDate endedAt;
}
