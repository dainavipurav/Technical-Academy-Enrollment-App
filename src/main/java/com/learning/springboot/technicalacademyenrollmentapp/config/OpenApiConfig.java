package com.learning.springboot.technicalacademyenrollmentapp.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import io.swagger.v3.oas.models.tags.Tag;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI technicalAcademyOpenAPI() {
        Server localServer = new Server()
                .url("http://localhost:8080")
                .description("Local Development Server");

        Contact contact = new Contact()
                .name("Technical Academy Support")
                .email("support@technicalacademy.com")
                .url("https://technicalacademy.com");

        License license = new License()
                .name("Apache 2.0")
                .url("https://www.apache.org/licenses/LICENSE-2.0.html");

        Info info = new Info()
                .title("Technical Academy Enrollment API")
                .version("1.0.0")
                .description("RESTful APIs for managing students, courses, instructors, and enrollments in Technical Academy.")
                .contact(contact)
                .license(license);

        Tag coursesTag = new Tag()
                .name("Courses")
                .description("APIs for managing courses in Technical Academy");

        Tag instructorsTag = new Tag()
                .name("Instructors")
                .description("APIs for managing instructors in Technical Academy");

        Tag studentsTag = new Tag()
                .name("Students")
                .description("APIs for managing student records and enrollments in Technical Academy");

        Tag enrollmentsTag = new Tag()
                .name("Enrollments")
                .description("APIs for managing student course enrollments in Technical Academy");

        return new OpenAPI()
                .info(info)
                .servers(List.of(localServer))
                .tags(List.of(coursesTag, instructorsTag, studentsTag, enrollmentsTag));
    }
}
