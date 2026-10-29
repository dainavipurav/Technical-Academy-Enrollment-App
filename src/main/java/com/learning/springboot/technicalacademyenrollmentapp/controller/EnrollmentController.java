package com.learning.springboot.technicalacademyenrollmentapp.controller;

import com.learning.springboot.technicalacademyenrollmentapp.dto.enrollment.EnrollmentRequestDto;
import com.learning.springboot.technicalacademyenrollmentapp.dto.enrollment.EnrollmentResponseDto;
import com.learning.springboot.technicalacademyenrollmentapp.dto.error.ErrorResponseDto;
import com.learning.springboot.technicalacademyenrollmentapp.dto.success.SuccessResponseDto;
import com.learning.springboot.technicalacademyenrollmentapp.service.EnrollmentService;
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

import java.util.List;

@Tag(name = "Enrollments", description = "APIs for managing student course enrollments in Technical Academy")
@RestController
@RequestMapping("/api/enrollments")
@RequiredArgsConstructor
@Validated
public class EnrollmentController {

    private final EnrollmentService enrollmentService;

    @Operation(summary = "Get all enrollments", description = "Fetch a list of all course enrollments across the academy.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved enrollment list",
                    content = @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = EnrollmentResponseDto.class))))
    })
    @GetMapping
    public List<EnrollmentResponseDto> getAllEnrollments(){
        return enrollmentService.getAllEnrollments();
    }

    @Operation(summary = "Get enrollment by ID", description = "Retrieve details of a specific enrollment using its unique ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Enrollment retrieved successfully",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = EnrollmentResponseDto.class))),
            @ApiResponse(responseCode = "404", description = "Enrollment not found",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponseDto.class)))
    })
    @GetMapping("/{id}")
    public EnrollmentResponseDto getEnrollmentById(
            @Parameter(description = "ID of the enrollment to retrieve", example = "1", required = true)
            @PathVariable long id){
        return enrollmentService.getEnrollmentById(id);
    }

    @Operation(summary = "Create an enrollment", description = "Enroll a student into a specific course.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Enrollment created successfully",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = EnrollmentResponseDto.class))),
            @ApiResponse(responseCode = "400", description = "Validation error or invalid request payload",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponseDto.class))),
            @ApiResponse(responseCode = "404", description = "Student or course not found",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponseDto.class)))
    })
    @PostMapping
    public EnrollmentResponseDto addEnrollment(@Valid @RequestBody EnrollmentRequestDto request){
        return enrollmentService.addEnrollment(request);
    }

    @Operation(summary = "Update enrollment by ID", description = "Update course enrollment details for an existing enrollment record.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Enrollment updated successfully",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = EnrollmentResponseDto.class))),
            @ApiResponse(responseCode = "400", description = "Validation error or invalid request payload",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponseDto.class))),
            @ApiResponse(responseCode = "404", description = "Enrollment, student, or course not found",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponseDto.class)))
    })
    @PutMapping("/{id}")
    public EnrollmentResponseDto updateEnrollmentById(
            @Parameter(description = "ID of the enrollment to update", example = "1", required = true)
            @PathVariable long id,
            @Valid @RequestBody EnrollmentRequestDto request){
        return enrollmentService.updateEnrollmentById(id, request);
    }

    @Operation(summary = "Delete enrollment by ID", description = "Remove an enrollment record from the system by its ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Enrollment deleted successfully",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = SuccessResponseDto.class))),
            @ApiResponse(responseCode = "404", description = "Enrollment not found",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponseDto.class)))
    })
    @DeleteMapping("/{id}")
    public SuccessResponseDto deleteEnrollmentById(
            @Parameter(description = "ID of the enrollment to delete", example = "1", required = true)
            @PathVariable long id){
        return enrollmentService.deleteEnrollmentById(id);
    }
}
