package com.softserve.restapiexample.app.controller.services;

import com.softserve.restapiexample.app.controller.dto.CommentDTO;
import com.softserve.restapiexample.app.controller.exception.CommentNotFoundException;
import com.softserve.restapiexample.app.controller.model.Comment;
import com.softserve.restapiexample.app.controller.repository.CommentRepository;
import com.softserve.restapiexample.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl implements CommentService {
  @Autowired private CommentRepository commentRepository;

  @Autowired private Mapper mapper;

  public List<CommentDTO> findAllComments() {

    List<Comment> comments = commentRepository.findAll();

    if (!comments.isEmpty()) {

      return commentRepository.findAll().stream()
          .map(comment -> mapper.mapCommentToDTO(comment))
          .collect(Collectors.toList());
    } else {
      throw new CommentNotFoundException("Comment Not Found");
    }
  }

  public void deleteCommentById(long id) {

    Comment comment = commentRepository.findById(id).orElse(null);
    if (comment == null) {

      throw new CommentNotFoundException("NO COMMENT PRESENT WITH ID =" + id);
    } else {

      commentRepository.delete(comment);
    }
  }

  public void createComment(Comment comment) {
    commentRepository.save(comment);
  }

  public CommentDTO getCommentById(Long id) {

    CommentDTO commentDTO =
        commentRepository.findById(id).map(comment -> mapper.mapCommentToDTO(comment)).orElse(null);

    if (commentDTO != null) {
      return commentDTO;
    } else {
      throw new CommentNotFoundException("NO COMMENT PRESENT WITH ID =" + id);
    }
  }

  public Comment updateCommentById(long id, Comment newComment) {
    Comment existingComment = commentRepository.findById(id).orElse(null);
    if (existingComment == null) {

      throw new CommentNotFoundException("No Such Comment Exists!!");
    } else {

      existingComment.setContent(newComment.getContent());

      return commentRepository.save(existingComment);
    }
  }
}
