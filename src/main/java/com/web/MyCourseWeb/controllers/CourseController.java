package com.web.MyCourseWeb.controllers;

import com.web.MyCourseWeb.dtos.CourseDTO;
import com.web.MyCourseWeb.entities.Course;
import com.web.MyCourseWeb.entities.CourseCategory;
import com.web.MyCourseWeb.entities.User;
import com.web.MyCourseWeb.services.CourseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/courses")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public ResponseEntity<List<CourseDTO>> getAllCoursesWithUserNames() {
        List<CourseDTO> courses = courseService.getAllCourses();
        return ResponseEntity.ok(courses);
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


    @GetMapping("/courseDetails/{courseId}")
    public Map<String, Object> getCourseDetails(@PathVariable Long courseId) {
        Map<String, Object> response = new HashMap<>();

        Optional<Course> courseOpt = courseService.getCourseDetails(courseId);
        if (courseOpt.isPresent()) {
            Course course = courseOpt.get();
            response.put("courseID", course.getCourseID());

            response.put("courseName", course.getCourseName());
            response.put("courseDescription", course.getCourseDescription());
            response.put("courseTotalTime", course.getCourseTotalTime());
            response.put("coursePrice", course.getCoursePrice());
            response.put("courseScore", course.getCourseScore());

            Optional<CourseCategory> categoryOpt = courseService.getCourseCategory(course.getCourseCategoryID().getCourseCategoryID());
            categoryOpt.ifPresent(courseCategory -> {
                if (courseCategory.getParentCategory() == null) {
                    response.put("subCategoryName", null);

                    response.put("mainCategoryName", courseCategory.getCourseCategoryName());


                } else {
                    response.put("subCategoryName", courseCategory.getCourseCategoryName());
                    response.put("mainCategoryName", courseCategory.getParentCategory().getCourseCategoryName());
                }
            });

            Optional<User> userOpt = courseService.getUser(course.getUserID().getUserID());
            userOpt.ifPresent(user -> response.put("userFullName", user.getUserFullName()));
        }

        return response;
    }


    @GetMapping("/user/{courseID}")
    public ResponseEntity<Long> getCourseOwner(@PathVariable Long courseID) {
        Optional<Course> courseOpt = courseService.getCourseDetails(courseID);
        if (courseOpt.isPresent()) {
            Course course = courseOpt.get();
            Long ownerID = course.getUserID().getUserID();
            return ResponseEntity.ok(ownerID);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @GetMapping("/courses/byCategory/{categoryId}")
    public ResponseEntity<List<CourseDTO>> getCoursesByCategory(@PathVariable Long categoryId) {
        List<CourseDTO> courses = courseService.getCoursesByCategory(categoryId);
        return ResponseEntity.ok(courses);
    }


    @GetMapping("/withUser/{userID}")
    public ResponseEntity<List<CourseDTO>> getCoursesByUserID(@PathVariable Long userID) {
        List<CourseDTO> courses = courseService.getCoursesByUserID(userID);
        if (courses.isEmpty()) {
            return ResponseEntity.noContent().build(); // Eğer kurs yoksa 204 döndür
        }
        return ResponseEntity.ok(courses);
    }

    @PutMapping("/updateUserID/{newUserID}")
    public ResponseEntity<Void> updateAllCoursesUserID(@PathVariable Long newUserID) {
        try {
            courseService.updateAllCoursesUserID(newUserID);
            return ResponseEntity.ok().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }



}
