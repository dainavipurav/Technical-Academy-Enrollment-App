package com.learning.springboot.technicalacademyenrollmentapp.enums;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Difficulty or proficiency level of the course")
public enum CourseLevel {
    BEGINNER, INTERMEDIATE, ADVANCED
}
