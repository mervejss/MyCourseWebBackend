package com.web.MyCourseWeb.controllers;

import com.web.MyCourseWeb.dtos.CourseProgressDTO;
import com.web.MyCourseWeb.services.CourseProgressService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courseProgresses")
public class CourseProgressController {

    private final CourseProgressService courseProgressService;

    public CourseProgressController(CourseProgressService courseProgressService) {
        this.courseProgressService = courseProgressService;
    }

    @GetMapping
    public List<CourseProgressDTO> getAllCourseProgresses() {
        return courseProgressService.getAllCourseProgresses();
    }

    @PostMapping
    public ResponseEntity<CourseProgressDTO> createCourseProgress(@RequestBody CourseProgressDTO newCourseProgressDTO) {
        CourseProgressDTO createdCourseProgress = courseProgressService.saveOneCourseProgress(newCourseProgressDTO);
        return ResponseEntity.ok(createdCourseProgress);
    }

    @GetMapping("/{courseProgressID}")
    public ResponseEntity<CourseProgressDTO> getOneCourseProgress(@PathVariable Long courseProgressID) {
        CourseProgressDTO courseProgressDTO = courseProgressService.getOneCourseProgress(courseProgressID);
        return courseProgressDTO != null ? ResponseEntity.ok(courseProgressDTO) : ResponseEntity.notFound().build();
    }

    @PutMapping("/{courseProgressID}")
    public ResponseEntity<CourseProgressDTO> updateOneCourseProgress(@PathVariable Long courseProgressID, @RequestBody CourseProgressDTO newCourseProgressDTO) {
        CourseProgressDTO updatedCourseProgressDTO = courseProgressService.updateOneCourseProgress(courseProgressID, newCourseProgressDTO);
        return updatedCourseProgressDTO != null ? ResponseEntity.ok(updatedCourseProgressDTO) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{courseProgressID}")
    public ResponseEntity<Void> deleteOneCourseProgress(@PathVariable Long courseProgressID) {
        courseProgressService.deleteOneCourseProgress(courseProgressID);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping
    public void deleteAllCourseProgress() {
        courseProgressService.deleteAllCourseProgress();
    }

    @GetMapping("/byUserAndCourse")
    public ResponseEntity<List<CourseProgressDTO>> getCourseProgressByUserAndCourse(
            @RequestParam Long userID, @RequestParam Long courseID) {
        List<CourseProgressDTO> progress = courseProgressService.getCourseProgressByUserAndCourse(userID, courseID);
        return ResponseEntity.ok(progress);
    }
    @GetMapping("/byUserAndCourseFull")
    public ResponseEntity<List<CourseProgressDTO>> getCourseProgressByUserAndCourseFull(
            @RequestParam Long userID, @RequestParam Long courseID) {
        List<CourseProgressDTO> progress = courseProgressService.getCourseProgressByUserAndCourse(userID, courseID);
        return ResponseEntity.ok(progress);
    }

}
