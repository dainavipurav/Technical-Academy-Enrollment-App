package com.learning.springboot.technicalacademyenrollmentapp.dto.email;
import com.learning.springboot.technicalacademyenrollmentapp.enums.EmailTemplate;
import com.learning.springboot.technicalacademyenrollmentapp.enums.EnrollmentStatus;
import com.learning.springboot.technicalacademyenrollmentapp.enums.StudentStatus;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmailRequestDto {

    @NotNull(message = "Recepient's email required")
    private String toEmail;

    @Builder.Default
    private EmailTemplate emailTemplate = EmailTemplate.STUDENT_REGISTRATION_EMAIL_TEMPLATE;

    @NotNull(message = "Student name required")
    private String studentName;

    @NotNull(message = "Course name required")
    private String courseName;

    @NotNull(message = "Enrollment date required")
    private LocalDate enrollmentDate;

    @Builder.Default
    private EnrollmentStatus studentStatus = EnrollmentStatus.PENDING;

    @NotNull(message = "Invoice path is required")
    private String invoiceDownloadPath;
}