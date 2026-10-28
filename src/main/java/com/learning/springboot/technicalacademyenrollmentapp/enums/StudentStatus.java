package com.learning.springboot.technicalacademyenrollmentapp.enums;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Enrollment status of the student")
public enum StudentStatus {
    ACTIVE, INACTIVE, PENDING, SUSPEND, COMPLETED, REMOVED
}
