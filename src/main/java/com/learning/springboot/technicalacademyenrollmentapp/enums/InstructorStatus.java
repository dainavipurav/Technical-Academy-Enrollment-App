package com.learning.springboot.technicalacademyenrollmentapp.enums;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Employment status of the instructor")
public enum InstructorStatus {
    ACTIVE, INACTIVE, PENDING, SUSPEND, COMPLETED, REMOVED, ON_LEAVE
}
