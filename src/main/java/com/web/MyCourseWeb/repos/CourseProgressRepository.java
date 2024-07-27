package com.web.MyCourseWeb.repos;

import com.web.MyCourseWeb.entities.CourseProgress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseProgressRepository extends JpaRepository<CourseProgress,Long> {
}
