package com.softserve.restapiexample.repository;

import com.softserve.restapiexample.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article,Long> {
}
