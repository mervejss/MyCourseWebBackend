package com.web.MyCourseWeb.repos;

import com.web.MyCourseWeb.entities.Comment;
import com.web.MyCourseWeb.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment,Long> {
}
