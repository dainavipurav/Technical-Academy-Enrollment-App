package com.learning.springboot.technicalacademyenrollmentapp.dto.enrollment;

import com.learning.springboot.technicalacademyenrollmentapp.dto.course.CourseResponseDto;
import com.learning.springboot.technicalacademyenrollmentapp.dto.student.StudentResponseDto;
import com.learning.springboot.technicalacademyenrollmentapp.enums.EnrollmentStatus;
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
@Schema(description = "Response representation containing course enrollment details")
public class EnrollmentResponseDto {

    @Schema(description = "Unique identifier of the enrollment", example = "1")
    private long id;

    @Schema(description = "Enrolled student details")
    private StudentResponseDto student;

    @Schema(description = "Enrolled course details")
    private CourseResponseDto course;

    @Schema(description = "Date of enrollment", example = "2026-10-29")
    private LocalDate enrollmentDate;

    @Schema(description = "Current enrollment status", example = "ENROLLED")
    private EnrollmentStatus status;

    @Schema(description = "Record creation timestamp", example = "2026-10-29T10:00:00")
    private LocalDateTime createdAt;

    @Schema(description = "Record last update timestamp", example = "2026-10-29T10:00:00")
    private LocalDateTime updatedAt;
}
