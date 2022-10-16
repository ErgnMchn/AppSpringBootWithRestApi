package com.softserve.restapiexample.service;

import com.softserve.restapiexample.exception.UserNotFoundException;
import com.softserve.restapiexample.dto.ArticleDTO;
import com.softserve.restapiexample.exception.ArticleNotFoundException;
import com.softserve.restapiexample.model.Article;
import com.softserve.restapiexample.repository.ArticleRepository;
import com.softserve.restapiexample.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ArticleServiceImpl implements ArticleService {

  @Autowired private ArticleRepository articleRepository;
  @Autowired private Mapper mapper;

  public List<ArticleDTO> findAllArticles() {
    List<Article> articles = articleRepository.findAll();

    if (!articles.isEmpty()) {

      return articleRepository.findAll().stream()
          .map(article -> mapper.mapArticleToDTO(article))
          .collect(Collectors.toList());

    } else {

      throw new ArticleNotFoundException("Article Not Found");
    }
  }

  public void deleteArticleById(long id) {
    Article article = articleRepository.findById(id).orElse(null);
    if (article == null) {

      throw new ArticleNotFoundException("NO ARTICLE PRESENT WITH ID =" + id);
    } else {

      articleRepository.delete(article);
    }
  }

  public void createArticle(Article article) {
    articleRepository.save(article);
  }

  public Article updateArticleById(Article newArticle, long id) {
    Article existingArticle = articleRepository.findById(id).orElse(null);
    if (existingArticle == null) {
      throw new ArticleNotFoundException("No Such Article Exists!!");
    } else {

      existingArticle.setArticleName(newArticle.getArticleName());
      existingArticle.setArticleContent(newArticle.getArticleContent());
      existingArticle.setArticleLikeCount(newArticle.getArticleLikeCount());
      existingArticle.setArticleCreatedAt(newArticle.getArticleCreatedAt());

      return articleRepository.save(existingArticle);
    }
  }

  public ArticleDTO getArticleById(Long id) {
    ArticleDTO articleDTO =
        articleRepository.findById(id).map(article -> mapper.mapArticleToDTO(article)).orElse(null);

    if (articleDTO != null) {
      return articleDTO;
    } else {
      throw new UserNotFoundException("NO USER PRESENT WITH ID =" + id);
    }
  }
}
