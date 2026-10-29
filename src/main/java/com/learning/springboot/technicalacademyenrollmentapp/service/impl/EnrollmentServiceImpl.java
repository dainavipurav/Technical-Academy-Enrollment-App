package com.learning.springboot.technicalacademyenrollmentapp.service.impl;

import com.learning.springboot.technicalacademyenrollmentapp.dto.enrollment.EnrollmentRequestDto;
import com.learning.springboot.technicalacademyenrollmentapp.dto.enrollment.EnrollmentResponseDto;
import com.learning.springboot.technicalacademyenrollmentapp.dto.success.SuccessResponseDto;
import com.learning.springboot.technicalacademyenrollmentapp.entity.CourseEntity;
import com.learning.springboot.technicalacademyenrollmentapp.entity.EnrollmentEntity;
import com.learning.springboot.technicalacademyenrollmentapp.entity.StudentEntity;
import com.learning.springboot.technicalacademyenrollmentapp.enums.EmailTemplate;
import com.learning.springboot.technicalacademyenrollmentapp.exception.CourseNotFoundException;
import com.learning.springboot.technicalacademyenrollmentapp.exception.EnrollmentNotFoundException;
import com.learning.springboot.technicalacademyenrollmentapp.exception.StudentNotFoundException;
import com.learning.springboot.technicalacademyenrollmentapp.mappers.CourseMapper;
import com.learning.springboot.technicalacademyenrollmentapp.mappers.EnrollmentMapper;
import com.learning.springboot.technicalacademyenrollmentapp.mappers.StudentMapper;
import com.learning.springboot.technicalacademyenrollmentapp.repository.CourseJpaRepository;
import com.learning.springboot.technicalacademyenrollmentapp.repository.EnrollmentJpaRepository;
import com.learning.springboot.technicalacademyenrollmentapp.repository.StudentJpaRepository;
import com.learning.springboot.technicalacademyenrollmentapp.service.EnrollmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class EnrollmentServiceImpl implements EnrollmentService {

    private final EnrollmentJpaRepository repository;

    private final EnrollmentMapper mapper;
    private final CourseMapper courseMapper;
    private final StudentMapper studentMapper;

    private final CourseJpaRepository courseJpaRepository;
    private final StudentJpaRepository studentJpaRepository;

    private final RestClient restClient;

    @Override
    public List<EnrollmentResponseDto> getAllEnrollments() {

        List<EnrollmentEntity> enrollmentEntities = repository.findAll();

        return enrollmentEntities.stream().map(mapper::toResponseDto).toList();
    }

    @Override
    public EnrollmentResponseDto getEnrollmentById(long id) {

        EnrollmentEntity enrollmentEntity = repository.findById(id).orElseThrow(() -> new EnrollmentNotFoundException("No Enrollment found with id : " + id));

        return mapper.toResponseDto(enrollmentEntity);
    }

    @Override
    public EnrollmentResponseDto addEnrollment(EnrollmentRequestDto request) {

        StudentEntity studentEntity = studentJpaRepository.findById(request.getStudent()).orElseThrow(() -> new StudentNotFoundException("No Student found with id : " + request.getStudent()));

        CourseEntity courseEntity = courseJpaRepository.findById(request.getCourse()).orElseThrow(() -> new CourseNotFoundException("No Course found with id : " + request.getCourse()));

        EnrollmentEntity enrollmentEntity = EnrollmentEntity.builder()
                .course(courseEntity)
                .student(studentEntity)
                .enrollmentDate(request.getEnrollmentDate())
                .status(request.getStatus())
                .build();

        EnrollmentResponseDto enrollmentResponseDto = mapper.toResponseDto(repository.save(enrollmentEntity));

        SuccessResponseDto successResponseDto = restClient.post()
                .uri(URI.create("http://localhost:8082/api/notification/email"))
                .body(Map.of(
                        "toEmail","imismail885@gmail.com",
                        "emailTemplate", EmailTemplate.STUDENT_REGISTRATION_EMAIL_TEMPLATE,
                        "studentName", studentEntity.getFirstName() + " " + studentEntity.getLastName(),
                        "courseName", courseEntity.getCourseName(),
                        "enrollmentDate", enrollmentEntity.getEnrollmentDate(),
                        "studentStatus", enrollmentEntity.getStatus()
                ))
                .retrieve()
                .body(SuccessResponseDto.class);

        System.out.println("Success : " + successResponseDto.toString());

        return enrollmentResponseDto;
    }

    @Override
    public EnrollmentResponseDto updateEnrollmentById(long id, EnrollmentRequestDto request) {
        EnrollmentEntity enrollmentEntity = repository.findById(id).orElseThrow(() -> new EnrollmentNotFoundException("No Enrollment found with id : " + id));
        CourseEntity courseEntity = courseJpaRepository.findById(request.getCourse()).orElseThrow(() -> new CourseNotFoundException("No Course found with id : " + request.getCourse()));
        StudentEntity studentEntity = studentJpaRepository.findById(request.getStudent()).orElseThrow(() -> new StudentNotFoundException("No Student found with id : " + request.getStudent()));

        enrollmentEntity.setCourse(courseEntity);
        enrollmentEntity.setEnrollmentDate(request.getEnrollmentDate());
        enrollmentEntity.setStatus(request.getStatus());
        enrollmentEntity.setStudent(studentEntity);

        return mapper.toResponseDto(repository.save(enrollmentEntity));
    }

    @Override
    public SuccessResponseDto deleteEnrollmentById(long id) {
        EnrollmentEntity enrollmentEntity = repository.findById(id).orElseThrow(() -> new EnrollmentNotFoundException("No Enrollment found with id : " + id));

        repository.deleteById(id);

        return SuccessResponseDto.builder().message("Enrollment deleted successfully").status(HttpStatus.OK.value()).timestamp(LocalDateTime.now()).build();
    }
}
