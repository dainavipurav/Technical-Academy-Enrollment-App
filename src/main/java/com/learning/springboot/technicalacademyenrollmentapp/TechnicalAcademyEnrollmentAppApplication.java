package com.learning.springboot.technicalacademyenrollmentapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class TechnicalAcademyEnrollmentAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(TechnicalAcademyEnrollmentAppApplication.class, args);
    }

}
