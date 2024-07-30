package com.web.MyCourseWeb.services;

import com.web.MyCourseWeb.dtos.CourseProgressDTO;
import com.web.MyCourseWeb.entities.CourseProgress;
import com.web.MyCourseWeb.mappers.CourseProgressMapper;
import com.web.MyCourseWeb.repos.CourseProgressRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CourseProgressService {

    private final CourseProgressRepository courseProgressRepository;

    public CourseProgressService(CourseProgressRepository courseProgressRepository) {
        this.courseProgressRepository = courseProgressRepository;
    }

    public List<CourseProgressDTO> getAllCourseProgresses() {
        return courseProgressRepository.findAll().stream()
                .map(CourseProgressMapper::toDTO)
                .collect(Collectors.toList());
    }

    public CourseProgressDTO saveOneCourseProgress(CourseProgressDTO newCourseProgressDTO) {
        CourseProgress newCourseProgress = CourseProgressMapper.toEntity(newCourseProgressDTO);
        CourseProgress savedCourseProgress = courseProgressRepository.save(newCourseProgress);
        return CourseProgressMapper.toDTO(savedCourseProgress);
    }

    public CourseProgressDTO getOneCourseProgress(Long courseProgressID) {
        return courseProgressRepository.findById(courseProgressID)
                .map(CourseProgressMapper::toDTO)
                .orElse(null);
    }

    public CourseProgressDTO updateOneCourseProgress(Long courseProgressID, CourseProgressDTO newCourseProgressDTO) {
        Optional<CourseProgress> existingCourseProgressOpt = courseProgressRepository.findById(courseProgressID);
        if (existingCourseProgressOpt.isPresent()) {
            CourseProgress existingCourseProgress = existingCourseProgressOpt.get();
            CourseProgress updatedCourseProgress = CourseProgressMapper.toEntity(newCourseProgressDTO);
            updatedCourseProgress.setCourseProgressID(existingCourseProgress.getCourseProgressID());
            courseProgressRepository.save(updatedCourseProgress);
            return CourseProgressMapper.toDTO(updatedCourseProgress);
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
