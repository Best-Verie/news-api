package com.example.newsapi.controller;

import com.example.newsapi.dto.CommentDto;
import com.example.newsapi.model.Comment;
import com.example.newsapi.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @PostMapping("/create")
    public Comment createComment(@RequestBody CommentDto commentDto){
        return commentService.createComment(commentDto);
    }

    @GetMapping("/all")
    public List<Comment> getAllComments(){
        return commentService.getAllComments();
    }
}
