package com.softserve.restapiexample.controller;

import com.softserve.restapiexample.dto.ArticleDTO;
import com.softserve.restapiexample.exception.ArticleNotFoundException;
import com.softserve.restapiexample.exception.ErrorResponse;
import com.softserve.restapiexample.model.Article;
import com.softserve.restapiexample.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@Validated
@RequestMapping("/api/v1/article")
public class ArticleController {
  @Autowired private ArticleService articleService;

  @GetMapping()
  public List<ArticleDTO> findAllArticles() {
    return articleService.findAllArticles();
  }

  @PostMapping()
  public void createArticle(@RequestBody Article article) {
    articleService.createArticle(article);
  }

  @GetMapping("/{id}")
  public ArticleDTO getArticleById(@PathVariable("id") long id) {
    return articleService.getArticleById(id);
  }

  @PutMapping("/{id}")
  public Article updateArticleById(@PathVariable Article article, @RequestBody long id) {
    return articleService.updateArticleById(article, id);
  }

  @DeleteMapping("/{id}")
  public void deleteUserById(@PathVariable Long id) {
    articleService.deleteArticleById(id);
  }

  @ExceptionHandler(value = ArticleNotFoundException.class)
  @ResponseStatus(HttpStatus.CONFLICT)
  public ErrorResponse handleArticleNotFoundException(ArticleNotFoundException e) {
    return new ErrorResponse(HttpStatus.CONFLICT.value(), e.getMessage());
  }
}
