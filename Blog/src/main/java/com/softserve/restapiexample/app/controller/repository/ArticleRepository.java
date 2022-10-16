package com.softserve.restapiexample.app.controller.repository;

import com.softserve.restapiexample.app.controller.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article,Long> {
}
