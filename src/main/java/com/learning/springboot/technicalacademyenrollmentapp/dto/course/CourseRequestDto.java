
package com.learning.springboot.technicalacademyenrollmentapp.dto.course;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.learning.springboot.technicalacademyenrollmentapp.enums.CourseLevel;
import com.learning.springboot.technicalacademyenrollmentapp.enums.CourseStatus;
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
public class CourseRequestDto {

    private Long instructorId;

    @NotBlank(message = "Course name is required")
    private String courseName;

    @NotBlank(message = "Course code is required")
    @Size(max = 50)
    private String courseCode;

    private String description;

    @NotNull(message = "Duration is required")
    @Min(value = 1, message = "Duration must be at least 1")
    private Integer duration;

    @NotNull(message = "Fees are required")
    @DecimalMin(value = "0.0", message = "Fees cannot be negative")
    private BigDecimal fees;

    private CourseLevel levels;

    private CourseStatus status;

    private LocalDate startedAt;
    private LocalDate endedAt;
}
