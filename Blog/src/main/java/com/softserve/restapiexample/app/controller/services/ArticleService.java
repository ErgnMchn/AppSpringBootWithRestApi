package com.softserve.restapiexample.app.controller.services;

import com.softserve.restapiexample.app.controller.dto.ArticleDTO;
import com.softserve.restapiexample.app.controller.model.Article;
import org.springframework.stereotype.Service;

import java.util.List;
public interface ArticleService {
    List<ArticleDTO> findAllArticles();
    void deleteArticleById(long id);
    void createArticle(Article article);
    Article updateArticleById(Article newArticle, long id);
    ArticleDTO getArticleById(Long id);
}
