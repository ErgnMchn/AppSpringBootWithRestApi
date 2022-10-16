package com.softserve.restapiexample.service;

import com.softserve.restapiexample.dto.CommentDTO;
import com.softserve.restapiexample.model.Comment;

import java.util.List;

public interface CommentService {
    List<CommentDTO> findAllComments();
    void deleteCommentById(long id);
    void createComment(Comment comment);
    CommentDTO getCommentById(Long id);
    Comment updateCommentById(long id, Comment newComment);

}
