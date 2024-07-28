package com.web.MyCourseWeb.repos;

import com.web.MyCourseWeb.entities.CourseCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseCategoryRepository  extends JpaRepository<CourseCategory,Long> {
}
