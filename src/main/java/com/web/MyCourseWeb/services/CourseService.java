package com.web.MyCourseWeb.services;

import com.web.MyCourseWeb.dtos.CourseDTO;
import com.web.MyCourseWeb.entities.Comment;
import com.web.MyCourseWeb.entities.Course;
import com.web.MyCourseWeb.entities.CourseCategory;
import com.web.MyCourseWeb.entities.User;
import com.web.MyCourseWeb.mappers.CourseMapper;
import com.web.MyCourseWeb.repos.CommentRepository;
import com.web.MyCourseWeb.repos.CourseCategoryRepository;
import com.web.MyCourseWeb.repos.CourseRepository;
import com.web.MyCourseWeb.repos.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CourseService {

    private final CourseRepository courseRepository;
    private final CourseCategoryRepository courseCategoryRepository;
    private final UserRepository userRepository;
    private final CommentRepository commentRepository; // CommentRepository ekleyin

    public CourseService(CourseRepository courseRepository, CommentRepository commentRepository, CourseCategoryRepository courseCategoryRepository, UserRepository userRepository) {
        this.courseRepository = courseRepository;
        this.commentRepository = commentRepository; // CommentRepository'yi initialize edin
        this.courseCategoryRepository = courseCategoryRepository;
        this.userRepository = userRepository;
    }

    public List<CourseDTO> getAllCourses() {
        return courseRepository.findAll()
                .stream()
                .map(CourseMapper::toCourseDTO)
                .collect(Collectors.toList());
    }

    public CourseDTO saveOneCourse(CourseDTO newCourseDTO) {
        CourseCategory category = courseCategoryRepository.findById(newCourseDTO.getCourseCategoryID()).orElse(null);
        User user = userRepository.findById(newCourseDTO.getUserID()).orElse(null);

        Course newCourse = CourseMapper.toCourse(newCourseDTO, category, user);
        Course savedCourse = courseRepository.save(newCourse);

        return CourseMapper.toCourseDTO(savedCourse);
    }

    public CourseDTO getOneCourse(Long courseID) {
        Course course = courseRepository.findById(courseID).orElse(null);
        return CourseMapper.toCourseDTO(course);
    }

    public CourseDTO updateOneCourse(Long courseID, CourseDTO newCourseDTO) {
        Optional<Course> courseOpt = courseRepository.findById(courseID);
        if (courseOpt.isPresent()) {
            Course foundCourse = courseOpt.get();
            foundCourse.setCourseName(newCourseDTO.getCourseName());
            foundCourse.setCourseDescription(newCourseDTO.getCourseDescription());
            foundCourse.setCourseTotalTime(newCourseDTO.getCourseTotalTime());
            foundCourse.setCoursePrice(newCourseDTO.getCoursePrice());
            foundCourse.setCourseScore(newCourseDTO.getCourseScore());


            CourseCategory category = courseCategoryRepository.findById(newCourseDTO.getCourseCategoryID()).orElse(null);
            User user = userRepository.findById(newCourseDTO.getUserID()).orElse(null);
            foundCourse.setCourseCategoryID(category);
            foundCourse.setUserID(user);

            Course updatedCourse = courseRepository.save(foundCourse);
            return CourseMapper.toCourseDTO(updatedCourse);
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


    public Optional<Course> getCourseDetails(Long courseId) {
        return courseRepository.findById(courseId);
    }

    public Optional<CourseCategory> getCourseCategory(Long courseCategoryId) {
        return courseCategoryRepository.findById(courseCategoryId);
    }

    public Optional<User> getUser(Long userId) {
        return userRepository.findById(userId);
    }



    // Ortalama puanı hesaplayan metod
    public void updateCourseScore(Long courseID) {
        List<Comment> comments = commentRepository.findByCourseID_CourseID(courseID);
        if (comments.isEmpty()) {
            return; // Yorum yoksa işlem yapmayın
        }
        double averageScore = comments.stream()
                .mapToInt(Comment::getCommentScore)
                .average()
                .orElse(0.0);

        Course course = courseRepository.findById(courseID).orElse(null);
        if (course != null) {
            course.setCourseScore((int) Math.round(averageScore)); // Ortalama puanı yuvarlayarak güncelle
            courseRepository.save(course); // Kursu güncelle
        }
    }

    public List<CourseDTO> getCoursesByCategory(Long categoryId) {
        return courseRepository.findByCourseCategoryID_CourseCategoryID(categoryId)
                .stream()
                .map(CourseMapper::toCourseDTO)
                .collect(Collectors.toList());
    }

    public List<CourseDTO> getCoursesByUserID(Long userID) {
        return courseRepository.findByUserID_UserID(userID)
                .stream()
                .map(CourseMapper::toCourseDTO)
                .collect(Collectors.toList());
    }
}
