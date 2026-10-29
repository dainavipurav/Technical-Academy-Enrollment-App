package com.learning.springboot.technicalacademyenrollmentapp.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum EmailTemplate {
    SIMPLE_EMAIL_TEMPLATE,
    NEW_COURSE_PROMOTION_EMAIL_TEMPLATE,
    INSTRUCTOR_REGISTRATION_EMAIL_TEMPLATE,
    STUDENT_REGISTRATION_EMAIL_TEMPLATE,
    INFO_EMAIL_TEMPLATE
}
