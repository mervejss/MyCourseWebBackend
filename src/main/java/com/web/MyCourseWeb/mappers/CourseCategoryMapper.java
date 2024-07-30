package com.web.MyCourseWeb.mappers;

import com.web.MyCourseWeb.dtos.CourseCategoryDTO;
import com.web.MyCourseWeb.entities.CourseCategory;

public class CourseCategoryMapper {

    public static CourseCategoryDTO toDTO(CourseCategory courseCategory) {
        if (courseCategory == null) {
            return null;
        }

        CourseCategoryDTO dto = new CourseCategoryDTO();
        dto.setCourseCategoryID(courseCategory.getCourseCategoryID());
        dto.setCourseCategoryName(courseCategory.getCourseCategoryName());
        dto.setCreatedAt(courseCategory.getCreatedAt());

        if (courseCategory.getParentCategory() != null) {
            dto.setParentCategoryID(courseCategory.getParentCategory().getCourseCategoryID());
        }

        return dto;
    }

    public static CourseCategory toEntity(CourseCategoryDTO dto, CourseCategory parentCategory) {
        if (dto == null) {
            return null;
        }

        CourseCategory courseCategory = new CourseCategory();
        courseCategory.setCourseCategoryID(dto.getCourseCategoryID());
        courseCategory.setCourseCategoryName(dto.getCourseCategoryName());
        courseCategory.setCreatedAt(dto.getCreatedAt());
        courseCategory.setParentCategory(parentCategory);

        return courseCategory;
    }
}
