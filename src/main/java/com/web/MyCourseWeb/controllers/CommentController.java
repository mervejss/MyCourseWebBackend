package com.web.MyCourseWeb.controllers;

import com.web.MyCourseWeb.entities.Comment;
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
    public List<Comment> getAllComments() {
        return commentService.getAllComments();
    }

    // Yeni bir yorum oluştur
    @PostMapping
    public Comment createComment(@RequestBody Comment newComment) {
        return commentService.saveOneComment(newComment);
    }

    // Tek bir yorumu getir
    @GetMapping("/{commentID}")
    public Comment getOneComment(@PathVariable Long commentID) {
        return commentService.getOneComment(commentID);
    }

    // Var olan bir yorumu güncelle
    @PutMapping("/{commentID}")
    public Comment updateOneComment(@PathVariable Long commentID, @RequestBody Comment newComment) {
        return commentService.updateOneComment(commentID, newComment);
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
