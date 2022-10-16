package com.softserve.restapiexample.app.controller.services;

import com.softserve.restapiexample.app.controller.dto.CommentDTO;
import com.softserve.restapiexample.app.controller.model.Comment;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CommentService {
    List<CommentDTO> findAllComments();
    void deleteCommentById(long id);
    void createComment(Comment comment);
    CommentDTO getCommentById(Long id);
    Comment updateCommentById(long id, Comment newComment);

}
