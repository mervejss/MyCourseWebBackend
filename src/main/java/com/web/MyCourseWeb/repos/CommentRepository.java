package com.web.MyCourseWeb.repos;

import com.web.MyCourseWeb.entities.Comment;
import com.web.MyCourseWeb.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CommentRepository extends JpaRepository<Comment,Long> {
    Optional<Comment> findByUserID_UserIDAndCourseID_CourseID(Long userID, Long courseID);
    List<Comment> findByCourseID_CourseID(Long courseID);

}
