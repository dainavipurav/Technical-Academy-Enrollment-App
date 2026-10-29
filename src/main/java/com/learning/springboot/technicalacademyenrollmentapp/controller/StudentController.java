package com.learning.springboot.technicalacademyenrollmentapp.controller;

import com.learning.springboot.technicalacademyenrollmentapp.dto.course.CourseResponseDto;
import com.learning.springboot.technicalacademyenrollmentapp.dto.enrollment.EnrollmentRequestDto;
import com.learning.springboot.technicalacademyenrollmentapp.dto.enrollment.EnrollmentResponseDto;
import com.learning.springboot.technicalacademyenrollmentapp.dto.error.ErrorResponseDto;
import com.learning.springboot.technicalacademyenrollmentapp.dto.student.StudentRequestDto;
import com.learning.springboot.technicalacademyenrollmentapp.dto.student.StudentResponseDto;
import com.learning.springboot.technicalacademyenrollmentapp.dto.success.SuccessResponseDto;
import com.learning.springboot.technicalacademyenrollmentapp.enums.EnrollmentStatus;
import com.learning.springboot.technicalacademyenrollmentapp.service.CourseService;
import com.learning.springboot.technicalacademyenrollmentapp.service.EnrollmentService;
import com.learning.springboot.technicalacademyenrollmentapp.service.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Tag(name = "Students", description = "APIs for managing student records and enrollments in Technical Academy")
@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService studentService;
    private final EnrollmentService enrollmentService;

    @Operation(summary = "Get all students", description = "Fetch a list of all students registered in the academy.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved student list",
                    content = @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = StudentResponseDto.class))))
    })
    @GetMapping
    public List<StudentResponseDto> getAllStudents(){
        return studentService.getAllStudents();
    }

    @Operation(summary = "Get student by ID", description = "Retrieve details of a specific student using their unique ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Student retrieved successfully",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = StudentResponseDto.class))),
            @ApiResponse(responseCode = "404", description = "Student not found",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponseDto.class)))
    })
    @GetMapping("/{id}")
    public StudentResponseDto getStudentById(
            @Parameter(description = "ID of the student to retrieve", example = "1", required = true)
            @PathVariable long id){
        return studentService.getStudentById(id);
    }

    @Operation(summary = "Register a new student", description = "Enroll and register a new student into the academy.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Student registered successfully",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = StudentResponseDto.class))),
            @ApiResponse(responseCode = "400", description = "Validation error or invalid request payload",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponseDto.class)))
    })
    @PostMapping
    public StudentResponseDto addStudent(@Valid @RequestBody StudentRequestDto request){
        return studentService.addStudent(request);
    }

    @Operation(summary = "Update student by ID", description = "Update personal and enrollment details of an existing student.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Student updated successfully",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = StudentResponseDto.class))),
            @ApiResponse(responseCode = "400", description = "Validation error or invalid request payload",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponseDto.class))),
            @ApiResponse(responseCode = "404", description = "Student not found",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponseDto.class)))
    })
    @PutMapping("/{id}")
    public StudentResponseDto updateStudent(
            @Parameter(description = "ID of the student to update", example = "1", required = true)
            @PathVariable long id,
            @Valid @RequestBody StudentRequestDto request){
        return studentService.updateStudent(id, request);
    }

    @Operation(summary = "Delete student by ID", description = "Remove a student record from the academy.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Student deleted successfully",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = StudentResponseDto.class))),
            @ApiResponse(responseCode = "404", description = "Student not found",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponseDto.class)))
    })
    @DeleteMapping("/{id}")
    public StudentResponseDto deleteStudent(
            @Parameter(description = "ID of the student to delete", example = "1", required = true)
            @PathVariable long id){
        return studentService.deleteStudent(id);
    }

    @Operation(summary = "Enroll student in course", description = "Enroll a student into a specific course using their respective IDs.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Student successfully enrolled in course",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = EnrollmentResponseDto.class))),
            @ApiResponse(responseCode = "404", description = "Student or course not found",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponseDto.class)))
    })
    @GetMapping("/{studentId}/enroll/{courseId}")
    public EnrollmentResponseDto enrollStudentInCourse(
            @Parameter(description = "ID of the student", example = "1", required = true)
            @PathVariable long studentId,
            @Parameter(description = "ID of the course", example = "1", required = true)
            @PathVariable long courseId){
        EnrollmentRequestDto request = EnrollmentRequestDto.builder()
                .student(studentId)
                .course(courseId)
                .enrollmentDate(LocalDate.now())
                .status(EnrollmentStatus.ENROLLED)
                .build();


        return enrollmentService.addEnrollment(request);
    }

    @Operation(summary = "Get courses by student ID", description = "Retrieve a list of all courses that a specific student is enrolled in.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved courses for student",
                    content = @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = CourseResponseDto.class)))),
            @ApiResponse(responseCode = "404", description = "Student not found",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponseDto.class)))
    })
    @GetMapping("/{studentId}/courses")
    public List<CourseResponseDto> getAllCoursesByStudentId(
            @Parameter(description = "ID of the student", example = "1", required = true)
            @PathVariable long studentId){
        return studentService.getAllCoursesByStudentId(studentId);
    }
}
