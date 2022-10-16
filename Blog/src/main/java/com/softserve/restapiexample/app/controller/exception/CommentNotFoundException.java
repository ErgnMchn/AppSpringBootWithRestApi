package com.softserve.restapiexample.app.controller.exception;

public class CommentNotFoundException extends RuntimeException {
  private String message;

  public CommentNotFoundException(String message) {
    super(message);
    this.message = message;
  }
}
