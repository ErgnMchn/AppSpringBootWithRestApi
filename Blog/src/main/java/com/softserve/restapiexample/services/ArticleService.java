package com.softserve.restapiexample.services;

import com.softserve.restapiexample.dto.ArticleDTO;
import com.softserve.restapiexample.model.Article;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ArticleService {
    List<ArticleDTO> findAllArticles();
    void deleteArticleById(long id);
    void createArticle(Article article);
    Article updateArticleById(Article newArticle, long id);
    ArticleDTO getArticleById(Long id);
}
