package com.web.MyCourseWeb.controllers;

import com.web.MyCourseWeb.dtos.CourseDTO;
import com.web.MyCourseWeb.services.CourseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public List<CourseDTO> getAllCourses() {
        return courseService.getAllCourses();
    }

    @PostMapping
    public ResponseEntity<CourseDTO> createCourse(@RequestBody CourseDTO newCourseDTO) {
        CourseDTO courseDTO = courseService.saveOneCourse(newCourseDTO);
        return ResponseEntity.ok(courseDTO);
    }

    @GetMapping("/{courseID}")
    public ResponseEntity<CourseDTO> getOneCourse(@PathVariable Long courseID) {
        CourseDTO courseDTO = courseService.getOneCourse(courseID);
        return courseDTO != null ? ResponseEntity.ok(courseDTO) : ResponseEntity.notFound().build();
    }

    @PutMapping("/{courseID}")
    public ResponseEntity<CourseDTO> updateOneCourse(@PathVariable Long courseID, @RequestBody CourseDTO newCourseDTO) {
        CourseDTO updatedCourseDTO = courseService.updateOneCourse(courseID, newCourseDTO);
        return updatedCourseDTO != null ? ResponseEntity.ok(updatedCourseDTO) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{courseID}")
    public ResponseEntity<Void> deleteOneCourse(@PathVariable Long courseID) {
        courseService.deleteOneCourse(courseID);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping
    public void deleteAllCourses() {
        courseService.deleteAllCourses();
    }
}
