package com.softserve.restapiexample.app.controller.controller;

import com.softserve.restapiexample.app.controller.dto.CommentDTO;
import com.softserve.restapiexample.app.controller.exception.CommentNotFoundException;
import com.softserve.restapiexample.app.controller.exception.ErrorResponse;
import com.softserve.restapiexample.app.controller.model.Comment;
import com.softserve.restapiexample.app.controller.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/comment")
public class CommentController {
  @Autowired private CommentService commentService;

  @GetMapping
  public List<CommentDTO> findAllUsers() {
    return commentService.findAllComments();
  }

  @PostMapping()
  public void createComment(@RequestBody Comment comment) {
    commentService.createComment(comment);
  }

  @GetMapping("/{id}")
  public CommentDTO getCommentById(@PathVariable("id") long id) {
    return commentService.getCommentById(id);
  }

  @PutMapping("/{id}")
  public Comment updateCommentById(@RequestBody Comment newComment, @PathVariable long id) {
    return commentService.updateCommentById(id, newComment);
  }

  @DeleteMapping("/{id}")
  public void deleteCommentById(@PathVariable Long id) {
    commentService.deleteCommentById(id);
  }

  @ExceptionHandler(value = CommentNotFoundException.class)
  @ResponseStatus(HttpStatus.CONFLICT)
  public ErrorResponse handleCommentNotFoundException(CommentNotFoundException e) {
    return new ErrorResponse(HttpStatus.CONFLICT.value(), e.getMessage());
  }
}
