package com.learning.springboot.technicalacademyenrollmentapp.dto.course;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import com.learning.springboot.technicalacademyenrollmentapp.dto.instructor.InstructorResponseDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(description = "Response representation containing course details")
public class CourseResponseDto {

    @Schema(description = "Unique identifier of the course", example = "1")
    private Long id;

    @Schema(description = "Assigned instructor details")
    private InstructorResponseDto instructor;

    @Schema(description = "Name of the course", example = "Java Full Stack Development")
    private String courseName;

    @Schema(description = "Unique course code", example = "CS-101")
    private String courseCode;

    @Schema(description = "Detailed course description", example = "Comprehensive introduction to Java, Spring Boot, and React.")
    private String description;

    @Schema(description = "Course duration in hours or weeks", example = "40")
    private Integer duration;

    @Schema(description = "Course enrollment fee", example = "499.99")
    private BigDecimal fees;

    @Schema(description = "Course proficiency level", example = "BEGINNER")
    private String levels;

    @Schema(description = "Course operational status", example = "ACTIVE")
    private String status;

    @Schema(description = "Course start date", example = "2026-09-01")
    private LocalDate startedAt;

    @Schema(description = "Course end date", example = "2026-12-15")
    private LocalDate endedAt;

    @Schema(description = "Record creation timestamp", example = "2026-08-01T10:15:30")
    private LocalDateTime createdAt;

    @Schema(description = "Record last update timestamp", example = "2026-08-10T14:20:00")
    private LocalDateTime updatedAt;
}
