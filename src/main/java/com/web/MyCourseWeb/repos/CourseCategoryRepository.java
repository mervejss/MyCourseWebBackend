package com.web.MyCourseWeb.repos;

import com.web.MyCourseWeb.entities.CourseCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseCategoryRepository  extends JpaRepository<CourseCategory,Long> {

    List<CourseCategory> findByParentCategoryIsNull();

    List<CourseCategory> findByParentCategory_CourseCategoryID(Long parentCategoryID);


}
