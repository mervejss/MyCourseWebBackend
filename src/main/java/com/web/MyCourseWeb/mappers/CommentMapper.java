package com.web.MyCourseWeb.mappers;

import com.web.MyCourseWeb.dtos.CommentDTO;
import com.web.MyCourseWeb.entities.Comment;
import com.web.MyCourseWeb.entities.Course;
import com.web.MyCourseWeb.entities.User;

public class CommentMapper {

    public static CommentDTO toDTO(Comment comment) {
        CommentDTO commentDTO = new CommentDTO();
        commentDTO.setCommentID(comment.getCommentID());
        commentDTO.setUserID(comment.getUserID().getUserID());
        commentDTO.setCourseID(comment.getCourseID().getCourseID());
        commentDTO.setCommentDescription(comment.getCommentDescription());
        commentDTO.setCommentScore(comment.getCommentScore());
        commentDTO.setCreatedAt(comment.getCreatedAt());
        commentDTO.setUpdatedAt(comment.getUpdatedAt());
        return commentDTO;
    }

    public static Comment toEntity(CommentDTO commentDTO) {
        Comment comment = new Comment();
        comment.setCommentID(commentDTO.getCommentID());

        // User ve Course entity'lerini setlemek için sadece ID'ler yeterli olmayabilir,
        // bu yüzden burada dummy objeler kullanarak ID'leri setleyebiliriz.
        User user = new User();
        user.setUserID(commentDTO.getUserID());
        comment.setUserID(user);

        Course course = new Course();
        course.setCourseID(commentDTO.getCourseID());
        comment.setCourseID(course);

        comment.setCommentDescription(commentDTO.getCommentDescription());
        comment.setCommentScore(commentDTO.getCommentScore());
        comment.setCreatedAt(commentDTO.getCreatedAt());
        comment.setUpdatedAt(commentDTO.getUpdatedAt());
        return comment;
    }
}
