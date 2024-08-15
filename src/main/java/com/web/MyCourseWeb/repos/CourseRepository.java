package com.web.MyCourseWeb.repos;

import com.web.MyCourseWeb.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface CourseRepository extends JpaRepository<Course,Long> {

    List<Course> findByCourseCategoryID_CourseCategoryID(Long courseCategoryID);
    List<Course> findByUserID_UserID(Long userID);

}
