package com.web.MyCourseWeb.mappers;

import com.web.MyCourseWeb.dtos.CourseProgressDTO;
import com.web.MyCourseWeb.entities.CourseProgress;
import com.web.MyCourseWeb.entities.User;

public class CourseProgressMapper {

    public static CourseProgressDTO toDTO(CourseProgress courseProgress) {
        CourseProgressDTO courseProgressDTO = new CourseProgressDTO();
        courseProgressDTO.setCourseProgressID(courseProgress.getCourseProgressID());
        courseProgressDTO.setUserID(courseProgress.getUserID().getUserID()); // User entity'sindeki userID
        courseProgressDTO.setUserProgressTime(courseProgress.getUserProgressTime());
        courseProgressDTO.setCreatedAt(courseProgress.getCreatedAt());
        return courseProgressDTO;
    }

    public static CourseProgress toEntity(CourseProgressDTO courseProgressDTO) {
        CourseProgress courseProgress = new CourseProgress();
        courseProgress.setCourseProgressID(courseProgressDTO.getCourseProgressID());

        User user = new User();
        user.setUserID(courseProgressDTO.getUserID());
        courseProgress.setUserID(user);

        courseProgress.setUserProgressTime(courseProgressDTO.getUserProgressTime());
        courseProgress.setCreatedAt(courseProgressDTO.getCreatedAt());
        return courseProgress;
    }
}
