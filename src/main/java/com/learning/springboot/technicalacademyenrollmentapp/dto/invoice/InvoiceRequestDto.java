package com.learning.springboot.technicalacademyenrollmentapp.dto.invoice;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InvoiceRequestDto {

    @NotNull(message = "Enrollment is required")
    @Positive(message = "Enrollment ID must be positive")
    private long enrollmentId;

    @NotNull(message = "Amount is required")
    @Positive(message = "Amount must be positive")
    private double amount;

    @NotNull(message = "Student name is required")
    private String studentName;

    @NotNull(message = "Course name is required")
    private String courseName;

    private String toEmail;
    private String emailTemplate;
    private LocalDate enrollmentDate;
    private String enrollmentStatus;
    private String invoiceDownloadPath;
}

