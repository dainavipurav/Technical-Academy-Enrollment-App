package com.learning.springboot.technicalacademyenrollmentapp.entity;

import com.learning.springboot.technicalacademyenrollmentapp.enums.StudentStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Table(name = "students")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "mobile")
    private String mobile;

    @Column(name = "gender")
    private String gender;

    @Column(name = "address")
    private String address;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "status")
    private StudentStatus status;

    @Column(name = "fees")
    private Double fees;

    @Column(name = "dob")
    private LocalDate dob;

    /**
     * TODO: Add this @OneToMany relationship only if you need to retrieve
     * all enrollments associated with this course.
     * Example: Similar to how a Cart entity maintains a list of all products
     * associated with it.
     */
//    @OneToMany(mappedBy = "student", fetch = FetchType.LAZY)
//    private List<EnrollmentEntity> enrollments;

    @Column(name = "created_at", nullable = false, insertable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false, insertable = false, updatable = false)
    private LocalDateTime updatedAt;

}
