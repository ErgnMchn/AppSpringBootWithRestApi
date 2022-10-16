package com.softserve.restapiexample.services;

import com.softserve.restapiexample.dto.CommentDTO;
import com.softserve.restapiexample.model.Comment;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface CommentService {
    List<CommentDTO> findAllComments();
    void deleteCommentById(long id);
    void createComment(Comment comment);
    CommentDTO getCommentById(Long id);
    Comment updateCommentById(long id, Comment newComment);

}
