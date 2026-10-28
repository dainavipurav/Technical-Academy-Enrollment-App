package com.learning.springboot.technicalacademyenrollmentapp.dto;


import java.time.LocalDate;

import com.learning.springboot.technicalacademyenrollmentapp.enums.StudentStatus;
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
public class StudentRequestDto {

    @NotBlank(message = "First name is required")
    @Size(max = 50)
    private String firstName;

    @NotBlank(message = "Last name is required")
    @Size(max = 50)
    private String lastName;

    @NotBlank(message = "Email is required")
    @Email(message = "Please provide a valid email")
    @Size(max = 50)
    private String email;

    @Size(max = 50)
    private String mobile;

    @Size(max = 10)
    private String gender;

    @Size(max = 200)
    private String address;

    private StudentStatus status;

    @NotNull(message = "Fees are required")
    @PositiveOrZero(message = "Fees cannot be negative")
    private Double fees;

    private LocalDate dob;
}
