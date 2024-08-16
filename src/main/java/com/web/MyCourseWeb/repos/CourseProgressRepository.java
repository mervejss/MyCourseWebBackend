package com.web.MyCourseWeb.repos;

import com.web.MyCourseWeb.entities.CourseProgress;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseProgressRepository extends JpaRepository<CourseProgress,Long> {
    List<CourseProgress> findByUserID_UserIDAndCourseID_CourseID(Long userID, Long courseID);

}
