package com.softserve.restapiexample.exception;

public class UserAlreadyExistException extends RuntimeException {
  private String message;

  public UserAlreadyExistException(String message) {
    super(message);
    this.message = message;
  }
}
