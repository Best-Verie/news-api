package com.example.newsapi.service;

import com.example.newsapi.dto.CreateArticleDto;
import com.example.newsapi.model.Article;
import com.example.newsapi.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArticleService {
    @Autowired
    ArticleRepository articleRepository;

    public Article createArticle(CreateArticleDto articleDto){
        Optional<Article> articleFound = articleRepository.findByTitle(articleDto.getTitle());
        if(articleFound.isPresent()){
            throw new RuntimeException("Article already exists");
        }
        Article article = new Article(articleDto.getTitle(), articleDto.getDescription(), articleDto.getUrlToImage(), articleDto.getContent());
        return articleRepository.save(article);

    }
    public List<Article> getAllArticles(){
        return articleRepository.findAll();
    }

    public Optional<Article> getArticleById(Long id){
        return articleRepository.findById(id);
    }

    public void deleteArticleById(Long id){
        articleRepository.deleteById(id);
    }

    public Article updateArticle(Long id, CreateArticleDto articleDto){
        Optional<Article> articleFound = articleRepository.findById(id);
        if(!articleFound.isPresent()){
           throw new RuntimeException("Article not found");
        }
        Article article = articleFound.get();
        article.setTitle(articleDto.getTitle());
        article.setDescription(articleDto.getDescription());
        article.setUrlToImage(articleDto.getUrlToImage());
        article.setContent(articleDto.getContent());
        return articleRepository.save(article);

    }
}
