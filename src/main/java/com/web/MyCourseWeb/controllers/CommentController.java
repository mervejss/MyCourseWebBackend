package com.web.MyCourseWeb.controllers;

import com.web.MyCourseWeb.dtos.CommentDTO;
import com.web.MyCourseWeb.services.CommentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
}
