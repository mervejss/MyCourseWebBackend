package com.web.MyCourseWeb.services;

import com.web.MyCourseWeb.entities.CourseCategory;
import com.web.MyCourseWeb.repos.CourseCategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseCategoryService {

    private final CourseCategoryRepository courseCategoryRepository;

    public CourseCategoryService(CourseCategoryRepository courseCategoryRepository) {
        this.courseCategoryRepository = courseCategoryRepository;
    }

    // Tüm kurs kategorilerini getir
    public List<CourseCategory> getAllCourseCategories() {
        return courseCategoryRepository.findAll();
    }

//    // Yeni bir kurs kategorisi oluştur
//    public CourseCategory saveOneCourseCategory(CourseCategory newCourseCategory) {
//        return courseCategoryRepository.save(newCourseCategory);
//    }

    // Birden fazla kurs kategorisini kaydet
    public List<CourseCategory> saveAllCourseCategories(List<CourseCategory> newCourseCategories) {
        return courseCategoryRepository.saveAll(newCourseCategories);
    }

    // Tek bir kurs kategorisini getir
    public CourseCategory getOneCourseCategory(Long courseCategoryID) {
        return courseCategoryRepository.findById(courseCategoryID).orElse(null);
    }

    // Var olan bir kurs kategorisini güncelle
    public CourseCategory updateOneCourseCategory(Long courseCategoryID, CourseCategory newCourseCategory) {
        Optional<CourseCategory> optionalCourseCategory = courseCategoryRepository.findById(courseCategoryID);
        if (optionalCourseCategory.isPresent()) {
            CourseCategory existingCourseCategory = optionalCourseCategory.get();
            existingCourseCategory.setCourseCategoryName(newCourseCategory.getCourseCategoryName());
            // Başka güncellenmesi gereken alanlar varsa, buraya ekle
            return courseCategoryRepository.save(existingCourseCategory);
        }
        return null;
    }

    // Tek bir kurs kategorisini sil
    public void deleteOneCourseCategory(Long courseCategoryID) {
        courseCategoryRepository.deleteById(courseCategoryID);
    }

    // Tüm kurs kategorilerini sil
    public void deleteAllCourseCategories() {
        courseCategoryRepository.deleteAll();
    }
}
