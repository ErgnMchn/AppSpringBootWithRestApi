package com.softserve.restapiexample.app.controller.exception;

public class ArticleNotFoundException extends RuntimeException {
  private String message;

  public ArticleNotFoundException(String message) {
    super(message);
    this.message = message;
  }
}
