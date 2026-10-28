package com.learning.springboot.technicalacademyenrollmentapp.dto.success;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SuccessResponseDto {
    private String message;
    private int status;
    private LocalDateTime timestamp;
}