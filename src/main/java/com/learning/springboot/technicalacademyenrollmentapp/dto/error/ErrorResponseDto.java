package com.learning.springboot.technicalacademyenrollmentapp.dto.error;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ErrorResponseDto {
    private int status;
    private String message;
    private String path;
    private long timestamp;
}
