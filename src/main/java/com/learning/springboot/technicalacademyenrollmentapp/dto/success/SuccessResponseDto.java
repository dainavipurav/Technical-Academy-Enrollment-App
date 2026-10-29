package com.learning.springboot.technicalacademyenrollmentapp.dto.success;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Schema(description = "Standard API generic success response payload")
public class SuccessResponseDto {

    @Schema(description = "Success message", example = "Operation completed successfully")
    private String message;

    @Schema(description = "HTTP status code", example = "200")
    private int status;

    @Schema(description = "Timestamp when the operation succeeded", example = "2026-10-29T12:00:00")
    private LocalDateTime timestamp;
}