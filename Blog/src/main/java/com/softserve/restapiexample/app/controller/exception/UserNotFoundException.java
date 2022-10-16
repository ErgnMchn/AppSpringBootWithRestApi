package com.softserve.restapiexample.app.controller.exception;

public class UserNotFoundException extends RuntimeException {
  private String message;

  public UserNotFoundException(String message) {
    super(message);
    this.message = message;
  }
}
