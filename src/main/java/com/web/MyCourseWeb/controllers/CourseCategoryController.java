package com.web.MyCourseWeb.controllers;

import com.web.MyCourseWeb.entities.CourseCategory;
import com.web.MyCourseWeb.services.CourseCategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courseCategories")
public class CourseCategoryController {

    private final CourseCategoryService courseCategoryService;

    public CourseCategoryController(CourseCategoryService courseCategoryService) {
        this.courseCategoryService = courseCategoryService;
    }

    // Tüm kurs kategorilerini getir
    @GetMapping
    public List<CourseCategory> getAllCourseCategories() {
        return courseCategoryService.getAllCourseCategories();
    }

    // Yeni bir kurs kategorisi oluştur
    @PostMapping
    public CourseCategory createCourseCategory(@RequestBody CourseCategory newCourseCategory) {
        return courseCategoryService.saveOneCourseCategory(newCourseCategory);
    }

    // Tek bir kurs kategorisini getir
    @GetMapping("/{courseCategoryID}")
    public CourseCategory getOneCourseCategory(@PathVariable Long courseCategoryID) {
        return courseCategoryService.getOneCourseCategory(courseCategoryID);
    }

    // Var olan bir kurs kategorisini güncelle
    @PutMapping("/{courseCategoryID}")
    public CourseCategory updateOneCourseCategory(@PathVariable Long courseCategoryID, @RequestBody CourseCategory newCourseCategory) {
        return courseCategoryService.updateOneCourseCategory(courseCategoryID, newCourseCategory);
    }

    // Tek bir kurs kategorisini sil
    @DeleteMapping("/{courseCategoryID}")
    public void deleteOneCourseCategory(@PathVariable Long courseCategoryID) {
        courseCategoryService.deleteOneCourseCategory(courseCategoryID);
    }

    // Tüm kurs kategorilerini sil
    @DeleteMapping
    public void deleteAllCourseCategories() {
        courseCategoryService.deleteAllCourseCategories();
    }
}
