package com.web.MyCourseWeb.controllers;

import com.web.MyCourseWeb.dtos.CommentDTO;
import com.web.MyCourseWeb.services.CommentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/comments")
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    // Tüm yorumları getir
    @GetMapping
    public List<CommentDTO> getAllComments() {
        return commentService.getAllComments();
    }

    // Yeni bir yorum oluştur
    @PostMapping
    public CommentDTO createComment(@RequestBody CommentDTO newCommentDTO) {
        return commentService.saveOneComment(newCommentDTO);
    }

    // Tek bir yorumu getir
    @GetMapping("/{commentID}")
    public CommentDTO getOneComment(@PathVariable Long commentID) {
        return commentService.getOneComment(commentID);
    }

    // Var olan bir yorumu güncelle
    @PutMapping("/{commentID}")
    public CommentDTO updateOneComment(@PathVariable Long commentID, @RequestBody CommentDTO newCommentDTO) {
        return commentService.updateOneComment(commentID, newCommentDTO);
    }

    // Tek bir yorumu sil
    @DeleteMapping("/{commentID}")
    public void deleteOneComment(@PathVariable Long commentID) {
        commentService.deleteOneComment(commentID);
    }

    // Tüm yorumları sil
    @DeleteMapping
    public void deleteAllComments() {
        commentService.deleteAllComments();
    }


    // Yorum ekle veya güncelle
    @PostMapping("/saveOrUpdate")
    public CommentDTO saveOrUpdateComment(@RequestBody CommentDTO commentDTO) {
        return commentService.saveOrUpdateComment(commentDTO);
    }


    // Kullanıcı ve kurs ID'sine göre yorum getir
    @GetMapping("/user/{userID}/course/{courseID}")
    public CommentDTO getCommentByUserAndCourse(@PathVariable Long userID, @PathVariable Long courseID) {
        Optional<CommentDTO> commentDTO = commentService.getCommentByUserAndCourse(userID, courseID);
        return commentDTO.orElse(new CommentDTO()); // Eğer yorum bulunamazsa boş bir DTO döndür
    }


    @GetMapping("/user/{userID}/course")
    public List<CommentDTO> getCommentsByUser(@PathVariable Long userID) {
        return commentService.getCommentsByUser(userID);
    }


    @GetMapping("/course/{courseID}")
    public List<CommentDTO> getCommentsByCourse(@PathVariable Long courseID) {
        return commentService.getCommentsByCourse(courseID);
    }


}
