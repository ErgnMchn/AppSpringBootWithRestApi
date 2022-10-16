package com.softserve.restapiexample.app.controller.repository;

import com.softserve.restapiexample.app.controller.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment,Long> {
}
