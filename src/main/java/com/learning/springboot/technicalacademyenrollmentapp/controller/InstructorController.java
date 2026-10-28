package com.learning.springboot.technicalacademyenrollmentapp.controller;

import com.learning.springboot.technicalacademyenrollmentapp.dto.error.ErrorResponseDto;
import com.learning.springboot.technicalacademyenrollmentapp.dto.instructor.InstructorRequestDto;
import com.learning.springboot.technicalacademyenrollmentapp.dto.instructor.InstructorResponseDto;
import com.learning.springboot.technicalacademyenrollmentapp.service.InstructorService;
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

@Tag(name = "Instructors", description = "APIs for managing instructors in Technical Academy")
@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/api/instructors")
public class InstructorController {

    private final InstructorService instructorService;

    @Operation(summary = "Get all instructors", description = "Fetch a list of all instructors in the academy.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved instructor list",
                    content = @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = InstructorResponseDto.class))))
    })
    @GetMapping
    public List<InstructorResponseDto> getAllInstructors(){
        return instructorService.getAllInstructors();
    }

    @Operation(summary = "Get instructor by ID", description = "Retrieve details of a specific instructor by their ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Instructor retrieved successfully",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = InstructorResponseDto.class))),
            @ApiResponse(responseCode = "404", description = "Instructor not found",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponseDto.class)))
    })
    @GetMapping("{id}")
    public InstructorResponseDto getInstructorById(
            @Parameter(description = "ID of the instructor to retrieve", example = "1", required = true)
            @PathVariable long id){
        return instructorService.getInstructorById(id);
    }

    @Operation(summary = "Register a new instructor", description = "Add a new instructor to the academy.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Instructor created successfully",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = InstructorResponseDto.class))),
            @ApiResponse(responseCode = "400", description = "Validation error or invalid request payload",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponseDto.class)))
    })
    @PostMapping
    public InstructorResponseDto addInstructor(@Valid @RequestBody InstructorRequestDto request){
        return instructorService.addInstructor(request);
    }

    @Operation(summary = "Update instructor by ID", description = "Update the profile or details of an existing instructor.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Instructor updated successfully",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = InstructorResponseDto.class))),
            @ApiResponse(responseCode = "400", description = "Validation error or invalid request payload",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponseDto.class))),
            @ApiResponse(responseCode = "404", description = "Instructor not found",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponseDto.class)))
    })
    @PutMapping("/{id}")
    public InstructorResponseDto updateInstructorById(
            @Parameter(description = "ID of the instructor to update", example = "1", required = true)
            @PathVariable long id,
            @Valid @RequestBody InstructorRequestDto request){
        return instructorService.updateInstructorById(id, request);
    }

    @Operation(summary = "Delete instructor by ID", description = "Remove an instructor record from the academy.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Instructor deleted successfully",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = InstructorResponseDto.class))),
            @ApiResponse(responseCode = "404", description = "Instructor not found",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponseDto.class)))
    })
    @DeleteMapping("/{id}")
    public InstructorResponseDto deleteInstructorById(
            @Parameter(description = "ID of the instructor to delete", example = "1", required = true)
            @PathVariable long id){
        return instructorService.deleteInstructorById(id);
    }

}
