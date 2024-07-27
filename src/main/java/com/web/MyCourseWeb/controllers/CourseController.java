package com.web.MyCourseWeb.controllers;

import com.web.MyCourseWeb.entities.Course;
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
    public List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }

    @PostMapping
    public Course createCourse(@RequestBody Course newCourse) {
        return courseService.saveOneCourse(newCourse);
    }

    @GetMapping("/{courseID}")
    public ResponseEntity<Course> getOneCourse(@PathVariable Long courseID) {
        Course course = courseService.getOneCourse(courseID);
        return course != null ? ResponseEntity.ok(course) : ResponseEntity.notFound().build();
    }

    @PutMapping("/{courseID}")
    public ResponseEntity<Course> updateOneCourse(@PathVariable Long courseID, @RequestBody Course newCourse) {
        Course updatedCourse = courseService.updateOneCourse(courseID, newCourse);
        return updatedCourse != null ? ResponseEntity.ok(updatedCourse) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{courseID}")
    public ResponseEntity<Void> deleteOneCourse(@PathVariable Long courseID) {
        courseService.deleteOneCourse(courseID);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping
    public void deleteAllUsers() {
        courseService.deleteAllCourses();
    }

}
