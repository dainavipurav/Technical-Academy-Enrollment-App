
package com.learning.springboot.technicalacademyenrollmentapp.dto.course;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CourseResponseDto {

    private Long id;
    private Long instructorId;
    private String courseName;
    private String courseCode;
    private String description;
    private Integer duration;
    private BigDecimal fees;
    private String levels;
    private String status;
    private LocalDate startedAt;
    private LocalDate endedAt;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
