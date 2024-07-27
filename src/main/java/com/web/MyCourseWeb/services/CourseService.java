package com.web.MyCourseWeb.services;

import com.web.MyCourseWeb.entities.Course;
import com.web.MyCourseWeb.repos.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Course saveOneCourse(Course newCourse) {
        return courseRepository.save(newCourse);
    }

    public Course getOneCourse(Long courseID) {
        return courseRepository.findById(courseID).orElse(null);
    }

    public Course updateOneCourse(Long courseID, Course newCourse) {
        Optional<Course> course = courseRepository.findById(courseID);
        if (course.isPresent()) {
            Course foundCourse = course.get();
            foundCourse.setCourseName(newCourse.getCourseName());
            foundCourse.setCourseDescription(newCourse.getCourseDescription());
            foundCourse.setCourseTotalTime(newCourse.getCourseTotalTime());
            foundCourse.setCoursePrice(newCourse.getCoursePrice());
            courseRepository.save(foundCourse);
            return foundCourse;
        } else {
            return null;
        }
    }

    public void deleteOneCourse(Long courseID) {
        courseRepository.deleteById(courseID);
    }

    public void deleteAllCourses() {
        courseRepository.deleteAll();
    }

}
