package com.web.MyCourseWeb.repos;

import com.web.MyCourseWeb.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CourseRepository extends JpaRepository<Course,Long> {
}
