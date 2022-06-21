package com.example.newsapi.service;

import com.example.newsapi.dto.CommentDto;
import com.example.newsapi.model.Article;
import com.example.newsapi.model.Comment;
import com.example.newsapi.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private ArticleService articleService;

    public Comment createComment(CommentDto commentDto){

        Comment comment = new Comment();
        comment.setComment(commentDto.getComment());
        comment.setAuthor(commentDto.getAuthor());
        System.out.println("commentDto" + commentDto);
        System.out.println(commentDto.getArticleId());
        Article article = articleService.getArticleById(commentDto.getArticleId()).get();
        System.out.println("article" + article);
        comment.setArticle(article);

        return commentRepository.save(comment);

    }

    public List<Comment> getAllComments(){
        return commentRepository.findAll();
    }


}
