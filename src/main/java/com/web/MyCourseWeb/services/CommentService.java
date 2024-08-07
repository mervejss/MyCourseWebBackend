package com.web.MyCourseWeb.services;

import com.web.MyCourseWeb.dtos.CommentDTO;
import com.web.MyCourseWeb.entities.Comment;
import com.web.MyCourseWeb.entities.Course;
import com.web.MyCourseWeb.entities.User;
import com.web.MyCourseWeb.mappers.CommentMapper;
import com.web.MyCourseWeb.repos.CommentRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CommentService {

    private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    // Tüm yorumları getir
    public List<CommentDTO> getAllComments() {
        return commentRepository.findAll().stream()
                .map(CommentMapper::toDTO)
                .collect(Collectors.toList());
    }

    // Tek bir yorum getir
    public CommentDTO getOneComment(Long commentID) {
        return commentRepository.findById(commentID)
                .map(CommentMapper::toDTO)
                .orElse(null);
    }

    // Yeni bir yorum oluştur
    public CommentDTO saveOneComment(CommentDTO newCommentDTO) {
        Comment newComment = CommentMapper.toEntity(newCommentDTO);
        return CommentMapper.toDTO(commentRepository.save(newComment));
    }

    public CommentDTO updateOneComment(Long commentID, CommentDTO newCommentDTO) {
        Optional<Comment> optionalComment = commentRepository.findById(commentID);
        if (optionalComment.isPresent()) {
            Comment existingComment = optionalComment.get();
            existingComment.setCommentDescription(newCommentDTO.getCommentDescription());
            existingComment.setCommentScore(newCommentDTO.getCommentScore());

            User user = new User();
            user.setUserID(newCommentDTO.getUserID());
            existingComment.setUserID(user);

            Course course = new Course();
            course.setCourseID(newCommentDTO.getCourseID());
            existingComment.setCourseID(course);

            existingComment.setUpdatedAt(new Date()); // Optional, as @PreUpdate will handle this
            return CommentMapper.toDTO(commentRepository.save(existingComment));
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

    // Var olan bir yorumu kontrol et ve gerekirse güncelle
    public CommentDTO saveOrUpdateComment(CommentDTO commentDTO) {
        Optional<Comment> existingCommentOpt = commentRepository.findByUserID_UserIDAndCourseID_CourseID(
                commentDTO.getUserID(), commentDTO.getCourseID());

        Comment comment;
        if (existingCommentOpt.isPresent()) {
            // Yorum var, güncelle
            comment = existingCommentOpt.get();
            comment.setCommentDescription(commentDTO.getCommentDescription());
            comment.setCommentScore(commentDTO.getCommentScore());
            comment.setUpdatedAt(new Date());
        } else {
            // Yorum yok, yeni oluştur
            comment = CommentMapper.toEntity(commentDTO);
            comment.setCreatedAt(new Date());
            comment.setUpdatedAt(new Date());
        }

        return CommentMapper.toDTO(commentRepository.save(comment));
    }

    // Kullanıcı ve kurs ID'sine göre yorum getir
    public Optional<CommentDTO> getCommentByUserAndCourse(Long userID, Long courseID) {
        return commentRepository.findByUserID_UserIDAndCourseID_CourseID(userID, courseID)
                .map(CommentMapper::toDTO);
    }

}
