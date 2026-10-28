package com.learning.springboot.technicalacademyenrollmentapp.dto.instructor;

import java.time.LocalDate;

import com.learning.springboot.technicalacademyenrollmentapp.enums.InstructorStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Email;
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
@Schema(description = "Data Transfer Object for registering or updating an instructor")
public class InstructorRequestDto {

    @NotBlank(message = "First name is required")
    @Size(max = 50)
    @Schema(description = "Instructor's first name", example = "John", maxLength = 50, requiredMode = Schema.RequiredMode.REQUIRED)
    private String firstName;

    @NotBlank(message = "Last name is required")
    @Size(max = 50)
    @Schema(description = "Instructor's last name", example = "Doe", maxLength = 50, requiredMode = Schema.RequiredMode.REQUIRED)
    private String lastName;

    @NotBlank(message = "Email is required")
    @Email(message = "Please provide a valid email")
    @Size(max = 100)
    @Schema(description = "Unique contact email address", example = "john.doe@academy.com", maxLength = 100, requiredMode = Schema.RequiredMode.REQUIRED)
    private String email;

    @Size(max = 15)
    @Schema(description = "Contact phone / mobile number", example = "+1234567890", maxLength = 15)
    private String mobile;

    @Schema(description = "Date when instructor joined the academy", example = "2024-01-15")
    private LocalDate joiningDate;

    @NotNull(message = "Salary is required")
    @DecimalMin(value = "0.0", message = "Salary cannot be negative")
    @Schema(description = "Monthly or annual salary", example = "75000.00", minimum = "0.0", requiredMode = Schema.RequiredMode.REQUIRED)
    private double salary;

    @Schema(description = "Date of birth", example = "1988-05-20")
    private LocalDate dob;

    @Schema(description = "Instructor employment status", example = "ACTIVE")
    private InstructorStatus status;

    @Size(max = 50)
    @Schema(description = "Highest educational or professional qualification", example = "M.S. in Computer Science", maxLength = 50)
    private String qualification;
}
