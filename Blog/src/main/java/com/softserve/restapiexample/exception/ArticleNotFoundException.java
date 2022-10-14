package com.softserve.restapiexample.exception;

public class ArticleNotFoundException extends RuntimeException {
  private String message;

  public ArticleNotFoundException(String message) {
    super(message);
    this.message = message;
  }
}
