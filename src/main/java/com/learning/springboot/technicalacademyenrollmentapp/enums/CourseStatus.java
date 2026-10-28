package com.learning.springboot.technicalacademyenrollmentapp.enums;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Operational status of the course")
public enum CourseStatus {
    ACTIVE, INACTIVE, PENDING, SUSPEND, COMPLETED, REMOVED
}
