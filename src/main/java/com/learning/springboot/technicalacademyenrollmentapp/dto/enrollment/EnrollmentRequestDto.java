package com.learning.springboot.technicalacademyenrollmentapp.dto.enrollment;

import com.learning.springboot.technicalacademyenrollmentapp.enums.EnrollmentStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(description = "Data Transfer Object for creating or updating an enrollment")
public class EnrollmentRequestDto {

    @Schema(description = "ID of the student being enrolled", example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
    private long student;

    @Schema(description = "ID of the course to enroll in", example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
    private long course;

    @Schema(description = "Date of enrollment", example = "2026-10-29")
    private LocalDate enrollmentDate;

    @Schema(description = "Status of the enrollment", example = "ENROLLED")
    private EnrollmentStatus status;
}
