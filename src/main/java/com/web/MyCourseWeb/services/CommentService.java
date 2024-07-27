package com.web.MyCourseWeb.services;

import com.web.MyCourseWeb.entities.Comment;
import com.web.MyCourseWeb.repos.CommentRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CommentService {

    private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    // Tüm yorumları getir
    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }

    // Tek bir yorum getir
    public Comment getOneComment(Long commentID) {
        return commentRepository.findById(commentID).orElse(null);
    }

    // Yeni bir yorum oluştur
    public Comment saveOneComment(Comment newComment) {
        return commentRepository.save(newComment);
    }

    public Comment updateOneComment(Long commentID, Comment newComment) {
        Optional<Comment> optionalComment = commentRepository.findById(commentID);
        if (optionalComment.isPresent()) {
            Comment existingComment = optionalComment.get();
            existingComment.setCommentDescription(newComment.getCommentDescription());
            existingComment.setCommentScore(newComment.getCommentScore());
            existingComment.setUser(newComment.getUser());
            existingComment.setCourse(newComment.getCourse());
            existingComment.setUpdatedAt(new Date()); // Optional, as @PreUpdate will handle this
            return commentRepository.save(existingComment);
        }
        return null;
    }

    // Tek bir yorumu sil
    public void deleteOneComment(Long commentID) {
        commentRepository.deleteById(commentID);
    }

    // Tüm yorumları sil
    public void deleteAllComments() {
        commentRepository.deleteAll();
    }
}
