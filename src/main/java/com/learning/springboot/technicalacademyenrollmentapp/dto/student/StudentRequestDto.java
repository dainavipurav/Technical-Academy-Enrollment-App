package com.learning.springboot.technicalacademyenrollmentapp.dto.student;

import java.time.LocalDate;

import com.learning.springboot.technicalacademyenrollmentapp.enums.StudentStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(description = "Data Transfer Object for registering or updating a student")
public class StudentRequestDto {

    @NotBlank(message = "First name is required")
    @Size(max = 50)
    @Schema(description = "Student's first name", example = "Alice", maxLength = 50, requiredMode = Schema.RequiredMode.REQUIRED)
    private String firstName;

    @NotBlank(message = "Last name is required")
    @Size(max = 50)
    @Schema(description = "Student's last name", example = "Smith", maxLength = 50, requiredMode = Schema.RequiredMode.REQUIRED)
    private String lastName;

    @NotBlank(message = "Email is required")
    @Email(message = "Please provide a valid email")
    @Size(max = 50)
    @Schema(description = "Student's email address", example = "alice.smith@example.com", maxLength = 50, requiredMode = Schema.RequiredMode.REQUIRED)
    private String email;

    @Size(max = 50)
    @Schema(description = "Student's contact phone number", example = "+1987654321", maxLength = 50)
    private String mobile;

    @Size(max = 10)
    @Schema(description = "Gender of the student", example = "FEMALE", maxLength = 10)
    private String gender;

    @Size(max = 200)
    @Schema(description = "Residential or mailing address", example = "123 Academic Way, Tech City", maxLength = 200)
    private String address;

    @Schema(description = "Enrollment status of the student", example = "ACTIVE")
    private StudentStatus status;

    @NotNull(message = "Fees are required")
    @PositiveOrZero(message = "Fees cannot be negative")
    @Schema(description = "Tuition fees paid or payable", example = "1200.00", minimum = "0.0", requiredMode = Schema.RequiredMode.REQUIRED)
    private Double fees;

    @Schema(description = "Date of birth", example = "2001-04-12")
    private LocalDate dob;
}
