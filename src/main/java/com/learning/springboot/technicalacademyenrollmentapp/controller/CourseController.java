package com.learning.springboot.technicalacademyenrollmentapp.controller;

import com.learning.springboot.technicalacademyenrollmentapp.dto.course.CourseRequestDto;
import com.learning.springboot.technicalacademyenrollmentapp.dto.course.CourseResponseDto;
import com.learning.springboot.technicalacademyenrollmentapp.dto.error.ErrorResponseDto;
import com.learning.springboot.technicalacademyenrollmentapp.service.CourseService;
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

@Tag(name = "Courses", description = "APIs for managing courses in Technical Academy")
@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/api/courses")
public class CourseController {

    private final CourseService courseService;

    @Operation(summary = "Get all courses", description = "Fetch a list of all courses offered by the academy.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved course list",
                    content = @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = CourseResponseDto.class))))
    })
    @GetMapping
    public List<CourseResponseDto> getAllCourses(){
        return courseService.getAllCourses();
    }

    @Operation(summary = "Get course by ID", description = "Retrieve details of a specific course using its unique ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Course retrieved successfully",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = CourseResponseDto.class))),
            @ApiResponse(responseCode = "404", description = "Course not found",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponseDto.class)))
    })
    @GetMapping("/{id}")
    public CourseResponseDto getCourseById(
            @Parameter(description = "ID of the course to retrieve", example = "1", required = true)
            @PathVariable long id){
        return courseService.getCourseById(id);
    }

    @Operation(summary = "Create a new course", description = "Add a new course to the academy catalog.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Course created successfully",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = CourseResponseDto.class))),
            @ApiResponse(responseCode = "400", description = "Validation error or invalid request payload",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponseDto.class))),
            @ApiResponse(responseCode = "404", description = "Instructor not found for given instructorId",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponseDto.class)))
    })
    @PostMapping
    public CourseResponseDto addCourse(@Valid @RequestBody CourseRequestDto request){
        return courseService.addCourse(request);
    }

    @Operation(summary = "Update course by ID", description = "Update course details for an existing course.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Course updated successfully",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = CourseResponseDto.class))),
            @ApiResponse(responseCode = "400", description = "Validation error or invalid request payload",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponseDto.class))),
            @ApiResponse(responseCode = "404", description = "Course or instructor not found",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponseDto.class)))
    })
    @PutMapping("/{id}")
    public CourseResponseDto updateCourseById(
            @Parameter(description = "ID of the course to update", example = "1", required = true)
            @PathVariable long id,
            @Valid @RequestBody CourseRequestDto request){
        return courseService.updateCourseById(id, request);
    }

    @Operation(summary = "Delete course by ID", description = "Remove a course record from the academy catalog.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Course deleted successfully",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = CourseResponseDto.class))),
            @ApiResponse(responseCode = "404", description = "Course not found",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponseDto.class)))
    })
    @DeleteMapping("/{id}")
    public CourseResponseDto deleteCourseById(
            @Parameter(description = "ID of the course to delete", example = "1", required = true)
            @PathVariable long id){
        return courseService.deleteCourseById(id);
    }
}
