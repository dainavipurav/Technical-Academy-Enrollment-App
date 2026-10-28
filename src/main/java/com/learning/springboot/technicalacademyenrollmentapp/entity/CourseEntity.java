package com.learning.springboot.technicalacademyenrollmentapp.entity;

import com.learning.springboot.technicalacademyenrollmentapp.enums.CourseLevel;
import com.learning.springboot.technicalacademyenrollmentapp.enums.CourseStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "courses")
public class CourseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn( 
            name = "instructor_id",
            foreignKey = @ForeignKey(name = "fk_course_instructor")
    )
    private InstructorEntity instructor;

    @Column(name = "course_name")
    private String courseName;

    @Column(name = "course_code")
    private String courseCode;

    @Column(name = "description")
    private String description;

    @Column(name = "duration")
    private int duration;

    @Column(name = "fees")
    private double fees;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "levels")
    private CourseLevel levels;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "status")
    private CourseStatus status;

    @Column(name = "started_at")
    private LocalDate startedAt;

    @Column(name = "ended_at")
    private LocalDate endedAt;

    /**
     * TODO: Add this @OneToMany relationship only if you need to retrieve
     * all enrollments associated with this course.
     * Example: Similar to how a Cart entity maintains a list of all products
     * associated with it.
     */
    // @OneToMany(mappedBy = "course", fetch = FetchType.LAZY)
    // private List<EnrollmentEntity> enrollments;

    @Column(name = "created_at", insertable = false, updatable = false, nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", insertable = false, updatable = false, nullable = false)
    private LocalDateTime updatedAt;

}
