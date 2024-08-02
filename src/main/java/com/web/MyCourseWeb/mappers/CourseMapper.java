package com.web.MyCourseWeb.mappers;

import com.web.MyCourseWeb.dtos.CourseDTO;
import com.web.MyCourseWeb.entities.Course;
import com.web.MyCourseWeb.entities.CourseCategory;
import com.web.MyCourseWeb.entities.User;

public class CourseMapper {

    public static CourseDTO toCourseDTO(Course course) {
        if (course == null) {
            return null;
        }

        CourseDTO courseDTO = new CourseDTO();
        courseDTO.setCourseID(course.getCourseID());
        courseDTO.setCourseCategoryID(course.getCourseCategoryID() != null ? course.getCourseCategoryID().getCourseCategoryID() : null);
        courseDTO.setUserID(course.getUserID() != null ? course.getUserID().getUserID() : null);
        courseDTO.setCourseName(course.getCourseName());
        courseDTO.setCourseDescription(course.getCourseDescription());
        courseDTO.setCourseTotalTime(course.getCourseTotalTime());
        courseDTO.setCoursePrice(course.getCoursePrice());
        courseDTO.setCourseScore(course.getCourseScore());

        courseDTO.setCreatedAt(course.getCreatedAt());

        return courseDTO;
    }

    public static Course toCourse(CourseDTO courseDTO, CourseCategory courseCategory, User user) {
        if (courseDTO == null) {
            return null;
        }

        Course course = new Course();
        course.setCourseID(courseDTO.getCourseID());
        course.setCourseCategoryID(courseCategory);
        course.setUserID(user);
        course.setCourseName(courseDTO.getCourseName());
        course.setCourseDescription(courseDTO.getCourseDescription());
        course.setCourseTotalTime(courseDTO.getCourseTotalTime());
        course.setCoursePrice(courseDTO.getCoursePrice());
        course.setCourseScore(courseDTO.getCourseScore());

        course.setCreatedAt(courseDTO.getCreatedAt());

        return course;
    }
}
