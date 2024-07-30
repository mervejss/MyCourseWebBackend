package com.web.MyCourseWeb.controllers;

import com.web.MyCourseWeb.dtos.CourseCategoryDTO;
import com.web.MyCourseWeb.services.CourseCategoryService;
import org.springframework.http.ResponseEntity;
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
    public List<CourseCategoryDTO> getAllCourseCategories() {
        return courseCategoryService.getAllCourseCategories();
    }

    // Birden fazla kurs kategorisi oluştur
    @PostMapping
    public List<CourseCategoryDTO> createCourseCategories(@RequestBody List<CourseCategoryDTO> newCourseCategoryDTOs) {
        return courseCategoryService.saveAllCourseCategories(newCourseCategoryDTOs);
    }

    // Tek bir kurs kategorisini getir
    @GetMapping("/{courseCategoryID}")
    public ResponseEntity<CourseCategoryDTO> getOneCourseCategory(@PathVariable Long courseCategoryID) {
        CourseCategoryDTO courseCategoryDTO = courseCategoryService.getOneCourseCategory(courseCategoryID);
        return courseCategoryDTO != null ? ResponseEntity.ok(courseCategoryDTO) : ResponseEntity.notFound().build();
    }

    // Var olan bir kurs kategorisini güncelle
    @PutMapping("/{courseCategoryID}")
    public ResponseEntity<CourseCategoryDTO> updateOneCourseCategory(@PathVariable Long courseCategoryID, @RequestBody CourseCategoryDTO newCourseCategoryDTO) {
        CourseCategoryDTO updatedCourseCategoryDTO = courseCategoryService.updateOneCourseCategory(courseCategoryID, newCourseCategoryDTO);
        return updatedCourseCategoryDTO != null ? ResponseEntity.ok(updatedCourseCategoryDTO) : ResponseEntity.notFound().build();
    }

    // Tek bir kurs kategorisini sil
    @DeleteMapping("/{courseCategoryID}")
    public ResponseEntity<Void> deleteOneCourseCategory(@PathVariable Long courseCategoryID) {
        courseCategoryService.deleteOneCourseCategory(courseCategoryID);
        return ResponseEntity.noContent().build();
    }

    // Tüm kurs kategorilerini sil
    @DeleteMapping
    public void deleteAllCourseCategories() {
        courseCategoryService.deleteAllCourseCategories();
    }
}
