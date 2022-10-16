package com.softserve.restapiexample.service;

import com.softserve.restapiexample.dto.ArticleDTO;
import com.softserve.restapiexample.model.Article;

import java.util.List;
public interface ArticleService {
    List<ArticleDTO> findAllArticles();
    void deleteArticleById(long id);
    void createArticle(Article article);
    Article updateArticleById(Article newArticle, long id);
    ArticleDTO getArticleById(Long id);
}
