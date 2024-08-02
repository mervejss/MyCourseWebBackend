package com.web.MyCourseWeb.services;

import com.web.MyCourseWeb.dtos.CourseCategoryDTO;
import com.web.MyCourseWeb.entities.CourseCategory;
import com.web.MyCourseWeb.mappers.CourseCategoryMapper;
import com.web.MyCourseWeb.repos.CourseCategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CourseCategoryService {

    private final CourseCategoryRepository courseCategoryRepository;

    public CourseCategoryService(CourseCategoryRepository courseCategoryRepository) {
        this.courseCategoryRepository = courseCategoryRepository;
    }

    // Tüm kurs kategorilerini getir
    public List<CourseCategoryDTO> getAllCourseCategories() {
        return courseCategoryRepository.findAll()
                .stream()
                .map(CourseCategoryMapper::toDTO)
                .collect(Collectors.toList());
    }

    // Birden fazla kurs kategorisini kaydet
    public List<CourseCategoryDTO> saveAllCourseCategories(List<CourseCategoryDTO> newCourseCategoryDTOs) {
        List<CourseCategory> courseCategories = newCourseCategoryDTOs.stream()
                .map(dto -> CourseCategoryMapper.toEntity(dto, getParentCategory(dto.getParentCategoryID())))
                .collect(Collectors.toList());

        return courseCategoryRepository.saveAll(courseCategories)
                .stream()
                .map(CourseCategoryMapper::toDTO)
                .collect(Collectors.toList());
    }

    // Tek bir kurs kategorisini getir
    public CourseCategoryDTO getOneCourseCategory(Long courseCategoryID) {
        return courseCategoryRepository.findById(courseCategoryID)
                .map(CourseCategoryMapper::toDTO)
                .orElse(null);
    }

    // Var olan bir kurs kategorisini güncelle
    public CourseCategoryDTO updateOneCourseCategory(Long courseCategoryID, CourseCategoryDTO newCourseCategoryDTO) {
        Optional<CourseCategory> optionalCourseCategory = courseCategoryRepository.findById(courseCategoryID);
        if (optionalCourseCategory.isPresent()) {
            CourseCategory existingCourseCategory = optionalCourseCategory.get();
            existingCourseCategory.setCourseCategoryName(newCourseCategoryDTO.getCourseCategoryName());
            existingCourseCategory.setParentCategory(getParentCategory(newCourseCategoryDTO.getParentCategoryID()));
            return CourseCategoryMapper.toDTO(courseCategoryRepository.save(existingCourseCategory));
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

    // Parent kategorisini ID ile getir
    private CourseCategory getParentCategory(Long parentCategoryID) {
        if (parentCategoryID == null) return null;
        return courseCategoryRepository.findById(parentCategoryID).orElse(null);
    }

    public List<CourseCategoryDTO> getMainCategories() {
        return courseCategoryRepository.findByParentCategoryIsNull()
                .stream()
                .map(CourseCategoryMapper::toDTO)
                .collect(Collectors.toList());
    }

    public List<CourseCategoryDTO> getSubCategories(Long parentCategoryID) {
        return courseCategoryRepository.findByParentCategory_CourseCategoryID(parentCategoryID)
                .stream()
                .map(CourseCategoryMapper::toDTO)
                .collect(Collectors.toList());
    }

}
