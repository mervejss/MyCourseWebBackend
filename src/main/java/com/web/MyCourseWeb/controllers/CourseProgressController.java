package com.web.MyCourseWeb.controllers;

import com.web.MyCourseWeb.entities.CourseProgress;
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
    public List<CourseProgress> getAllCourseProgresses() {
        return courseProgressService.getAllCourseProgresses();
    }

    @PostMapping
    public CourseProgress createCourseProgress(@RequestBody CourseProgress newCourseProgress) {
        return courseProgressService.saveOneCourseProgress(newCourseProgress);
    }

    @GetMapping("/{courseProgressID}")
    public ResponseEntity<CourseProgress> getOneCourseProgress(@PathVariable Long courseProgressID) {
        CourseProgress courseProgress = courseProgressService.getOneCourseProgress(courseProgressID);
        return courseProgress != null ? ResponseEntity.ok(courseProgress) : ResponseEntity.notFound().build();
    }

    @PutMapping("/{courseProgressID}")
    public ResponseEntity<CourseProgress> updateOneCourseProgress(@PathVariable Long courseProgressID, @RequestBody CourseProgress newCourseProgress) {
        CourseProgress updatedCourseProgress = courseProgressService.updateOneCourseProgress(courseProgressID, newCourseProgress);
        return updatedCourseProgress != null ? ResponseEntity.ok(updatedCourseProgress) : ResponseEntity.notFound().build();
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

}
