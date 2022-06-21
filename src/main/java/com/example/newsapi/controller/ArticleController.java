package com.example.newsapi.controller;

import com.example.newsapi.dto.CreateArticleDto;
import com.example.newsapi.model.Article;
import com.example.newsapi.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @PostMapping("/create")
    public Article createArticle(@RequestBody CreateArticleDto articleDto){
        return articleService.createArticle(articleDto);
    }

    @GetMapping("/all")
    public List<Article> getAllArticles() {
        return articleService.getAllArticles();
    }

    @GetMapping("/{id}")
    public Optional<Article> getArticle(@PathVariable Long id){
        return articleService.getArticleById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteArticleById(@PathVariable Long id){
        articleService.deleteArticleById(id);
    }

    @PutMapping("/{id}")
    public Article updateArticle(@PathVariable Long id, @RequestBody CreateArticleDto articleDto){
        return articleService.updateArticle(id, articleDto);
    }




}
