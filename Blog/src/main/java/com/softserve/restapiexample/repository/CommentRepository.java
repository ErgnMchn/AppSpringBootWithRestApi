package com.softserve.restapiexample.repository;

import com.softserve.restapiexample.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment,Long> {
}
