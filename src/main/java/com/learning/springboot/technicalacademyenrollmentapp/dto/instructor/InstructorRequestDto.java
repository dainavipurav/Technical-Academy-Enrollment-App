package com.learning.springboot.technicalacademyenrollmentapp.dto.instructor;
import java.time.LocalDate;

import com.learning.springboot.technicalacademyenrollmentapp.enums.InstructorStatus;
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
public class InstructorRequestDto {

    @NotBlank(message = "First name is required")
    @Size(max = 50)
    private String firstName;

    @NotBlank(message = "Last name is required")
    @Size(max = 50)
    private String lastName;

    @NotBlank(message = "Email is required")
    @Email(message = "Please provide a valid email")
    @Size(max = 100)
    private String email;

    @Size(max = 15)
    private String mobile;

    private LocalDate joiningDate;

    @NotNull(message = "Salary is required")
    @DecimalMin(value = "0.0", message = "Salary cannot be negative")
    private double salary;

    private LocalDate dob;

    private InstructorStatus status;

    @Size(max = 50)
    private String qualification;
}
