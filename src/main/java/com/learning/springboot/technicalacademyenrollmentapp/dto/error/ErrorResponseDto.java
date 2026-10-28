package com.learning.springboot.technicalacademyenrollmentapp.dto.error;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(description = "Standard API error response payload")
public class ErrorResponseDto {

    @Schema(description = "HTTP status code", example = "404")
    private int status;

    @Schema(description = "Error or exception message", example = "Student not found with id: 1")
    private String message;

    @Schema(description = "Endpoint URI where the error occurred", example = "/api/students/1")
    private String path;

    @Schema(description = "Epoch timestamp in milliseconds", example = "1710000000000")
    private long timestamp;
}
