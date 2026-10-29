package com.learning.springboot.technicalacademyenrollmentapp.enums;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Operational status of an enrollment")
public enum EnrollmentStatus {
    ACTIVE, INACTIVE, PENDING, SUSPEND, COMPLETED, REMOVED, ON_LEAVE, ENROLLED, CANCELLED
}
