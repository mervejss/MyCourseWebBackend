package com.web.MyCourseWeb.services;

import com.web.MyCourseWeb.entities.CourseProgress;
import com.web.MyCourseWeb.repos.CourseProgressRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseProgressService {

    private final CourseProgressRepository courseProgressRepository;

    public CourseProgressService(CourseProgressRepository courseProgressRepository) {
        this.courseProgressRepository = courseProgressRepository;
    }

    public List<CourseProgress> getAllCourseProgresses() {
        return courseProgressRepository.findAll();
    }

    public CourseProgress saveOneCourseProgress(CourseProgress newCourseProgress) {
        return courseProgressRepository.save(newCourseProgress);
    }

    public CourseProgress getOneCourseProgress(Long courseProgressID) {
        return courseProgressRepository.findById(courseProgressID).orElse(null);
    }

    public CourseProgress updateOneCourseProgress(Long courseProgressID, CourseProgress newCourseProgress) {
        Optional<CourseProgress> courseProgress = courseProgressRepository.findById(courseProgressID);
        if (courseProgress.isPresent()) {
            CourseProgress foundCourseProgress = courseProgress.get();
            foundCourseProgress.setUserID(newCourseProgress.getUserID());
            foundCourseProgress.setUserProgressTime(newCourseProgress.getUserProgressTime());
            courseProgressRepository.save(foundCourseProgress);
            return foundCourseProgress;
        } else {
            return null;
        }
    }

    public void deleteOneCourseProgress(Long courseProgressID) {
        courseProgressRepository.deleteById(courseProgressID);
    }

    public void deleteAllCourseProgress() {
        courseProgressRepository.deleteAll();
    }
}
