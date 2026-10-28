package com.learning.springboot.technicalacademyenrollmentapp.entity;

import com.learning.springboot.technicalacademyenrollmentapp.enums.InstructorStatus;
import com.learning.springboot.technicalacademyenrollmentapp.enums.StudentStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "instructors")
public class InstructorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "first_name" )
    private String firstName;

    @Column(name = "last_name" )
    private String lastName;

    @Column(name = "email" )
    private String email;

    @Column(name = "mobile" )
    private String mobile;

    @Column(name = "joining_date")
    private LocalDate joiningDate;

    @Column(name = "salary")
    private double salary;

    @Column(name = "DOB")
    private LocalDate dob;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "status" )
    private InstructorStatus status;

    @Column(name = "qualification")
    private String qualification;

    @Column(name = "created_at", updatable = false, insertable = false, nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false, insertable = false, updatable = false)
    private LocalDateTime updatedAt;
}
